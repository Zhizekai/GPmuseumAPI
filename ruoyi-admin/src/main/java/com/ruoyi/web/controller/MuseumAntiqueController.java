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
import com.ruoyi.web.domain.MuseumAntique;
import com.ruoyi.web.service.IMuseumAntiqueService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 古董Controller
 * 
 * @author keloid
 * @date 2024-02-19
 */
@RestController
@RequestMapping("/web/antique")
public class MuseumAntiqueController extends BaseController
{
    @Autowired
    private IMuseumAntiqueService museumAntiqueService;

    /**
     * 查询古董列表
     */
    @PreAuthorize("@ss.hasPermi('web:antique:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumAntique museumAntique)
    {
        startPage();
        List<MuseumAntique> list = museumAntiqueService.selectMuseumAntiqueList(museumAntique);
        return getDataTable(list);
    }

    /**
     * 导出古董列表
     */
    @PreAuthorize("@ss.hasPermi('web:antique:export')")
    @Log(title = "古董", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumAntique museumAntique)
    {
        List<MuseumAntique> list = museumAntiqueService.selectMuseumAntiqueList(museumAntique);
        ExcelUtil<MuseumAntique> util = new ExcelUtil<MuseumAntique>(MuseumAntique.class);
        util.exportExcel(response, list, "古董数据");
    }

    /**
     * 获取古董详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:antique:query')")
    @GetMapping(value = "/{antiqueId}")
    public AjaxResult getInfo(@PathVariable("antiqueId") Integer antiqueId)
    {
        return success(museumAntiqueService.selectMuseumAntiqueByAntiqueId(antiqueId));
    }

    /**
     * 新增古董
     */
    @PreAuthorize("@ss.hasPermi('web:antique:add')")
    @Log(title = "古董", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumAntique museumAntique)
    {
        return toAjax(museumAntiqueService.insertMuseumAntique(museumAntique));
    }

    /**
     * 修改古董
     */
    @PreAuthorize("@ss.hasPermi('web:antique:edit')")
    @Log(title = "古董", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumAntique museumAntique)
    {
        return toAjax(museumAntiqueService.updateMuseumAntique(museumAntique));
    }

    /**
     * 删除古董
     */
    @PreAuthorize("@ss.hasPermi('web:antique:remove')")
    @Log(title = "古董", businessType = BusinessType.DELETE)
	@DeleteMapping("/{antiqueIds}")
    public AjaxResult remove(@PathVariable Integer[] antiqueIds)
    {
        return toAjax(museumAntiqueService.deleteMuseumAntiqueByAntiqueIds(antiqueIds));
    }
}
