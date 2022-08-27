package com.tiktok.mapper;

import com.tiktok.pojo.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 22:08
 * @Discriptioon
 */
public interface GoodMapper {

    /**
     * 进行点赞操作
     * 添加videoId
     * @param userId
     * @param videoId
     */
    void addGoodVideo(@Param("userId") Integer userId,@Param("videoId") Integer videoId);

    /**
     * 取消点赞操作
     * 删除videoId
     * @param userId
     * @param videoId
     */
    void deleteGoodVideo(@Param("userId") Integer userId,@Param("videoId") Integer videoId);

    /**
     * 获取用户的点赞列表
     * @param userId
     */
    List<Good> getGoodVideoList(Integer userId);
}
