package com.tiktok.mapper;

import com.tiktok.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 17:08
 * @Discriptioon
 */
public interface VideoMapper {

    /**
     * 视频投稿接口:
     * 根据userId创建并添加userId的视频属性：
     */
    void initVideoColumnByUserId(Video video);

    /**
     * 显示视频列表
     * 参数：
     * userId,token(暂时不用)
     */
    List<Video> getPublishedVideoList(@Param("userId") Integer userId);

    /**
     * 点赞操作：
     * 对点赞视频的点赞数+1
     * @param videoId
     */
    void giveGood(@Param("videoId") Integer videoId);

    /**
     * 取消点赞操作：
     * 对点赞视频的点赞数-1
     * @param videoId
     */
    void cancelGood(@Param("videoId") Integer videoId);
}
