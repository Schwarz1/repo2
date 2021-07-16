package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**
 * @author liu
 * @description 资源分类Service层接口
 * @date 2021/7/15 0:14
 */
public interface ResourceCategoryService {
    /*
        查询所有资源分类信息
     */
    List<ResourceCategory> findAllResourceCategory();

    /*------------作业部分---------------*/

    /**
     * 保存资源目录
     * @param resourceCategory 需要保存的资源目录信息
     */
    void saveResourceCategory(ResourceCategory resourceCategory);

    /**
     * 修改指定的资源目录信息
     * @param resourceCategory 需要修改的资源目录信息
     */
    void updateResourceCategory(ResourceCategory resourceCategory);

    /**
     * 根据id删除指定资源分类
     * @param id 资源分类Id
     */
    void deleteResourceCategory(Integer id);
}
