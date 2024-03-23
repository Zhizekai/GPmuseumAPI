package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.MuseumComment;

/**
 * 评论Service接口
 * 
 * @author keloid
 * @date 2024-02-19
 */
public interface IMuseumCommentService 
{
    /**
     * 查询评论
     * 
     * @param commentId 评论主键
     * @return 评论
     */
    public MuseumComment selectMuseumCommentByCommentId(Integer commentId);

    /**
     * 查询评论列表
     * 
     * @param museumComment 评论
     * @return 评论集合
     */
    public List<MuseumComment> selectMuseumCommentList(MuseumComment museumComment);

    /**
     * 新增评论
     * 
     * @param museumComment 评论
     * @return 结果
     */
    public int insertMuseumComment(MuseumComment museumComment);

    /**
     * 修改评论
     * 
     * @param museumComment 评论
     * @return 结果
     */
    public int updateMuseumComment(MuseumComment museumComment);

    /**
     * 批量删除评论
     * 
     * @param commentIds 需要删除的评论主键集合
     * @return 结果
     */
    public int deleteMuseumCommentByCommentIds(Integer[] commentIds);

    /**
     * 删除评论信息
     * 
     * @param commentId 评论主键
     * @return 结果
     */
    public int deleteMuseumCommentByCommentId(Integer commentId);
}
