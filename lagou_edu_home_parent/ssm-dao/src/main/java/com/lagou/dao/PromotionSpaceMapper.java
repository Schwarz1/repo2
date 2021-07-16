package com.lagou.dao;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**
 * @author liu
 * @description 广告位Dao层接口
 * @date 2021/7/13 11:31
 */
public interface PromotionSpaceMapper {
    /*
        查询所有广告位
     */
    List<PromotionSpace> findAllPromotionSpace();

    /*
        新增广告位
     */
    void savePromotionSpace(PromotionSpace promotionSpace);

    /*
        修改广告位信息
     */
    void updatePromotionSpace(PromotionSpace promotionSpace);

    /*
        根据id查询广告位信息，广告位信息回显
     */
    PromotionSpace findPromotionSpaceById(Integer id);
}
