package com.tiktok.pojo;

/**
 * @auther DyingZhang
 * @Create 2022-08-27 22:07
 * @Discriptioon
 */
public class Good {

    private Integer user_id;

    private Integer video_id;

    public Good() {
    }

    public Good(Integer user_id, Integer video_id) {
        this.user_id = user_id;
        this.video_id = video_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    @Override
    public String toString() {
        return "Good{" +
                "user_id=" + user_id +
                ", video_id=" + video_id +
                '}';
    }
}
