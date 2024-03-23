package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.MuseumNotice;

/**
 * 消息Mapper接口
 * 
 * @author keloid
 * @date 2024-02-19
 */
public interface MuseumNoticeMapper 
{
    /**
     * 查询消息
     * 
     * @param noticeId 消息主键
     * @return 消息
     */
    public MuseumNotice selectMuseumNoticeByNoticeId(Long noticeId);

    /**
     * 查询消息列表
     * 
     * @param museumNotice 消息
     * @return 消息集合
     */
    public List<MuseumNotice> selectMuseumNoticeList(MuseumNotice museumNotice);

    /**
     * 新增消息
     * 
     * @param museumNotice 消息
     * @return 结果
     */
    public int insertMuseumNotice(MuseumNotice museumNotice);

    /**
     * 修改消息
     * 
     * @param museumNotice 消息
     * @return 结果
     */
    public int updateMuseumNotice(MuseumNotice museumNotice);

    /**
     * 删除消息
     * 
     * @param noticeId 消息主键
     * @return 结果
     */
    public int deleteMuseumNoticeByNoticeId(Long noticeId);

    /**
     * 批量删除消息
     * 
     * @param noticeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMuseumNoticeByNoticeIds(Long[] noticeIds);
}
