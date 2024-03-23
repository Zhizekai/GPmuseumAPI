package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.MuseumUser;

/**
 * 前台用户Service接口
 * 
 * @author keloid
 * @date 2024-02-19
 */
public interface IMuseumUserService 
{
    /**
     * 查询前台用户
     * 
     * @param userId 前台用户主键
     * @return 前台用户
     */
    public MuseumUser selectMuseumUserByUserId(Long userId);

    /**
     * 查询前台用户列表
     * 
     * @param museumUser 前台用户
     * @return 前台用户集合
     */
    public List<MuseumUser> selectMuseumUserList(MuseumUser museumUser);

    /**
     * 新增前台用户
     * 
     * @param museumUser 前台用户
     * @return 结果
     */
    public int insertMuseumUser(MuseumUser museumUser);

    /**
     * 修改前台用户
     * 
     * @param museumUser 前台用户
     * @return 结果
     */
    public int updateMuseumUser(MuseumUser museumUser);

    /**
     * 批量删除前台用户
     * 
     * @param userIds 需要删除的前台用户主键集合
     * @return 结果
     */
    public int deleteMuseumUserByUserIds(Long[] userIds);

    /**
     * 删除前台用户信息
     * 
     * @param userId 前台用户主键
     * @return 结果
     */
    public int deleteMuseumUserByUserId(Long userId);
}
