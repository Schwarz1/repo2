package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**
 * @author liu
 * @description 角色Dao层
 * @date 2021/7/14 13:58
 */
public interface RoleMapper {
    /*
        按条件查询所有角色信息
     */
    List<Role> findAllRole(Role role);

    /*
        删除角色关联菜单信息
     */
    void deleteRoleContextMenu(Integer roleId);

    /*
        添加角色关联菜单信息
     */
    void addRoleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色记录
     */
    void deleteRole(Integer roleId);

    /*----------作业部分-------------*/
    /**
     * 根据角色Id查询当前角色拥有的资源分类信息
     * @param rid 角色Id
     * @return 资源分类信息列表
     */
    List<ResourceCategory> findResourceCategoryByRoleId(Integer rid);

    /**
     * 根据角色Id查询当前角色所拥有的所有资源信息
     * @param rid 角色Id
     * @return 资源信息列表
     */
    List<Resource> findResourceByRoleId(Integer rid);

    /**
     * 删除角色关联的资源信息
     * @param rid 角色Id
     */
    void deleteRoleContextResource(Integer rid);

    /**
     * 添加角色资源关联信息
     * @param roleResourceRelation 角色资源关联信息
     */
    void saveRoleContextResource(RoleResourceRelation roleResourceRelation);
}
