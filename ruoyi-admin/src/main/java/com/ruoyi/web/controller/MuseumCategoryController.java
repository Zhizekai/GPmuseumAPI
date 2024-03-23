package com.ruoyi.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.domain.MuseumCategory;
import com.ruoyi.web.service.IMuseumCategoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类Controller
 * 
 * @author keloid
 * @date 2024-02-19
 */
@RestController
@RequestMapping("/web/category")
public class MuseumCategoryController extends BaseController
{
    @Autowired
    private IMuseumCategoryService museumCategoryService;

    /**
     * 查询分类列表
     */
    @PreAuthorize("@ss.hasPermi('web:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumCategory museumCategory)
    {
        startPage();
        List<MuseumCategory> list = museumCategoryService.selectMuseumCategoryList(museumCategory);
        return getDataTable(list);
    }

    /**
     * 导出分类列表
     */
    @PreAuthorize("@ss.hasPermi('web:category:export')")
    @Log(title = "分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumCategory museumCategory)
    {
        List<MuseumCategory> list = museumCategoryService.selectMuseumCategoryList(museumCategory);
        ExcelUtil<MuseumCategory> util = new ExcelUtil<MuseumCategory>(MuseumCategory.class);
        util.exportExcel(response, list, "分类数据");
    }

    /**
     * 获取分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:category:query')")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Integer categoryId)
    {
        return success(museumCategoryService.selectMuseumCategoryByCategoryId(categoryId));
    }

    /**
     * 新增分类
     */
    @PreAuthorize("@ss.hasPermi('web:category:add')")
    @Log(title = "分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumCategory museumCategory)
    {
        return toAjax(museumCategoryService.insertMuseumCategory(museumCategory));
    }

    /**
     * 修改分类
     */
    @PreAuthorize("@ss.hasPermi('web:category:edit')")
    @Log(title = "分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumCategory museumCategory)
    {
        return toAjax(museumCategoryService.updateMuseumCategory(museumCategory));
    }

    /**
     * 删除分类
     */
    @PreAuthorize("@ss.hasPermi('web:category:remove')")
    @Log(title = "分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Integer[] categoryIds)
    {
        return toAjax(museumCategoryService.deleteMuseumCategoryByCategoryIds(categoryIds));
    }
}
