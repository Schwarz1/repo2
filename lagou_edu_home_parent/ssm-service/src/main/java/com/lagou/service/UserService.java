package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVo;

import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @description 用户Service层接口
 * @date 2021/7/13 23:40
 */
public interface UserService {
    /*
        分页，多条件查询用户
     */
    PageInfo findUserByPageAndCondition(UserVo userVo);

    /*
        用户状态修改
     */
    void updateUserStatus(Integer id, String status);

    /*
        用户登录
     */
    User login(User user) throws Exception;

    /*
        用户角色信息回显
     */
    List<Role> findUserRoleById(Integer uid);

    /*
        用户分配角色
     */
    void userContextRole(UserVo userVo);

    /*
        获取用户权限
     */
    Map<String, Object> getUserPermissions(Integer uid);
}
