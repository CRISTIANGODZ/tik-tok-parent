package com.tiktok.pojo;

import java.util.Date;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 16:29
 * @Discriptioon
 */
public class Video {

    private Integer userId;

    private Integer videoId;

    private String videoTitle;

    private Date videoInitTime;

    private Integer videoGoodNumber;

    private String videoAddress;

    public Video() {
    }

    public Video(Integer userId, Integer videoId, String videoTitle, Date videoInitTime, Integer videoGoodNumber, String videoAddress) {
        this.userId = userId;
        this.videoId = videoId;
        this.videoTitle = videoTitle;
        this.videoInitTime = videoInitTime;
        this.videoGoodNumber = videoGoodNumber;
        this.videoAddress = videoAddress;
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

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public Date getVideoInitTime() {
        return videoInitTime;
    }

    public void setVideoInitTime(Date videoInitTime) {
        this.videoInitTime = videoInitTime;
    }

    public Integer getVideoGoodNumber() {
        return videoGoodNumber;
    }

    public void setVideoGoodNumber(Integer videoGoodNumber) {
        this.videoGoodNumber = videoGoodNumber;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    @Override
    public String toString() {
        return "Video{" +
                "userId=" + userId +
                ", videoId=" + videoId +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoInitTime=" + videoInitTime +
                ", videoGoodNumber=" + videoGoodNumber +
                ", videoAddress='" + videoAddress + '\'' +
                '}';
    }
}
