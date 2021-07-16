package com.lagou.domain;

import java.util.List;

/**
 * @author liu
 * @description
 * @date 2021/7/15 22:48
 */
public class RoleResourceVo {
    /*角色Id*/
    private Integer roleId;
    /*资源Id集合*/
    private List<Integer> resourceIdList;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getResourceIdList() {
        return resourceIdList;
    }

    public void setResourceIdList(List<Integer> resourceIdList) {
        this.resourceIdList = resourceIdList;
    }

    @Override
    public String toString() {
        return "RoleResourceVo{" +
                "roleId=" + roleId +
                ", resourceIdList=" + resourceIdList +
                '}';
    }
}
