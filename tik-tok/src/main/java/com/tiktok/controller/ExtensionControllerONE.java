package com.tiktok.controller;

import com.tiktok.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 12:01
 * @Discriptioon
 * 扩展接口一：
 *      点赞接口      /douyin/favorite/action --> 赞操作
 *      点赞列表接口  /douyin/favorite/list --> 点赞列表
 *      评论接口      /douyin/comment/action --> 评论操作
 *      视频评论列表  /douyin/comment/list --> 视频评论列表
 */
@Controller
public class ExtensionControllerONE {

    @Autowired
    private BaseServiceImpl baseService;

    @RequestMapping(value = "/douyin/favorite/action",method = RequestMethod.POST)
    public String goodController(Integer userId, Integer videoId, Integer actionType, Model model){
        //actionType是1则点赞
        if (actionType == 1){
            baseService.giveGood(userId,videoId);
            model.addAttribute("status_msg","谢谢你的喜欢！");
            model.addAttribute("status_code",0);
        } else if (actionType == 2){
        //actionType是2则取消赞
            baseService.cancelGood(userId,videoId);
            model.addAttribute("status_msg","就支持人家一下下嘛qvq");
            model.addAttribute("status_code",1);
        } else {
            return "errorPage/normalError";
        }
        return "success";
    }

}
