package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liu
 * @description 菜单web层
 * @date 2021/7/14 22:32
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /*
        查询所有菜单列表
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> list = menuService.findAllMenu();
        return new ResponseResult(true, 200, "查询菜单列表成功", list);
    }

    /*
        添加/修改菜单回显数据
        id：-1  添加   不需要查询菜单信息  只查询所有父级菜单
        id：不为-1   查询菜单信息   即所有父级菜单
        GET请求
     */
    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(@RequestParam("id")Integer id){
        Map<String, Object> map = new HashMap<>();
        List<Menu> subMenuByPid = menuService.findSubMenuByPid(-1);
        map.put("parentMenuList", subMenuByPid);
        if(id == -1){
            // 新增菜单回显
            map.put("menuInfo", null);
            return new ResponseResult(true, 200, "新增菜单回显成功", map);
        }else{
            Menu menu = menuService.findMenuById(id);
            map.put("menuInfo", menu);
            return new ResponseResult(true, 200, "修改菜单回显成功", map);
        }

    }
}
