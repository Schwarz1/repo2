package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author liu
 * @description 广告位Service层接口
 * @date 2021/7/13 11:34
 */
public interface PromotionSpaceService {
    /*
        查询所有广告位接口
     */
    List<PromotionSpace> findAllPromotionSpace();

    /*
        保存广告位
     */
    void savePromotionSpace(PromotionSpace promotionSpace);

    /*
        修改广告位信息
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);

    /*
        根据id查询广告位信息，广告位回显
     */
    PromotionSpace findPromotionSpaceById(Integer id);
}
