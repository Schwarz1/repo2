package com.lagou.controller;

import com.lagou.domain.ResourceCategory;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liu
 * @description 资源分类web层
 * @date 2021/7/15 0:16
 */
@RestController
@RequestMapping("/ResourceCategory")
public class ResourceCategoryController {
    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @RequestMapping("/findAllResourceCategory")
    public ResponseResult findAllResourceCategory(){
        List<ResourceCategory> list = resourceCategoryService.findAllResourceCategory();
        return new ResponseResult(true, 200, "资源分类查询成功", list);
    }

    /**
     * 修改%保存资源目录信息
     * 通过Id进行判断
     * @return
     */
    @RequestMapping("/saveOrUpdateResourceCategory")
    public ResponseResult saveOrUpdateResourceCategory(@RequestBody ResourceCategory resourceCategory){
        if(resourceCategory.getId() != null){
            // 修改操作
            resourceCategoryService.updateResourceCategory(resourceCategory);
            return new ResponseResult(true, 200, "修改资源目录信息成功", null);
        }else{
            // 添加操作
            resourceCategoryService.saveResourceCategory(resourceCategory);
            return new ResponseResult(true, 200, "添加资源目录信息成功", null);
        }
    }

    /**
     * 根据id删除指定资源分类
     */
    @RequestMapping("/deleteResourceCategory")
    public ResponseResult deleteResourceCategory(@RequestParam("id") Integer id){
        resourceCategoryService.deleteResourceCategory(id);
        return new ResponseResult(true, 200, "删除资源分类成功", null);
    }

}
