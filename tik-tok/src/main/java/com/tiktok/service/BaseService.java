package com.tiktok.service;

import com.tiktok.pojo.Comment;
import com.tiktok.pojo.Good;
import com.tiktok.pojo.User;
import com.tiktok.pojo.Video;

import java.util.List;
import java.util.Map;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 12:03
 * @Discriptioon
 */

public interface BaseService {

    /**
     * 注册用户信息
     */
    public void registeUser(User user);

    /**
     * 用户登陆接口
     */
    public Integer getLogin(User user);

    /**
     * 查询用户信息
     */
    User queryUserInformation(Integer userId);

    /**
     * 视频投稿接口：处理用户和视频的信息
     */
    void dealWithUserVideoInformation(Integer userId, String videoTitle, String finalPath);

    /**
     * 显示视频列表
     * 参数：
     * userId,token(暂时不用)
     */
    List<Video> getPublishedVideoList(Integer userId);

    /**
     * 进行点赞操作
     * @param userId
     * @param videoId
     */
    void giveGood(Integer userId, Integer videoId);

    /**
     * 取消点赞操作
     * @param userId
     * @param videoId
     */
    void cancelGood(Integer userId, Integer videoId);

    /**
     * 获取某个用户的点赞列表
     *
     * @param userId
     * @return
     */
    List<Good> getGoodVideoList(Integer userId);

    /**
     * 评论接口：添加评论
     *
     * @param comment
     * @return
     */
    List<Comment> addComment(Comment comment);

    /**
     * 评论接口：删除评论
     *
     * @param comment
     * @return
     */
    List<Comment> deleteComment(Comment comment);

    /**
     * 评论列表接口
     * @param videoId
     * @param userId
     */
    List<Comment> getCommentList(Integer videoId, Integer userId);

    /**
     * 视频流接口
     */
    List<Video> getVideo();
}

