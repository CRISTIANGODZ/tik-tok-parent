package com.tiktok.mapper;

import com.tiktok.pojo.Video;

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
    void InitVideoColumnByUserId(Video video);

}
