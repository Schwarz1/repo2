package com.lagou.controller;

import com.lagou.domain.*;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @description 角色查询web层
 * @date 2021/7/14 14:05
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private MenuService menuService;

    /*
        根据条件查询所有角色
        POST请求
     */
    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> roleList = roleService.findAllRole(role);
        return new ResponseResult(true, 200, "角色信息查询成功", roleList);
    }

    /*
        查询所有父子菜单
        GET请求
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> menuList = menuService.findSubMenuByPid(-1);
        Map<String, Object> map = new HashMap<>();
        map.put("parentMenuList", menuList);

        return new ResponseResult(true, 200, "查询父子菜单成功", map);
    }

    /*
        根据角色Id查询所关联的菜单Id
        GET请求
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(@RequestParam("roleId")Integer roleId){
        List<Integer> menuIdList = menuService.findMenuIdByRoleId(roleId);
        return new ResponseResult(true, 200, "查询角色关联菜单信息成功", menuIdList);
    }

    /*
        更新角色关联菜单信息
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu(@RequestBody RoleMenuVo roleMenuVo){
        roleService.updateRoleContextMenu(roleMenuVo);

        return new ResponseResult(true, 200, "更新角色关联菜单信息成功", null);
    }

    /*
        删除角色记录
        GET请求
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(@RequestParam("id") Integer id){
        roleService.deleteRole(id);
        return new ResponseResult(true, 200, "角色记录删除成功", null);
    }

    /*---------作业部分------------*/

    /**
     * 查询角色拥有的所有资源信息
     * 以资源分类-资源的形式查询
     * GET请求
     * @param roleId 角色Id
     * @return json数据
     */
    @RequestMapping("/findResourceListByRoleId")
    public ResponseResult findResourceListByRoleId(@RequestParam("roleId")Integer roleId){
        List<ResourceCategory> resourceList = roleService.findResourceListByRoleId(roleId);
        return new ResponseResult(true, 200, "查询角色资源列表成功", resourceList);
    }

    /**
     * 更新角色资源关联信息
     * @param roleResourceVo 前端接收数据，角色Id，资源ID集合
     * @return json数据
     */
    @RequestMapping("/roleContextResource")
    public ResponseResult roleContextResource(@RequestBody RoleResourceVo roleResourceVo){
        roleService.roleContextResource(roleResourceVo);

        return new ResponseResult(true, 200, "更新角色资源信息成功", null);
    }
}
