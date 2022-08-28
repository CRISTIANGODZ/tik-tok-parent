package com.tiktok.service.impl;

import com.tiktok.mapper.*;
import com.tiktok.pojo.Comment;
import com.tiktok.pojo.Good;
import com.tiktok.pojo.User;
import com.tiktok.pojo.Video;
import com.tiktok.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 12:04
 * @Discriptioon
 */
@Service
@Transactional
public class BaseServiceImpl implements BaseService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInformationMapper userInformationMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 注册用户信息
     */
    public void registeUser(User user) {
        userMapper.addUser(user);
    }

    /**
     * 用户登陆接口
     */
    public Integer getLogin(User user) {
        Integer userId = userMapper.loginUser(user);
        return userId;
    }

    /**
     * 查询用户信息
     */
    @Override
    public User queryUserInformation(Integer userId) {
        User user = userMapper.queryUserInformation(userId);
        return user;
    }



    /**
     * 视频投稿接口：处理用户和视频的信息
     * 操作：
     *  根据userId创建并添加userId的视频属性：
     *      video_id(自增),user_id,video_title,video_init_time(NOW()直接嵌套sql语句),video_good_number(0)
     */
    @Override
    public void dealWithUserVideoInformation(Integer userId, String videoTitle, String finalPath) {
        Video video = new Video(userId, null, videoTitle, null, 0,finalPath);
        videoMapper.initVideoColumnByUserId(video);
    }

    /**
     * 显示视频列表
     * 参数：
     * userId,token(暂时不用)
     */
    @Override
    public List<Video> getPublishedVideoList(Integer userId) {
        List<Video> publishedVideoList = videoMapper.getPublishedVideoList(userId);
        return publishedVideoList;
    }

    /**
     * 进行点赞操作
     * @param userId
     * @param videoId
     * 先对点赞视频的点赞数+1
     * 再在点赞表中添加用户点赞的视频
     */
    @Override
    public void giveGood(Integer userId, Integer videoId) {
        videoMapper.giveGood(videoId);
        goodMapper.addGoodVideo(userId,videoId);
    }

    /**
     * 取消点赞操作
     * @param userId
     * @param videoId
     */
    @Override
    public void cancelGood(Integer userId, Integer videoId) {
        videoMapper.cancelGood(videoId);
        goodMapper.deleteGoodVideo(userId,videoId);
    }

    /**
     * 获取某个用户的点赞列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<Good> getGoodVideoList(Integer userId) {
        List<Good> goodVideoList = goodMapper.getGoodVideoList(userId);
        return goodVideoList;
    }

    /**
     * 评论接口：添加评论
     * @param comment
     */
    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    /**
     * 评论接口：删除评论
     * @param comment
     */
    @Override
    public void deleteComment(Comment comment) {
        commentMapper.deleteComment(comment);
    }

    /**
     * 评论列表接口
     * @param videoId
     * @param userId
     */
    @Override
    public List<Comment> getCommentList(Integer videoId, Integer userId) {
        List<Comment> commentList = commentMapper.getCommentList(videoId, userId);
        return commentList;
    }

    /**
     * 视频流接口
     */
    @Override
    public List<Map<String, Object>> getVideo() {
        List<Map<String, Object>> video = videoMapper.getVideo();
        return video;
    }
}
