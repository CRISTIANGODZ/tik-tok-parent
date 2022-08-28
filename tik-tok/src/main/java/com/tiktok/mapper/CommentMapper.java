package com.tiktok.mapper;

import com.tiktok.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther DyingZhang
 * @Create 2022-08-28 8:43
 * @Discriptioon
 */
public interface CommentMapper {

    /**
     * 评论接口：添加评论
     * @param comment
     */
    void addComment(Comment comment);

    /**
     * 评论接口：删除评论
     * @param comment
     */
    void deleteComment(Comment comment);

    /**
     * 评论列表接口：获取评论列表
     * @param videoId
     * @param userId
     */
    List<Comment> getCommentList(@Param("videoId") Integer videoId, @Param("userId") Integer userId);
}
