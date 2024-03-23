package com.ruoyi.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 评论对象 museum_comment
 * 
 * @author keloid
 * @date 2024-02-19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MuseumComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论id */
    private Integer commentId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String commentContent;

    /** 评论点赞数 */
    @Excel(name = "评论点赞数")
    private Integer commentLikeCount;

    /** 评论用户id */
    @Excel(name = "评论用户id")
    private Long commentUserId;

    /** 古董id */
    @Excel(name = "古董id")
    private String commentAntiqueId;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date modifiedTime;
    private MuseumUser museumUser;


    public MuseumUser getMuseumUser() {
        return museumUser;
    }

    public void setMuseumUser(MuseumUser museumUser) {
        this.museumUser = museumUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }



    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public void setCommentId(Integer commentId)
    {
        this.commentId = commentId;
    }

    public Integer getCommentId() 
    {
        return commentId;
    }
    public void setCommentContent(String commentContent) 
    {
        this.commentContent = commentContent;
    }

    public String getCommentContent() 
    {
        return commentContent;
    }
    public void setCommentLikeCount(Integer commentLikeCount) 
    {
        this.commentLikeCount = commentLikeCount;
    }

    public Integer getCommentLikeCount() 
    {
        return commentLikeCount;
    }
    public void setCommentUserId(Long commentUserId) 
    {
        this.commentUserId = commentUserId;
    }

    public Long getCommentUserId() 
    {
        return commentUserId;
    }
    public void setCommentAntiqueId(String commentAntiqueId) 
    {
        this.commentAntiqueId = commentAntiqueId;
    }

    public String getCommentAntiqueId() 
    {
        return commentAntiqueId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commentId", getCommentId())
            .append("commentContent", getCommentContent())
            .append("commentLikeCount", getCommentLikeCount())
            .append("commentUserId", getCommentUserId())
            .append("commentAntiqueId", getCommentAntiqueId())
            .toString();
    }
}
