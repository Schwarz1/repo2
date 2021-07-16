package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

/**
 * @author liu
 * @description 权限菜单Service层接口
 * @date 2021/7/14 15:22
 */
public interface MenuService {
    /*
        查询所有父子菜单
     */
    List<Menu> findSubMenuByPid(Integer pid);

    /*
        根据角色Id查询所关联的菜单Id
     */
    List<Integer> findMenuIdByRoleId(Integer roleId);

    /*
        查询所有菜单
     */
    List<Menu> findAllMenu();

    /*
        根据Id查询菜单信息
     */
    Menu findMenuById(Integer id);
}
