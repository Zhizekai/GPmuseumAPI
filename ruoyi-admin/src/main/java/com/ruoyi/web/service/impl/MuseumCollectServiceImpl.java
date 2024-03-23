package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.domain.MuseumAntique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumCollectMapper;
import com.ruoyi.web.domain.MuseumCollect;
import com.ruoyi.web.service.IMuseumCollectService;

/**
 * 收藏Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-20
 */
@Service
public class MuseumCollectServiceImpl implements IMuseumCollectService 
{
    @Autowired
    private MuseumCollectMapper museumCollectMapper;

    /**
     * 查询收藏
     * 
     * @param collectId 收藏主键
     * @return 收藏
     */
    @Override
    public MuseumCollect selectMuseumCollectByCollectId(Long collectId)
    {
        return museumCollectMapper.selectMuseumCollectByCollectId(collectId);
    }

    /**
     * 查询收藏列表
     * 
     * @param museumCollect 收藏
     * @return 收藏
     */
    @Override
    public List<MuseumCollect> selectMuseumCollectList(MuseumCollect museumCollect)
    {
        return museumCollectMapper.selectMuseumCollectList(museumCollect);
    }


    @Override
    public List<MuseumAntique> selectCollectionByUserId(Long userId) {
        return museumCollectMapper.selectCollectionByUserId(userId);
    }

    /**
     * 新增收藏
     * 
     * @param museumCollect 收藏
     * @return 结果
     */
    @Override
    public int insertMuseumCollect(MuseumCollect museumCollect)
    {
        museumCollect.setCreateTime(DateUtils.getNowDate());
        return museumCollectMapper.insertMuseumCollect(museumCollect);
    }

    /**
     * 修改收藏
     * 
     * @param museumCollect 收藏
     * @return 结果
     */
    @Override
    public int updateMuseumCollect(MuseumCollect museumCollect)
    {
        return museumCollectMapper.updateMuseumCollect(museumCollect);
    }

    /**
     * 批量删除收藏
     * 
     * @param collectIds 需要删除的收藏主键
     * @return 结果
     */
    @Override
    public int deleteMuseumCollectByCollectIds(Long[] collectIds)
    {
        return museumCollectMapper.deleteMuseumCollectByCollectIds(collectIds);
    }

    /**
     * 删除收藏信息
     * 
     * @param collectId 收藏主键
     * @return 结果
     */
    @Override
    public int deleteMuseumCollectByCollectId(Long collectId)
    {
        return museumCollectMapper.deleteMuseumCollectByCollectId(collectId);
    }
}
