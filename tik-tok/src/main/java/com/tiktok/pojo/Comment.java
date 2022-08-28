package com.tiktok.pojo;

/**
 * @auther DyingZhang
 * @Create 2022-08-28 8:39
 * @Discriptioon
 */
public class Comment {

    private Integer commentId;

    private String commentText;

    private Integer videoId;

    private Integer userId;

    public Comment() {
    }

    public Comment(Integer commentId, String commentText, Integer videoId, Integer userId) {
        this.commentId = commentId;
        this.commentText = commentText;
        this.videoId = videoId;
        this.userId = userId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", videoId=" + videoId +
                ", userId=" + userId +
                '}';
    }
}
