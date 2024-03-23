package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumCommentMapper;
import com.ruoyi.web.domain.MuseumComment;
import com.ruoyi.web.service.IMuseumCommentService;

/**
 * 评论Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-19
 */
@Service
public class MuseumCommentServiceImpl implements IMuseumCommentService 
{
    @Autowired
    private MuseumCommentMapper museumCommentMapper;

    /**
     * 查询评论
     * 
     * @param commentId 评论主键
     * @return 评论
     */
    @Override
    public MuseumComment selectMuseumCommentByCommentId(Integer commentId)
    {
        return museumCommentMapper.selectMuseumCommentByCommentId(commentId);
    }

    /**
     * 查询评论列表
     * 
     * @param museumComment 评论
     * @return 评论
     */
    @Override
    public List<MuseumComment> selectMuseumCommentList(MuseumComment museumComment)
    {
        return museumCommentMapper.selectMuseumCommentList(museumComment);
    }

    /**
     * 新增评论
     * 
     * @param museumComment 评论
     * @return 结果
     */
    @Override
    public int insertMuseumComment(MuseumComment museumComment)
    {
        return museumCommentMapper.insertMuseumComment(museumComment);
    }

    /**
     * 修改评论
     * 
     * @param museumComment 评论
     * @return 结果
     */
    @Override
    public int updateMuseumComment(MuseumComment museumComment)
    {
        return museumCommentMapper.updateMuseumComment(museumComment);
    }

    /**
     * 批量删除评论
     * 
     * @param commentIds 需要删除的评论主键
     * @return 结果
     */
    @Override
    public int deleteMuseumCommentByCommentIds(Integer[] commentIds)
    {
        return museumCommentMapper.deleteMuseumCommentByCommentIds(commentIds);
    }

    /**
     * 删除评论信息
     * 
     * @param commentId 评论主键
     * @return 结果
     */
    @Override
    public int deleteMuseumCommentByCommentId(Integer commentId)
    {
        return museumCommentMapper.deleteMuseumCommentByCommentId(commentId);
    }
}
