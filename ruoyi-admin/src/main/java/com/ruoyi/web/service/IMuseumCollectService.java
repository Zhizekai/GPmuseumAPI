package com.ruoyi.web.service;

import java.util.List;

import com.ruoyi.web.domain.MuseumAntique;
import com.ruoyi.web.domain.MuseumCollect;

/**
 * 收藏Service接口
 * 
 * @author keloid
 * @date 2024-02-20
 */
public interface IMuseumCollectService 
{
    /**
     * 查询收藏
     * 
     * @param collectId 收藏主键
     * @return 收藏
     */
    public MuseumCollect selectMuseumCollectByCollectId(Long collectId);

    /**
     * 查询收藏列表
     * 
     * @param museumCollect 收藏
     * @return 收藏集合
     */
    public List<MuseumCollect> selectMuseumCollectList(MuseumCollect museumCollect);

    public List<MuseumAntique> selectCollectionByUserId(Long userId);

    /**
     * 新增收藏
     * 
     * @param museumCollect 收藏
     * @return 结果
     */
    public int insertMuseumCollect(MuseumCollect museumCollect);

    /**
     * 修改收藏
     * 
     * @param museumCollect 收藏
     * @return 结果
     */
    public int updateMuseumCollect(MuseumCollect museumCollect);

    /**
     * 批量删除收藏
     * 
     * @param collectIds 需要删除的收藏主键集合
     * @return 结果
     */
    public int deleteMuseumCollectByCollectIds(Long[] collectIds);

    /**
     * 删除收藏信息
     * 
     * @param collectId 收藏主键
     * @return 结果
     */
    public int deleteMuseumCollectByCollectId(Long collectId);
}
