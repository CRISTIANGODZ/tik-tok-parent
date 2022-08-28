package com.tiktok.controller;

import com.tiktok.pojo.Comment;
import com.tiktok.pojo.Good;
import com.tiktok.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 12:01
 * @Discriptioon
 * 扩展接口一：
 *      点赞接口      /douyin/favorite/action --> POST
 *      点赞列表接口  /douyin/favorite/list --> GET
 *      评论接口      /douyin/comment/action --> 评论操作
 *      视频评论列表  /douyin/comment/list --> 视频评论列表
 */
@Controller
public class ExtensionControllerONE {

    @Autowired
    private BaseServiceImpl baseService;

    /**
     * 点赞接口：
     * @param userId
     * @param videoId
     * @param actionType
     * @param model
     * @return
     * 根据action实行点赞和取消赞
     */
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

    /**
     * 获取某个用户的点赞列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/douyin/favorite/list",method = RequestMethod.GET)
    public String getGoodListController(Integer userId,Model model){
        List<Good> goodVideoList = baseService.getGoodVideoList(userId);
        model.addAttribute("goodVideoList",goodVideoList);
        return "success";
    }

    /**
     * 评论接口
     * @param comment:
     * userId(代替了token) videoId commmentId commentContext
     * @param actionType
     * value=1是添加 value=2是删除
     * @return
     */
    @RequestMapping(value = "/douyin/comment/action",method = RequestMethod.POST)
    public String giveComment(Comment comment,Integer actionType){
        //actionType是1则添加评论
        if (actionType == 1){
            baseService.addComment(comment);
        } else if (actionType == 2){
            //actionType是2则删除评论
            baseService.deleteComment(comment);
        } else {
            return "errorPage/normalError";
        }
        return "success";
    }

    /**
     * 评论
     * @param videoId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/douyin/comment/list",method = RequestMethod.GET)
    public String getCommentList(Integer videoId,Integer userId,Model model){
        List<Comment> commentList = baseService.getCommentList(videoId, userId);
        model.addAttribute("commentList",commentList);
        return "success";
    }

}
