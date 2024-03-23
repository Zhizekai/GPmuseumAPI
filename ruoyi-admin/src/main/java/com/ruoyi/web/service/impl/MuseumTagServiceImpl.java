package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumTagMapper;
import com.ruoyi.web.domain.MuseumTag;
import com.ruoyi.web.service.IMuseumTagService;

/**
 * 标签Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-19
 */
@Service
public class MuseumTagServiceImpl implements IMuseumTagService 
{
    @Autowired
    private MuseumTagMapper museumTagMapper;

    /**
     * 查询标签
     * 
     * @param tagId 标签主键
     * @return 标签
     */
    @Override
    public MuseumTag selectMuseumTagByTagId(Long tagId)
    {
        return museumTagMapper.selectMuseumTagByTagId(tagId);
    }

    /**
     * 查询标签列表
     * 
     * @param museumTag 标签
     * @return 标签
     */
    @Override
    public List<MuseumTag> selectMuseumTagList(MuseumTag museumTag)
    {
        return museumTagMapper.selectMuseumTagList(museumTag);
    }

    /**
     * 新增标签
     * 
     * @param museumTag 标签
     * @return 结果
     */
    @Override
    public int insertMuseumTag(MuseumTag museumTag)
    {
        museumTag.setCreateTime(DateUtils.getNowDate());
        return museumTagMapper.insertMuseumTag(museumTag);
    }

    /**
     * 修改标签
     * 
     * @param museumTag 标签
     * @return 结果
     */
    @Override
    public int updateMuseumTag(MuseumTag museumTag)
    {
        return museumTagMapper.updateMuseumTag(museumTag);
    }

    /**
     * 批量删除标签
     * 
     * @param tagIds 需要删除的标签主键
     * @return 结果
     */
    @Override
    public int deleteMuseumTagByTagIds(Long[] tagIds)
    {
        return museumTagMapper.deleteMuseumTagByTagIds(tagIds);
    }

    /**
     * 删除标签信息
     * 
     * @param tagId 标签主键
     * @return 结果
     */
    @Override
    public int deleteMuseumTagByTagId(Long tagId)
    {
        return museumTagMapper.deleteMuseumTagByTagId(tagId);
    }
}
