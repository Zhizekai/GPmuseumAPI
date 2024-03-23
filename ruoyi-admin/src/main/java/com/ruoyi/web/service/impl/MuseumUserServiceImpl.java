package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumUserMapper;
import com.ruoyi.web.domain.MuseumUser;
import com.ruoyi.web.service.IMuseumUserService;

/**
 * 前台用户Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-19
 */
@Service
public class MuseumUserServiceImpl implements IMuseumUserService 
{
    @Autowired
    private MuseumUserMapper museumUserMapper;

    /**
     * 查询前台用户
     * 
     * @param userId 前台用户主键
     * @return 前台用户
     */
    @Override
    public MuseumUser selectMuseumUserByUserId(Long userId)
    {
        return museumUserMapper.selectMuseumUserByUserId(userId);
    }

    /**
     * 查询前台用户列表
     * 
     * @param museumUser 前台用户
     * @return 前台用户
     */
    @Override
    public List<MuseumUser> selectMuseumUserList(MuseumUser museumUser)
    {
        return museumUserMapper.selectMuseumUserList(museumUser);
    }

    /**
     * 新增前台用户
     * 
     * @param museumUser 前台用户
     * @return 结果
     */
    @Override
    public int insertMuseumUser(MuseumUser museumUser)
    {
        return museumUserMapper.insertMuseumUser(museumUser);
    }

    /**
     * 修改前台用户
     * 
     * @param museumUser 前台用户
     * @return 结果
     */
    @Override
    public int updateMuseumUser(MuseumUser museumUser)
    {
        return museumUserMapper.updateMuseumUser(museumUser);
    }

    /**
     * 批量删除前台用户
     * 
     * @param userIds 需要删除的前台用户主键
     * @return 结果
     */
    @Override
    public int deleteMuseumUserByUserIds(Long[] userIds)
    {
        return museumUserMapper.deleteMuseumUserByUserIds(userIds);
    }

    /**
     * 删除前台用户信息
     * 
     * @param userId 前台用户主键
     * @return 结果
     */
    @Override
    public int deleteMuseumUserByUserId(Long userId)
    {
        return museumUserMapper.deleteMuseumUserByUserId(userId);
    }
}
