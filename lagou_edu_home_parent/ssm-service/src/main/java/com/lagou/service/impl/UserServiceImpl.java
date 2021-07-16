package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author liu
 * @description UserService实现类
 * @date 2021/7/13 23:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /*
        分页，多条件查询用户
     */
    @Override
    public PageInfo findUserByPageAndCondition(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(), userVo.getPageSize());
        List<User> userList = userMapper.findUserByPageAndCondition(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }

    /*
        用户状态修改
     */
    @Override
    public void updateUserStatus(Integer id, String status) {
        // 补全参数
        User user = new User();
        user.setUpdate_time(new Date());
        user.setId(id);
        user.setStatus(status);

        // 调用接口
        userMapper.updateUserStatus(user);
    }

    /*
        用户登录
     */
    @Override
    public User login(User user) throws Exception {
        // 查询用户
        User user1 = userMapper.findUserByPhone(user);
        // 判断是否查询到是否存在
        // 存在则使用md5进行验证
        if(user1 != null && Md5.verify(user.getPassword(), "lagou", user1.getPassword())){
            // 验证通过则将查询出来的user返回
            return user1;
        }
        // 验证失败返回null
        return null;
    }

    /*
        用户角色信息回显
     */
    @Override
    public List<Role> findUserRoleById(Integer uid) {
        return userMapper.findUserRoleById(uid);
    }

    /*
        用户分配角色
    */
    @Override
    public void userContextRole(UserVo userVo) {
        // 删除用户关联的角色
        userMapper.deleteUserContextRole(userVo.getUserId());

        Date date = new Date();
        // 遍历角色Id列表
        for (Integer rid : userVo.getRoleIdList()) {
            // 封装数据
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(rid);
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            // 创建/更新者设置为system
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedBy("system");

            // 调用接口
            userMapper.saveUserContextRole(user_role_relation);
        }
    }

    /*
        获取用户权限
    */
    @Override
    public Map<String, Object> getUserPermissions(Integer uid) {
        // 获取用户关联的角色
        List<Role> roleList = userMapper.findUserRoleById(uid);
        // 遍历, 获取角色Id集合
        List<Integer> rids = new ArrayList<>();
        for (Role role : roleList) {
            rids.add(role.getId());
        }
        // 获取角色的父级菜单
        List<Menu> parentMenuList = userMapper.findParentMenuByRoleId(rids);
        // 获取父级菜单对应的子级菜单
        for (Menu menu : parentMenuList) {
            List<Menu> subMenuList = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenuList);
        }

        // 获取角色对应的资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(rids);

        // 封装数据
        Map<String, Object> map = new HashMap<>();
        map.put("menuList", parentMenuList);
        map.put("resourceList", resourceList);
        return map;
    }



}
