package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author liu
 * @description 用户Dao接口
 * @date 2021/7/13 23:27
 */
public interface UserMapper {
    /*
        分页，多条件查询用户信息
     */
    List<User> findUserByPageAndCondition(UserVo userVo);

    /*
        用户状态修改
     */
    void updateUserStatus(User user);

    /*
        通过手机号查询用户
     */
    User findUserByPhone(User user);

    /*
        根据用户Id查询用户所分配的角色
     */
    List<Role> findUserRoleById(Integer uid);

    /*
        删除用户关联的角色
     */
    void deleteUserContextRole(Integer uid);

    /*
        添加用户关联的角色
     */
    void saveUserContextRole(User_Role_relation user_role_relation);

    /*
        根据角色id集合查询所关联的顶级菜单信息
     */
    List<Menu> findParentMenuByRoleId(List<Integer> rid);

    /*
        根据父id查询子级菜单信息
     */
    List<Menu> findSubMenuByPid(Integer pid);

    /*
        根据角色id集合查询所关联的资源信息
     */
    List<Resource> findResourceByRoleId(List<Integer> rid);
}
