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
import com.ruoyi.web.domain.MuseumCollect;
import com.ruoyi.web.service.IMuseumCollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏Controller
 * 
 * @author keloid
 * @date 2024-02-20
 */
@RestController
@RequestMapping("/web/collect")
public class MuseumCollectController extends BaseController
{
    @Autowired
    private IMuseumCollectService museumCollectService;

    /**
     * 查询收藏列表
     */
    @PreAuthorize("@ss.hasPermi('web:collect:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumCollect museumCollect)
    {
        startPage();
        List<MuseumCollect> list = museumCollectService.selectMuseumCollectList(museumCollect);
        return getDataTable(list);
    }

    /**
     * 导出收藏列表
     */
    @PreAuthorize("@ss.hasPermi('web:collect:export')")
    @Log(title = "收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumCollect museumCollect)
    {
        List<MuseumCollect> list = museumCollectService.selectMuseumCollectList(museumCollect);
        ExcelUtil<MuseumCollect> util = new ExcelUtil<MuseumCollect>(MuseumCollect.class);
        util.exportExcel(response, list, "收藏数据");
    }

    /**
     * 获取收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:collect:query')")
    @GetMapping(value = "/{collectId}")
    public AjaxResult getInfo(@PathVariable("collectId") Long collectId)
    {
        return success(museumCollectService.selectMuseumCollectByCollectId(collectId));
    }

    /**
     * 新增收藏
     */
    @PreAuthorize("@ss.hasPermi('web:collect:add')")
    @Log(title = "收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumCollect museumCollect)
    {
        return toAjax(museumCollectService.insertMuseumCollect(museumCollect));
    }

    /**
     * 修改收藏
     */
    @PreAuthorize("@ss.hasPermi('web:collect:edit')")
    @Log(title = "收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumCollect museumCollect)
    {
        return toAjax(museumCollectService.updateMuseumCollect(museumCollect));
    }

    /**
     * 删除收藏
     */
    @PreAuthorize("@ss.hasPermi('web:collect:remove')")
    @Log(title = "收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{collectIds}")
    public AjaxResult remove(@PathVariable Long[] collectIds)
    {
        return toAjax(museumCollectService.deleteMuseumCollectByCollectIds(collectIds));
    }
}
