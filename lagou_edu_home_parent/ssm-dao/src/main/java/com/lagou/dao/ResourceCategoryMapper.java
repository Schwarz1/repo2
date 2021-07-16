package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author liu
 * @description 资源目录Dao接口
 * @date 2021/7/15 0:12
 */
public interface ResourceCategoryMapper {
    /*
        查询所有资源分类信息
     */
    List<ResourceCategory> findAllResourceCategory();

    /*------------作业部分-----------------*/

    /**
     * 保存资源分类
     * @param resourceCategory 需要保存的资源分类信息
     */
    void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据指定的目录id修改资源目录信息
     * @param resourceCategory 需要修改的分类信息，名字、更新时间、排序、更新者
     */
    void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据id删除指定资源分类
     * @param id 资源分类Id
     */
    void deleteResourceCategory(Integer id);
}
