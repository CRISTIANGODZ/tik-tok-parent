package com.tiktok.service.impl;

import com.tiktok.mapper.UserInformationMapper;
import com.tiktok.mapper.UserMapper;
import com.tiktok.pojo.User;
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
}
