package com.lagou.dao;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author liu
 * @description 菜单查询Dao接口
 * @date 2021/7/14 15:13
 */
public interface MenuMapper {
    /*
        查询所有菜单及其子菜单
     */
    List<Menu> findSubMenuByPid(Integer pid);

    /*
        根据角色Id查询关联的菜单Id
     */
    List<Integer> findMenuIdByRoleId(Integer roleId);

    /*
        查询菜单列表
     */
    List<Menu> findAllMenu();

    /*
        根据Id查询菜单
     */
    Menu findMenuById(Integer id);
}
