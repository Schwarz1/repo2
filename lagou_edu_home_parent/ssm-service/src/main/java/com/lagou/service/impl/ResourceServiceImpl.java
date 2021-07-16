package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.ResourceMapper;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVo;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liu
 * @description ResourceService实现类
 * @date 2021/7/15 0:27
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    /*
        分页，多条件查询资源信息
     */
    @Override
    public PageInfo<Resource> findAllResource(ResourceVo resourceVo) {
        // 分页配置
        PageHelper.startPage(resourceVo.getCurrentPage(), resourceVo.getPageSize());
        // 查询数据
        List<Resource> resourceList = resourceMapper.findAllResource(resourceVo);
        // 封装进PageInfo
        PageInfo<Resource> pageInfo = new PageInfo<>(resourceList);
        return pageInfo;
    }
}
