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
import com.ruoyi.web.domain.MuseumAppointment;
import com.ruoyi.web.service.IMuseumAppointmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预定管理Controller
 * 
 * @author keloid
 * @date 2024-03-24
 */
@RestController
@RequestMapping("/web/appointment")
public class MuseumAppointmentController extends BaseController
{
    @Autowired
    private IMuseumAppointmentService museumAppointmentService;

    /**
     * 查询预定管理列表
     */
    @PreAuthorize("@ss.hasPermi('web:appointment:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumAppointment museumAppointment)
    {
        startPage();
        List<MuseumAppointment> list = museumAppointmentService.selectMuseumAppointmentList(museumAppointment);
        return getDataTable(list);
    }

    /**
     * 导出预定管理列表
     */
    @PreAuthorize("@ss.hasPermi('web:appointment:export')")
    @Log(title = "预定管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumAppointment museumAppointment)
    {
        List<MuseumAppointment> list = museumAppointmentService.selectMuseumAppointmentList(museumAppointment);
        ExcelUtil<MuseumAppointment> util = new ExcelUtil<MuseumAppointment>(MuseumAppointment.class);
        util.exportExcel(response, list, "预定管理数据");
    }

    /**
     * 获取预定管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:appointment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(museumAppointmentService.selectMuseumAppointmentById(id));
    }

    /**
     * 新增预定管理
     */
    @PreAuthorize("@ss.hasPermi('web:appointment:add')")
    @Log(title = "预定管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumAppointment museumAppointment)
    {
        return toAjax(museumAppointmentService.insertMuseumAppointment(museumAppointment));
    }

    /**
     * 修改预定管理
     */
    @PreAuthorize("@ss.hasPermi('web:appointment:edit')")
    @Log(title = "预定管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumAppointment museumAppointment)
    {
        return toAjax(museumAppointmentService.updateMuseumAppointment(museumAppointment));
    }

    /**
     * 删除预定管理
     */
    @PreAuthorize("@ss.hasPermi('web:appointment:remove')")
    @Log(title = "预定管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(museumAppointmentService.deleteMuseumAppointmentByIds(ids));
    }
}
