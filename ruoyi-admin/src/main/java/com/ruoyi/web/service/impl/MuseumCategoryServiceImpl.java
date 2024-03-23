package com.ruoyi.web.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumCategoryMapper;
import com.ruoyi.web.domain.MuseumCategory;
import com.ruoyi.web.service.IMuseumCategoryService;

/**
 * 分类Service业务层处理
 * 
 * @author keloid
 * @date 2024-02-19
 */
@Service
public class MuseumCategoryServiceImpl implements IMuseumCategoryService 
{
    @Autowired
    private MuseumCategoryMapper museumCategoryMapper;

    /**
     * 查询分类
     * 
     * @param categoryId 分类主键
     * @return 分类
     */
    @Override
    public MuseumCategory selectMuseumCategoryByCategoryId(Integer categoryId)
    {
        return museumCategoryMapper.selectMuseumCategoryByCategoryId(categoryId);
    }

    /**
     * 查询分类列表
     * 
     * @param museumCategory 分类
     * @return 分类
     */
    @Override
    public List<MuseumCategory> selectMuseumCategoryList(MuseumCategory museumCategory)
    {
        return museumCategoryMapper.selectMuseumCategoryList(museumCategory);
    }

    /**
     * 新增分类
     * 
     * @param museumCategory 分类
     * @return 结果
     */
    @Override
    public int insertMuseumCategory(MuseumCategory museumCategory)
    {
        return museumCategoryMapper.insertMuseumCategory(museumCategory);
    }

    /**
     * 修改分类
     * 
     * @param museumCategory 分类
     * @return 结果
     */
    @Override
    public int updateMuseumCategory(MuseumCategory museumCategory)
    {
        return museumCategoryMapper.updateMuseumCategory(museumCategory);
    }

    /**
     * 批量删除分类
     * 
     * @param categoryIds 需要删除的分类主键
     * @return 结果
     */
    @Override
    public int deleteMuseumCategoryByCategoryIds(Integer[] categoryIds)
    {
        return museumCategoryMapper.deleteMuseumCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除分类信息
     * 
     * @param categoryId 分类主键
     * @return 结果
     */
    @Override
    public int deleteMuseumCategoryByCategoryId(Integer categoryId)
    {
        return museumCategoryMapper.deleteMuseumCategoryByCategoryId(categoryId);
    }
}
