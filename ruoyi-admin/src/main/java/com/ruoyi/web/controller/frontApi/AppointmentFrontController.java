package com.ruoyi.web.controller.frontApi;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.MuseumAppointment;
import com.ruoyi.web.service.IMuseumAppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 预定管理Controller
 * 
 * @author keloid
 * @date 2024-03-24
 */
@Api(tags = "前台预约模块")
@RestController
@RequestMapping("/v1/appointment")
public class AppointmentFrontController extends BaseController
{
    @Autowired
    private IMuseumAppointmentService museumAppointmentService;

    /**
     * 查询当前用户预约信息
     */
    @ApiOperation("获取用户预约列表")
    @GetMapping("/list")
    public TableDataInfo list(MuseumAppointment museumAppointment)
    {
        startPage();
        List<MuseumAppointment> list = museumAppointmentService.selectMuseumAppointmentList(museumAppointment);
        return getDataTable(list);
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
    @ApiOperation("添加用户预约")
    @PostMapping("/add")
    public AjaxResult add(@RequestBody MuseumAppointment museumAppointment)
    {
        return toAjax(museumAppointmentService.insertMuseumAppointment(museumAppointment));
    }

    /**
     * 修改预定管理
     */
    @ApiOperation("修改用户预约")
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody MuseumAppointment museumAppointment)
    {
        return toAjax(museumAppointmentService.updateMuseumAppointment(museumAppointment));
    }

    /**
     * 删除预定管理
     */
    @ApiOperation("删除用户预约")
	@GetMapping("/delete")
    public AjaxResult remove(Long id)
    {
        return toAjax(museumAppointmentService.deleteMuseumAppointmentById(id));
    }
}
