package com.ruoyi.web.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 前台用户对象 museum_user
 * 
 * @author keloid
 * @date 2024-02-19
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MuseumUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    public static final int NormalUser = 1;
    public static final int DemoUser = 2;
    public static final int AdminUser = 3;

    /** 用户id */
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 用户密码 */
    @Excel(name = "用户密码")
    private String userPassword;

    private String userRePassword;

    /** 用户电话 */
    @Excel(name = "用户电话")
    private String userPhone;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String userEmail;

    /** 用户描述 */
    @Excel(name = "用户描述")
    private String userDescription;

    /** 用户得分 */
    @Excel(name = "用户得分")
    private String userScore;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String userAvatar;


    private MultipartFile userAvatarFile;

    /** 用户令牌 */
    @Excel(name = "用户令牌")
    private String userToken;

    /* 用户角色*/
    public String role;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifiedTime;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public MultipartFile getUserAvatarFile() {
        return userAvatarFile;
    }

    public void setUserAvatarFile(MultipartFile userAvatarFile) {
        this.userAvatarFile = userAvatarFile;
    }

    public String getUserRePassword() {
        return userRePassword;
    }

    public void setUserRePassword(String userRePassword) {
        this.userRePassword = userRePassword;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }
    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }
    public void setUserEmail(String userEmail) 
    {
        this.userEmail = userEmail;
    }

    public String getUserEmail() 
    {
        return userEmail;
    }
    public void setUserDescription(String userDescription) 
    {
        this.userDescription = userDescription;
    }

    public String getUserDescription() 
    {
        return userDescription;
    }
    public void setUserScore(String userScore) 
    {
        this.userScore = userScore;
    }

    public String getUserScore() 
    {
        return userScore;
    }
    public void setUserAvatar(String userAvatar)
    {
        this.userAvatar = userAvatar;
    }

    public String getUserAvatar()
    {
        return userAvatar;
    }
    public void setUserToken(String userToken) 
    {
        this.userToken = userToken;
    }

    public String getUserToken() 
    {
        return userToken;
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
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPassword", getUserPassword())
            .append("userPhone", getUserPhone())
            .append("userEmail", getUserEmail())
            .append("userDescription", getUserDescription())
            .append("userScore", getUserScore())
            .append("userAvatar", getUserAvatar())
            .append("userToken", getUserToken())
            .toString();
    }
}
