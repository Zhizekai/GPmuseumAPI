package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预定管理对象 museum_appointment
 * 
 * @author keloid
 * @date 2024-03-24
 */
public class MuseumAppointment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNum;

    /** 预约参观的时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "预约参观的时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date appointmentDate;

    /** 博物馆位置 */
    @Excel(name = "博物馆位置")
    private String region;

    /** 预约状态（1：预约成功，0：取消预约） */
    @Excel(name = "预约状态", readConverterExp = "1=：预约成功，0：取消预约")
    private String status;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setPhoneNum(String phoneNum) 
    {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() 
    {
        return phoneNum;
    }
    public void setAppointmentDate(Date appointmentDate) 
    {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentDate() 
    {
        return appointmentDate;
    }
    public void setRegion(String region) 
    {
        this.region = region;
    }

    public String getRegion() 
    {
        return region;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("id", getId())
            .append("userId", getUserId())
            .append("phoneNum", getPhoneNum())
            .append("appointmentDate", getAppointmentDate())
            .append("region", getRegion())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("modifiedTime", getModifiedTime())
            .toString();
    }
}
