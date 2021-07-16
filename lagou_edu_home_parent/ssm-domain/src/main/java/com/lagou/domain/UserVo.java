package com.lagou.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author liu
 * @description 用户接受前端数据
 * @date 2021/7/13 23:32
 */
public class UserVo {
    private Integer currentPage;
    private Integer pageSize;
    private String username;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCreateTime;
    private Integer userId;
    private List<Integer> roleIdList;




    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(Date endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public Date getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(Date startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", username='" + username + '\'' +
                ", endCreateTime=" + endCreateTime +
                ", startCreateTime=" + startCreateTime +
                ", userId=" + userId +
                ", roleIdList=" + roleIdList +
                '}';
    }
}
