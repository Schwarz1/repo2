package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**
 * @author liu
 * @description 广告Dao层接口
 * @date 2021/7/13 20:44
 */
public interface PromotionAdMapper {
    /*
        分页查询广告信息
     */
    List<PromotionAd> findAllPromotionAdByPage();

    /*
        修改广告状态
     */
    void updatePromotionAdStatus(PromotionAd promotionAd);

    /*
        保存广告信息
     */
    void savePromotionAd(PromotionAd promotionAd);

    /*
        修改广告信息
     */
    void updatePromotionAd(PromotionAd promotionAd);

    /*
        根据Id查询广告信息
     */
    PromotionAd findPromotionAdById(Integer id);
}
