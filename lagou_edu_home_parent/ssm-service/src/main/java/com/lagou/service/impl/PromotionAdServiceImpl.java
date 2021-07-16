package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.PromotionAdMapper;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liu
 * @description PromotionAdServiceImpl实现类
 * @date 2021/7/13 21:13
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo findAllPromotionAdByPage(PromotionAdVo promotionAdVo) {
        // 设置分页参数
        PageHelper.startPage(promotionAdVo.getCurrentPage(), promotionAdVo.getPageSize());
        List<PromotionAd> list = promotionAdMapper.findAllPromotionAdByPage();

        PageInfo<PromotionAd> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {
        // 封装数据
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        // 调用接口
        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }

    /*
        添加广告信息
     */
    @Override
    public void savePromotionAd(PromotionAd promotionAd) {
        // 补全参数
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);

        // 调用接口
        promotionAdMapper.savePromotionAd(promotionAd);
    }

    /*
        修改广告信息
     */
    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {
        // 补全参数
        promotionAd.setUpdateTime(new Date());

        // 调用接口
        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    /*
        广告信息数据回显
     */
    @Override
    public PromotionAd findPromotionAdById(Integer id) {
        return promotionAdMapper.findPromotionAdById(id);
    }


}
