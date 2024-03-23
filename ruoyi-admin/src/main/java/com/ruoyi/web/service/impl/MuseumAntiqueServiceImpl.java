package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumAntiqueMapper;
import com.ruoyi.web.domain.MuseumAntique;
import com.ruoyi.web.service.IMuseumAntiqueService;

/**
 * 古董Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-19
 */
@Service
public class MuseumAntiqueServiceImpl implements IMuseumAntiqueService 
{
    @Autowired
    private MuseumAntiqueMapper museumAntiqueMapper;



    /* 古董收藏书加一*/
    public int addCollectCount(Integer antiqueId) {
        return museumAntiqueMapper.addAntiqueCollectCount(antiqueId);
    }

    /**
     * 查询古董
     * 
     * @param antiqueId 古董主键
     * @return 古董
     */
    @Override
    public MuseumAntique selectMuseumAntiqueByAntiqueId(Integer antiqueId)
    {
        return museumAntiqueMapper.selectMuseumAntiqueByAntiqueId(antiqueId);
    }



    /**
     * 查询古董列表
     * 
     * @param museumAntique 古董
     * @return 古董
     */
    @Override
    public List<MuseumAntique> selectMuseumAntiqueList(MuseumAntique museumAntique)
    {
        return museumAntiqueMapper.selectMuseumAntiqueList(museumAntique);
    }

    /**
     * 新增古董
     * 
     * @param museumAntique 古董
     * @return 结果
     */
    @Override
    public int insertMuseumAntique(MuseumAntique museumAntique)
    {
        museumAntique.setCreateTime(DateUtils.getNowDate());
        return museumAntiqueMapper.insertMuseumAntique(museumAntique);
    }

    /**
     * 修改古董
     * 
     * @param museumAntique 古董
     * @return 结果
     */
    @Override
    public int updateMuseumAntique(MuseumAntique museumAntique)
    {
        return museumAntiqueMapper.updateMuseumAntique(museumAntique);
    }

    /**
     * 批量删除古董
     * 
     * @param antiqueIds 需要删除的古董主键
     * @return 结果
     */
    @Override
    public int deleteMuseumAntiqueByAntiqueIds(Integer[] antiqueIds)
    {
        return museumAntiqueMapper.deleteMuseumAntiqueByAntiqueIds(antiqueIds);
    }

    /**
     * 删除古董信息
     * 
     * @param antiqueId 古董主键
     * @return 结果
     */
    @Override
    public int deleteMuseumAntiqueByAntiqueId(Integer antiqueId)
    {
        return museumAntiqueMapper.deleteMuseumAntiqueByAntiqueId(antiqueId);
    }
}
