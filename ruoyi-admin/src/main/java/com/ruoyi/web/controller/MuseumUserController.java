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
import com.ruoyi.web.domain.MuseumUser;
import com.ruoyi.web.service.IMuseumUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 前台用户Controller
 * 
 * @author keloid
 * @date 2024-02-19
 */
@RestController
@RequestMapping("/web/user")
public class MuseumUserController extends BaseController
{
    @Autowired
    private IMuseumUserService museumUserService;

    /**
     * 查询前台用户列表
     */
    @PreAuthorize("@ss.hasPermi('web:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumUser museumUser)
    {
        startPage();
        List<MuseumUser> list = museumUserService.selectMuseumUserList(museumUser);
        return getDataTable(list);
    }

    /**
     * 导出前台用户列表
     */
    @PreAuthorize("@ss.hasPermi('web:user:export')")
    @Log(title = "前台用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumUser museumUser)
    {
        List<MuseumUser> list = museumUserService.selectMuseumUserList(museumUser);
        ExcelUtil<MuseumUser> util = new ExcelUtil<MuseumUser>(MuseumUser.class);
        util.exportExcel(response, list, "前台用户数据");
    }

    /**
     * 获取前台用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return success(museumUserService.selectMuseumUserByUserId(userId));
    }

    /**
     * 新增前台用户
     */
    @PreAuthorize("@ss.hasPermi('web:user:add')")
    @Log(title = "前台用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumUser museumUser)
    {
        return toAjax(museumUserService.insertMuseumUser(museumUser));
    }

    /**
     * 修改前台用户
     */
    @PreAuthorize("@ss.hasPermi('web:user:edit')")
    @Log(title = "前台用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumUser museumUser)
    {
        return toAjax(museumUserService.updateMuseumUser(museumUser));
    }

    /**
     * 删除前台用户
     */
    @PreAuthorize("@ss.hasPermi('web:user:remove')")
    @Log(title = "前台用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(museumUserService.deleteMuseumUserByUserIds(userIds));
    }
}
