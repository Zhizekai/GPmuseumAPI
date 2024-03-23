package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 古董对象 museum_antique
 * 
 * @author keloid
 * @date 2024-02-19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MuseumAntique extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文物id */
    private Integer antiqueId;

    /** 文物照片 */
    @Excel(name = "文物照片")
    @JsonProperty("cover")
    private String antiqueImg;

    private MultipartFile antiqueImgFile;

    /** 标题 */
    @Excel(name = "标题")
    private String antiqueTitle;

    /** 文物名称 */
    @Excel(name = "文物名称")
    private String antiqueName;

    /** 文物访问量 */
    @Excel(name = "文物访问量")
    private Integer antiquePv;

    /** 文物地址 */
    @Excel(name = "文物地址")
    private String antiqueAddress;

    /** 推荐数 */
    @Excel(name = "推荐数")
    private Integer antiqueRecommendCount;

    /** 被收藏数 */
    @Excel(name = "被收藏数")
    private Integer antiqueCollectCount;

    /** 被添加到心愿单的数量 */
    @Excel(name = "被添加到心愿单的数量")
    private Integer antiqueWishCount;

    /** 文物信息 */
    @Excel(name = "文物信息")
    private String antiqueInformation;

    /** 文物状态（1：上架，0：下架） */
    @Excel(name = "文物状态", readConverterExp = "1=：上架，0：下架")
    private String antiqueStatus;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long antiquePraise;

    /** 文物类型 */
    @Excel(name = "文物类型")
    private Long antiqueCategoryId;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    /* 收藏id*/
    private Long collectId;

    private String categoryName;

    // 标签id
    private Long tagId;


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCollectId() {
        return collectId;
    }

    public void setCollectId(Long collectId) {
        this.collectId = collectId;
    }

    public MultipartFile getAntiqueImgFile() {
        return antiqueImgFile;
    }

    public void setAntiqueImgFile(MultipartFile antiqueImgFile) {
        this.antiqueImgFile = antiqueImgFile;
    }

    public void setAntiqueId(Integer antiqueId)
    {
        this.antiqueId = antiqueId;
    }

    public Integer getAntiqueId() 
    {
        return antiqueId;
    }
    public void setAntiqueImg(String antiqueImg) 
    {
        this.antiqueImg = antiqueImg;
    }

    public String getAntiqueImg() 
    {
        return antiqueImg;
    }
    public void setAntiqueTitle(String antiqueTitle) 
    {
        this.antiqueTitle = antiqueTitle;
    }

    public String getAntiqueTitle() 
    {
        return antiqueTitle;
    }
    public void setAntiqueName(String antiqueName) 
    {
        this.antiqueName = antiqueName;
    }

    public String getAntiqueName() 
    {
        return antiqueName;
    }
    public void setAntiquePv(Integer antiquePv) 
    {
        this.antiquePv = antiquePv;
    }

    public Integer getAntiquePv() 
    {
        return antiquePv;
    }
    public void setAntiqueAddress(String antiqueAddress) 
    {
        this.antiqueAddress = antiqueAddress;
    }

    public String getAntiqueAddress() 
    {
        return antiqueAddress;
    }
    public void setAntiqueRecommendCount(Integer antiqueRecommendCount) 
    {
        this.antiqueRecommendCount = antiqueRecommendCount;
    }

    public Integer getAntiqueRecommendCount() 
    {
        return antiqueRecommendCount;
    }
    public void setAntiqueCollectCount(Integer antiqueCollectCount) 
    {
        this.antiqueCollectCount = antiqueCollectCount;
    }

    public Integer getAntiqueCollectCount() 
    {
        return antiqueCollectCount;
    }
    public void setAntiqueWishCount(Integer antiqueWishCount) 
    {
        this.antiqueWishCount = antiqueWishCount;
    }

    public Integer getAntiqueWishCount() 
    {
        return antiqueWishCount;
    }
    public void setAntiqueInformation(String antiqueInformation) 
    {
        this.antiqueInformation = antiqueInformation;
    }

    public String getAntiqueInformation() 
    {
        return antiqueInformation;
    }
    public void setAntiqueStatus(String antiqueStatus) 
    {
        this.antiqueStatus = antiqueStatus;
    }

    public String getAntiqueStatus() 
    {
        return antiqueStatus;
    }
    public void setAntiquePraise(Long antiquePraise) 
    {
        this.antiquePraise = antiquePraise;
    }

    public Long getAntiquePraise() 
    {
        return antiquePraise;
    }
    public void setAntiqueCategoryId(Long antiqueCategoryId) 
    {
        this.antiqueCategoryId = antiqueCategoryId;
    }

    public Long getAntiqueCategoryId() 
    {
        return antiqueCategoryId;
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
            .append("antiqueId", getAntiqueId())
            .append("antiqueImg", getAntiqueImg())
            .append("antiqueTitle", getAntiqueTitle())
            .append("antiqueName", getAntiqueName())
            .append("antiquePv", getAntiquePv())
            .append("antiqueAddress", getAntiqueAddress())
            .append("antiqueRecommendCount", getAntiqueRecommendCount())
            .append("antiqueCollectCount", getAntiqueCollectCount())
            .append("antiqueWishCount", getAntiqueWishCount())
            .append("antiqueInformation", getAntiqueInformation())
            .append("antiqueStatus", getAntiqueStatus())
            .append("antiquePraise", getAntiquePraise())
            .append("antiqueCategoryId", getAntiqueCategoryId())
            .append("createTime", getCreateTime())
            .append("modifiedTime", getModifiedTime())
            .toString();
    }
}
