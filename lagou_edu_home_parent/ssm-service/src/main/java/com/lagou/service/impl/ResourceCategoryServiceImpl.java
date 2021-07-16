package com.lagou.service.impl;

import com.lagou.dao.ResourceCategoryMapper;
import com.lagou.domain.ResourceCategory;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liu
 * @description ResourceCategoryService实现类
 * @date 2021/7/15 0:15
 */
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {
    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {
        return resourceCategoryMapper.findAllResourceCategory();
    }

    /*-----------------作业部分------------------*/
    /**
     * 保存资源目录信息
     * @param resourceCategory 需要保存的资源目录信息
     */
    @Override
    public void saveResourceCategory(ResourceCategory resourceCategory) {
        // 补全参数
        Date date = new Date();
        resourceCategory.setCreatedTime(date);
        resourceCategory.setUpdatedTime(date);
        // 创建/更新者设置为system
        resourceCategory.setCreatedBy("system");
        resourceCategory.setUpdatedBy("system");

        // 调用接口
        resourceCategoryMapper.saveResourceCategory(resourceCategory);
    }

    /**
     * 修改指定的资源目录信息
     * @param resourceCategory 需要修改的资源目录信息
     */
    @Override
    public void updateResourceCategory(ResourceCategory resourceCategory) {
        // 补全参数
        resourceCategory.setUpdatedTime(new Date());
        resourceCategory.setUpdatedBy("system");

        // 调用接口
        resourceCategoryMapper.updateResourceCategory(resourceCategory);
    }

    /**
     * 根据id删除指定资源分类
     * @param id 资源分类Id
     */
    @Override
    public void deleteResourceCategory(Integer id){
        resourceCategoryMapper.deleteResourceCategory(id);
    }

}
