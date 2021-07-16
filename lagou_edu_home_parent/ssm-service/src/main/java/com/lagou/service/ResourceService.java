package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

/**
 * @author liu
 * @description 资源信息Service层接口
 * @date 2021/7/15 0:27
 */
public interface ResourceService {
    /*
        分页，多条件查询资源信息
    */
    PageInfo<Resource> findAllResource(ResourceVo resourceVo);
}
