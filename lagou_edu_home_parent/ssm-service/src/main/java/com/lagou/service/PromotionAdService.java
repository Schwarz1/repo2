package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;

import java.util.List;

/**
 * @author liu
 * @description 广告信息Service层接口
 * @date 2021/7/13 21:10
 */
public interface PromotionAdService {
    /*
        分页查询广告信息
     */
    PageInfo findAllPromotionAdByPage(PromotionAdVo promotionAdVo);

    /*
        修改广告信息状态
     */
    void updatePromotionAdStatus(Integer id, Integer status);

    /*
        添加广告信息
     */
    void savePromotionAd(PromotionAd promotionAd);

    /*
        修改广告信息
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /*
        回显广告信息
     */
    PromotionAd findPromotionAdById(Integer id);
}
