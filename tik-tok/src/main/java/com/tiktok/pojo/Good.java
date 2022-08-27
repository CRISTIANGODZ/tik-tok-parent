package com.tiktok.pojo;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 22:07
 * @Discriptioon
 */
public class Good {

    private Integer userId;

    private Integer videoId;

    private Video video;

    public Good() {
    }

    public Good(Integer userId, Integer videoId, Video video) {
        this.userId = userId;
        this.videoId = videoId;
        this.video = video;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return "Good{" +
                "userId=" + userId +
                ", videoId=" + videoId +
                ", video=" + video +
                '}';
    }
}
