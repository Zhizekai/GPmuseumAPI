package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.MuseumCategory;

/**
 * 分类Mapper接口
 * 
 * @author keloid
 * @date 2024-02-19
 */
public interface MuseumCategoryMapper 
{
    /**
     * 查询分类
     * 
     * @param categoryId 分类主键
     * @return 分类
     */
    public MuseumCategory selectMuseumCategoryByCategoryId(Integer categoryId);

    /**
     * 查询分类列表
     * 
     * @param museumCategory 分类
     * @return 分类集合
     */
    public List<MuseumCategory> selectMuseumCategoryList(MuseumCategory museumCategory);

    /**
     * 新增分类
     * 
     * @param museumCategory 分类
     * @return 结果
     */
    public int insertMuseumCategory(MuseumCategory museumCategory);

    /**
     * 修改分类
     * 
     * @param museumCategory 分类
     * @return 结果
     */
    public int updateMuseumCategory(MuseumCategory museumCategory);

    /**
     * 删除分类
     * 
     * @param categoryId 分类主键
     * @return 结果
     */
    public int deleteMuseumCategoryByCategoryId(Integer categoryId);

    /**
     * 批量删除分类
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMuseumCategoryByCategoryIds(Integer[] categoryIds);
}
