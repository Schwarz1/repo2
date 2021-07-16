package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVo;
import com.lagou.domain.ResponseResult;
import com.lagou.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liu
 * @description 广告信息web层
 * @date 2021/7/13 21:25
 */
@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {
    @Autowired
    private PromotionAdService promotionAdService;

    /*
        分页查询广告信息
     */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVo promotionAdVo){
        PageInfo pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVo);
        return new ResponseResult(true, 200, "广告信息分页查询成功", pageInfo);
    }

    /*
        广告图片上传
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult PromotionAdUpload(@RequestParam("file")MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        // 获取资源路径
        String realPath = request.getServletContext().getRealPath("/");
        String substring = realPath.substring(0, realPath.lastIndexOf("ssm-web"));
        String uploadPath = substring + "//upload";

        // 获取文件原始名字
        String originalFilename = multipartFile.getOriginalFilename();
        // 生成新的文件名字：时间+后缀名
        String newFilename = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 创建文件目录
        File file = new File(uploadPath, newFilename);
        // 判断文件是否存在
        if(!file.getParentFile().exists()){
            // 如果文件不存在，则创建
            file.getParentFile().mkdirs();
        }

        // 进行文件的上传
        multipartFile.transferTo(file);

        // 响应数据
        // 使用Map封装数据
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFilename);
        map.put("filePath", "http://localhost:8080/upload/" + newFilename);

        return new ResponseResult(true, 200, "上传成功", map);
    }

    /*
        修改广告信息状态
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(@RequestParam("id")Integer id,
                                                  @RequestParam("status")Integer status){
        promotionAdService.updatePromotionAdStatus(id, status);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("status", status);
        return new ResponseResult(true, 200, "广告信息状态修改成功", map);
    }

    /*
        保存广告信息
     */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){
        if(promotionAd.getId() != null){
            // 更新
            promotionAdService.updatePromotionAd(promotionAd);
            return new ResponseResult(true, 200, "更新广告信息成功", null);
        }else{
            // 添加
            promotionAdService.savePromotionAd(promotionAd);
            return new ResponseResult(true, 200, "添加广告信息成功", null);
        }
    }

    /*
        广告信息数据回显
     */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam("id")Integer id){
        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);
        return new ResponseResult(true, 200, "广告信息数据回显成功", promotionAd);
    }
}
