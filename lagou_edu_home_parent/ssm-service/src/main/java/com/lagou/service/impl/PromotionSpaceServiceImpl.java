package com.lagou.service.impl;

import com.lagou.dao.PromotionSpaceMapper;
import com.lagou.domain.PromotionSpace;
import com.lagou.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author liu
 * @description PromotionSpaceService实现类
 * @date 2021/7/13 11:35
 */
@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {
        return promotionSpaceMapper.findAllPromotionSpace();
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {
        // 补全参数
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());

        // 调用接口
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    /*
        修改广告位信息
     */
    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {
        // 补全参数
        promotionSpace.setUpdateTime(new Date());

        // 调用接口
        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }

    /*
        根据id查询广告位信息，广告位数据回显
     */
    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {
        return promotionSpaceMapper.findPromotionSpaceById(id);
    }
}
