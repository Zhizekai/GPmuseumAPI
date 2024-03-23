package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏对象 museum_collect
 * 
 * @author keloid
 * @date 2024-02-20
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MuseumCollect extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏id */
    private Long collectId;

    /** 古董id */
    @Excel(name = "古董id")
    private Long antiqueId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    public void setCollectId(Long collectId) 
    {
        this.collectId = collectId;
    }

    public Long getCollectId() 
    {
        return collectId;
    }
    public void setAntiqueId(Long antiqueId) 
    {
        this.antiqueId = antiqueId;
    }

    public Long getAntiqueId() 
    {
        return antiqueId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setModifiedTime(Date modifiedTime) 
    {
        this.modifiedTime = modifiedTime;
    }

    public Date getModifiedTime() 
    {
        return modifiedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collectId", getCollectId())
            .append("antiqueId", getAntiqueId())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("modifiedTime", getModifiedTime())
            .toString();
    }
}
