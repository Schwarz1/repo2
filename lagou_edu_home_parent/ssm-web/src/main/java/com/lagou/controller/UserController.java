package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;
import com.lagou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @author liu
 * @description 用户web层
 * @date 2021/7/13 23:43
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*
        多条件，分页查询用户信息
     */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){
        PageInfo pageInfo = userService.findUserByPageAndCondition(userVo);
        return new ResponseResult(true, 200, "多条件分页查询用户信息成功", pageInfo);
    }

    /*
        修改用户状态
     */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(@RequestParam("id")Integer id,
                                           @RequestParam("status")String status){
        userService.updateUserStatus(id, status);
        Map<String, String> map = new HashMap<>();
        map.put("status", status);
        return new ResponseResult(true, 200, "用户状态更新成功", map);
    }

    /*
        用户登录
        GET请求
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {
        // 查询用户
        User user1 = userService.login(user);
        // 判断用户名密码是否正确
        if(user1 != null){
            // 生成access_token并与userId和user对象一起存放在session中
            String access_token = UUID.randomUUID().toString();
            HttpSession session = request.getSession();
            session.setAttribute("access_token", access_token);
            session.setAttribute("user_id", user1.getId());

            Map<String, Object> map = new HashMap<>();
            map.put("access_token", access_token);
            map.put("user_id", user1.getId());
            map.put("user", user1);

            return new ResponseResult(true, 1, "success", map);
        }
        // 不正确，返回失败的信息
        return new ResponseResult(true, 400, "用户名密码错误", user1);
    }

    /*
        用户角色信息回显
        GET请求
     */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRoleById(@RequestParam("id") Integer id){
        List<Role> roleList = userService.findUserRoleById(id);
        return new ResponseResult(true, 200, "用户角色信息回显成功", roleList);
    }

    /*
        用户分配角色信息
     */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);

        return new ResponseResult(true, 200, "用户分配角色成功", null);
    }

    /*
        获取用户权限
        GET请求
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){
        // 获取请求头中的Authorization
        String head_token = request.getHeader("Authorization");
        // 获取Session中的token
        String access_token = (String)request.getSession().getAttribute("access_token");

        // 判断两个token信息是否相同
        if(head_token.equals(access_token)){
            // 获取用户id
            Integer user_id = (Integer)request.getSession().getAttribute("user_id");
            // 获取用户权限
            Map<String, Object> map = userService.getUserPermissions(user_id);

            return new ResponseResult(true, 200, "获取用户权限成功", map);
        }else{
            return new ResponseResult(true, 400, "获取失败", null);
        }
    }
}
