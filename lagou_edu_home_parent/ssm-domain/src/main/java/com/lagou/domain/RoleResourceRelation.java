package com.lagou.domain;

import java.util.Date;

/**
 * @author liu
 * @description 角色资源关联信息
 * @date 2021/7/15 22:54
 */
public class RoleResourceRelation {
    /*主键id*/
    private Integer id;
    /*资源Id*/
    private Integer resourceId;
    /*角色Id*/
    private Integer roleId;
    /*创建时间*/
    private Date createdTime;
    /*更新时间*/
    private Date updatedTime;
    /*创建者*/
    private String createdBy;
    /*更新者*/
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "RoleResourceRelation{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", roleId=" + roleId +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
