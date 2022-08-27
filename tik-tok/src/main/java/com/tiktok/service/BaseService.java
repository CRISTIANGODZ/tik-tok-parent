package com.tiktok.service;

import com.tiktok.pojo.User;

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
    void dealWithUserVideoInformation(Integer userId, String videoTitle);
}

