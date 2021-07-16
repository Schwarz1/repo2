package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;

import java.util.List;

/**
 * @author liu
 * @description 资源信息Dao层接口
 * @date 2021/7/15 0:19
 */
public interface ResourceMapper {
    /*
        分页，多条件查询资源信息
     */
    List<Resource> findAllResource(ResourceVo resourceVo);
}
