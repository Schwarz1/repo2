package com.lagou.domain;

/**
 * @author liu
 * @description 资源信息接收前端数据
 * @date 2021/7/15 0:29
 */
public class ResourceVo {
    private Integer currentPage;
    private Integer pageSize;
    private String name;
    private Integer categoryId;
    private String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ResourceVo{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", url='" + url + '\'' +
                '}';
    }
}
