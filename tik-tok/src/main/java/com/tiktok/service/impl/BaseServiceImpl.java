package com.tiktok.service.impl;

import com.tiktok.mapper.UserInformationMapper;
import com.tiktok.mapper.UserMapper;
import com.tiktok.mapper.VideoMapper;
import com.tiktok.pojo.User;
import com.tiktok.pojo.Video;
import com.tiktok.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 注册用户信息
     */
    public void registeUser(User user) {
        userMapper.AddUser(user);
    }

    /**
     * 用户登陆接口
     */
    public Integer getLogin(User user) {
        Integer userId = userMapper.LoginUser(user);
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
    public void dealWithUserVideoInformation(Integer userId, String videoTitle) {
        Video video = new Video(userId, null, videoTitle, null, 0);
        videoMapper.InitVideoColumnByUserId(video);
    }
}
