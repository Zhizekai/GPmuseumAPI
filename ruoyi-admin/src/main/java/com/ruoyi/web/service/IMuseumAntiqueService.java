package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.MuseumAntique;

/**
 * 古董Service接口
 * 
 * @author keloid
 * @date 2024-02-19
 */
public interface IMuseumAntiqueService 
{


    /* 古董收藏数加一*/
    public int addCollectCount(Integer antiqueId);
    /**
     * 查询古董
     * 
     * @param antiqueId 古董主键
     * @return 古董
     */
    public MuseumAntique selectMuseumAntiqueByAntiqueId(Integer antiqueId);

    /**
     * 查询古董列表
     * 
     * @param museumAntique 古董
     * @return 古董集合
     */
    public List<MuseumAntique> selectMuseumAntiqueList(MuseumAntique museumAntique);

    /**
     * 新增古董
     * 
     * @param museumAntique 古董
     * @return 结果
     */
    public int insertMuseumAntique(MuseumAntique museumAntique);

    /**
     * 修改古董
     * 
     * @param museumAntique 古董
     * @return 结果
     */
    public int updateMuseumAntique(MuseumAntique museumAntique);

    /**
     * 批量删除古董
     * 
     * @param antiqueIds 需要删除的古董主键集合
     * @return 结果
     */
    public int deleteMuseumAntiqueByAntiqueIds(Integer[] antiqueIds);

    /**
     * 删除古董信息
     * 
     * @param antiqueId 古董主键
     * @return 结果
     */
    public int deleteMuseumAntiqueByAntiqueId(Integer antiqueId);
}
