package com.lagou.service;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.RoleResourceVo;

import java.util.List;

/**
 * @author liu
 * @description 角色查询Service层接口
 * @date 2021/7/14 14:03
 */
public interface RoleService {
    /*
        按条件查询所有角色
     */
    List<Role> findAllRole(Role role);

    /*
        更新角色关联菜单
     */
    void updateRoleContextMenu(RoleMenuVo roleMenuVo);

    /*
        删除角色记录
     */
    void deleteRole(Integer roleId);

    /*------------作业部分---------------*/

    /**
     * 根据角色id查询当前角色所拥有的资源信息
     * 并按照资源分类-资源进行查询
     * @param rid 角色id
     * @return 资源分类列表，其中包含了当前角色在该分类下拥有的资源
     */
    List<ResourceCategory> findResourceListByRoleId(Integer rid);

    /**
     * 更新角色资源关联信息
     * @param roleResourceVo
     */
    void roleContextResource(RoleResourceVo roleResourceVo);
}
