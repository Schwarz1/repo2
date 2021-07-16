package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.*;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liu
 * @description RoleService实现类
 * @date 2021/7/14 14:04
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        return roleMapper.findAllRole(role);
    }

    /*
        更新角色关联菜单信息
        先删除旧数据，再插入新数据
     */
    @Override
    public void updateRoleContextMenu(RoleMenuVo roleMenuVo) {
        // 删除旧数据
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        // 插入新数据
        Date date = new Date();
        //遍历列表
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            // 封装数据
            Role_menu_relation role_menu_relation = new Role_menu_relation();
            role_menu_relation.setRoleId(roleMenuVo.getRoleId());
            role_menu_relation.setMenuId(mid);
            role_menu_relation.setCreatedTime(date);
            role_menu_relation.setUpdatedTime(date);
            // 创建者设置为system
            role_menu_relation.setCreatedBy("system");
            role_menu_relation.setUpdatedBy("system");

            //调用接口
            roleMapper.addRoleContextMenu(role_menu_relation);
        }
    }

    /*
        删除角色信息
        同时删除关联的菜单、资源信息
     */
    @Override
    public void deleteRole(Integer roleId) {
        // 删除关联的菜单信息
        roleMapper.deleteRoleContextMenu(roleId);
        // 删除关联的资源信息
        // TODO 暂时没有编写资源模块，待补充

        // 删除角色记录
        roleMapper.deleteRole(roleId);
    }

    /*------------作业部分--------------*/
    /**
     * 根据角色id查询当前角色所拥有的资源信息
     * 并按照资源分类-资源进行查询
     * @param rid 角色id
     * @return 资源分类列表，其中包含了当前角色在该分类下拥有的资源
     */
    @Override
    public List<ResourceCategory> findResourceListByRoleId(Integer rid){
        // 查询角色拥有的资源分类信息
        List<ResourceCategory> resourceCategoryList = roleMapper.findResourceCategoryByRoleId(rid);
        // 查询角色拥有的资源信息
        List<Resource> resourceList = roleMapper.findResourceByRoleId(rid);

        for(int i = 0; i < resourceCategoryList.size(); i++){
            for(int j = 0; j < resourceList.size(); j++){
                if(resourceList.get(j).getCategoryId() == resourceCategoryList.get(i).getId()){
                    resourceCategoryList.get(i).getResourceList().add(resourceList.remove(j));
                }
            }
        }

        return resourceCategoryList;
    }

    /**
     * 更新角色资源关联信息
     * @param roleResourceVo
     */
    @Override
    public void roleContextResource(RoleResourceVo roleResourceVo) {
       // 删除原有的角色资源关联信息
       roleMapper.deleteRoleContextResource(roleResourceVo.getRoleId());

        Date date = new Date();
        // 遍历资源Id
        for (Integer resourceId : roleResourceVo.getResourceIdList()) {
            // 封装数据
            RoleResourceRelation roleResourceRelation = new RoleResourceRelation();
            roleResourceRelation.setRoleId(roleResourceVo.getRoleId());
            roleResourceRelation.setResourceId(resourceId);
            roleResourceRelation.setCreatedTime(date);
            roleResourceRelation.setUpdatedTime(date);
            // 创建/更新者设置为system
            roleResourceRelation.setCreatedBy("system");
            roleResourceRelation.setUpdatedBy("system");

            // 调用接口
            roleMapper.saveRoleContextResource(roleResourceRelation);
        }
    }
}
