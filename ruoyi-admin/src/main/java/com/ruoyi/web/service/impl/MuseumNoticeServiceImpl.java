package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumNoticeMapper;
import com.ruoyi.web.domain.MuseumNotice;
import com.ruoyi.web.service.IMuseumNoticeService;

/**
 * 消息Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-19
 */
@Service
public class MuseumNoticeServiceImpl implements IMuseumNoticeService 
{
    @Autowired
    private MuseumNoticeMapper museumNoticeMapper;

    /**
     * 查询消息
     * 
     * @param noticeId 消息主键
     * @return 消息
     */
    @Override
    public MuseumNotice selectMuseumNoticeByNoticeId(Long noticeId)
    {
        return museumNoticeMapper.selectMuseumNoticeByNoticeId(noticeId);
    }

    /**
     * 查询消息列表
     * 
     * @param museumNotice 消息
     * @return 消息
     */
    @Override
    public List<MuseumNotice> selectMuseumNoticeList(MuseumNotice museumNotice)
    {
        return museumNoticeMapper.selectMuseumNoticeList(museumNotice);
    }

    /**
     * 新增消息
     * 
     * @param museumNotice 消息
     * @return 结果
     */
    @Override
    public int insertMuseumNotice(MuseumNotice museumNotice)
    {
        museumNotice.setCreateTime(DateUtils.getNowDate());
        return museumNoticeMapper.insertMuseumNotice(museumNotice);
    }

    /**
     * 修改消息
     * 
     * @param museumNotice 消息
     * @return 结果
     */
    @Override
    public int updateMuseumNotice(MuseumNotice museumNotice)
    {
        return museumNoticeMapper.updateMuseumNotice(museumNotice);
    }

    /**
     * 批量删除消息
     * 
     * @param noticeIds 需要删除的消息主键
     * @return 结果
     */
    @Override
    public int deleteMuseumNoticeByNoticeIds(Long[] noticeIds)
    {
        return museumNoticeMapper.deleteMuseumNoticeByNoticeIds(noticeIds);
    }

    /**
     * 删除消息信息
     * 
     * @param noticeId 消息主键
     * @return 结果
     */
    @Override
    public int deleteMuseumNoticeByNoticeId(Long noticeId)
    {
        return museumNoticeMapper.deleteMuseumNoticeByNoticeId(noticeId);
    }
}
