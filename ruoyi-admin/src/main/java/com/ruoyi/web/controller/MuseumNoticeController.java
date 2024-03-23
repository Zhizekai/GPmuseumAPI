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
import com.ruoyi.web.domain.MuseumNotice;
import com.ruoyi.web.service.IMuseumNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息Controller
 * 
 * @author keloid
 * @date 2024-02-19
 */
@RestController
@RequestMapping("/web/notice")
public class MuseumNoticeController extends BaseController
{
    @Autowired
    private IMuseumNoticeService museumNoticeService;

    /**
     * 查询消息列表
     */
    @PreAuthorize("@ss.hasPermi('web:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumNotice museumNotice)
    {
        startPage();
        List<MuseumNotice> list = museumNoticeService.selectMuseumNoticeList(museumNotice);
        return getDataTable(list);
    }

    /**
     * 导出消息列表
     */
    @PreAuthorize("@ss.hasPermi('web:notice:export')")
    @Log(title = "消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumNotice museumNotice)
    {
        List<MuseumNotice> list = museumNoticeService.selectMuseumNoticeList(museumNotice);
        ExcelUtil<MuseumNotice> util = new ExcelUtil<MuseumNotice>(MuseumNotice.class);
        util.exportExcel(response, list, "消息数据");
    }

    /**
     * 获取消息详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:notice:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return success(museumNoticeService.selectMuseumNoticeByNoticeId(noticeId));
    }

    /**
     * 新增消息
     */
    @PreAuthorize("@ss.hasPermi('web:notice:add')")
    @Log(title = "消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumNotice museumNotice)
    {
        return toAjax(museumNoticeService.insertMuseumNotice(museumNotice));
    }

    /**
     * 修改消息
     */
    @PreAuthorize("@ss.hasPermi('web:notice:edit')")
    @Log(title = "消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumNotice museumNotice)
    {
        return toAjax(museumNoticeService.updateMuseumNotice(museumNotice));
    }

    /**
     * 删除消息
     */
    @PreAuthorize("@ss.hasPermi('web:notice:remove')")
    @Log(title = "消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(museumNoticeService.deleteMuseumNoticeByNoticeIds(noticeIds));
    }
}
