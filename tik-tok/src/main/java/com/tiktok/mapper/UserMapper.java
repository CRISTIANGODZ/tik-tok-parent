package com.tiktok.mapper;

import com.tiktok.pojo.User;
import com.tiktok.pojo.Video;
import org.apache.ibatis.annotations.Param;

/**
 * @auther DyingZhang
 * @Create 2022-08-26 13:03
 * @Discriptioon
 */
public interface UserMapper {

    /**
     * 注册用户信息
     */
    void addUser(User user);

    /**
     * 用户登陆接口
     */
    Integer loginUser(User user);

    /**
     * 查询用户信息
     */
    User queryUserInformation(@Param("userId") Integer userId);


}
