package com.lagou.service.impl;

import com.lagou.dao.MenuMapper;
import com.lagou.domain.Menu;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liu
 * @description MenuService实现类
 * @date 2021/7/14 15:23
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /*
        查询所有父子菜单
     */
    @Override
    public List<Menu> findSubMenuByPid(Integer pid) {
        return menuMapper.findSubMenuByPid(pid);
    }

    /*
        根据角色Id查询所关联的菜单Id
     */
    @Override
    public List<Integer> findMenuIdByRoleId(Integer roleId) {
        return menuMapper.findMenuIdByRoleId(roleId);
    }

    /*
        查询所有菜单列表
    */
    @Override
    public List<Menu> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    /*
        根据Id查询菜单信息
     */
    @Override
    public Menu findMenuById(Integer id) {
        return menuMapper.findMenuById(id);
    }
}
