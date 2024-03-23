package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分类对象 museum_category
 * 
 * @author keloid
 * @date 2024-02-19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MuseumCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 类别id */
    private Integer categoryId;

    /** 类别名称 */
    @Excel(name = "类别名称")
    private String categoryName;

    /** 类别描述 */
    @Excel(name = "类别描述")
    private String categoryDescription;

    /** 类别状态 */
    @Excel(name = "类别状态")
    private String categoryStatus;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    public void setCategoryId(Integer categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() 
    {
        return categoryId;
    }
    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }
    public void setCategoryDescription(String categoryDescription) 
    {
        this.categoryDescription = categoryDescription;
    }

    public String getCategoryDescription() 
    {
        return categoryDescription;
    }
    public void setCategoryStatus(String categoryStatus) 
    {
        this.categoryStatus = categoryStatus;
    }

    public String getCategoryStatus() 
    {
        return categoryStatus;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("categoryId", getCategoryId())
            .append("categoryName", getCategoryName())
            .append("categoryDescription", getCategoryDescription())
            .append("categoryStatus", getCategoryStatus())
            .toString();
    }
}
