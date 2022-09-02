package com.tiktok.controller;

import com.google.gson.Gson;
import com.tiktok.pojo.Comment;
import com.tiktok.pojo.Good;
import com.tiktok.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RestController
public class ExtensionControllerONE {

    private static Gson gson = new Gson();
    @Autowired
    private BaseServiceImpl baseService;

    /**
     * 点赞接口：
     * @param userId
     * @param videoId
     * @param actionType
     * @return
     * 根据action实行点赞和取消赞
     */
    @RequestMapping(value = "/douyin/favorite/action",method = RequestMethod.POST)
    public String goodController(Integer userId, Integer videoId, Integer actionType){
        //actionType是1则点赞
        String json;
        if (actionType == 1){
            baseService.giveGood(userId,videoId);
            //设置返回值参数
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status_code",0);
            map.put("status_msg","谢谢你的喜欢！");
            json = gson.toJson(map);
        } else if (actionType == 2){
        //actionType是2则取消赞
            baseService.cancelGood(userId,videoId);
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status_code",0);
            map.put("status_msg","就支持人家一下嘛qvq");
            json = gson.toJson(map);
        } else {
            return "errorPage/normalError";
        }
        return json;
    }

    /**
     * 获取某个用户的点赞列表
     * @param userId
     * @return
     */
    @RequestMapping(value = "/douyin/favorite/list",method = RequestMethod.GET)
    public String getGoodListController(Integer userId){
        List<Good> goodVideoList = baseService.getGoodVideoList(userId);
        //设置返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("status_msg","返回点赞列表成功！");
        map.put("video_list",goodVideoList);
        String json = gson.toJson(map);
        return json;
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
        String json;
        if (actionType == 1){
            baseService.addComment(comment);
            //设置返回值参数
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status_code",0);
            map.put("status_msg","发表评论成功！");
            json = gson.toJson(map);
        } else if (actionType == 2){
            //actionType是2则删除评论
            baseService.deleteComment(comment);
            //设置返回值参数
            HashMap<Object, Object> map = new HashMap<>();
            map.put("status_code",0);
            map.put("status_msg","发表评论失败！");
            json = gson.toJson(map);
        } else {
            return "errorPage/normalError";
        }
        return json;
    }

    /**
     * 评论
     * @param videoId
     * @param userId
     * @return
     */
    @RequestMapping(value = "/douyin/comment/list",method = RequestMethod.GET)
    public String getCommentList(Integer videoId,Integer userId){
        List<Comment> commentList = baseService.getCommentList(videoId, userId);
        //设置返回值参数
        HashMap<Object, Object> map = new HashMap<>();
        map.put("status_code",0);
        map.put("comment_list",commentList);
        String json = gson.toJson(map);
        return json;
    }

}
