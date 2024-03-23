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
import com.ruoyi.web.domain.MuseumComment;
import com.ruoyi.web.service.IMuseumCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论Controller
 * 
 * @author keloid
 * @date 2024-02-19
 */
@RestController
@RequestMapping("/web/comment")
public class MuseumCommentController extends BaseController
{
    @Autowired
    private IMuseumCommentService museumCommentService;

    /**
     * 查询评论列表
     */
    @PreAuthorize("@ss.hasPermi('web:comment:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumComment museumComment)
    {
        startPage();
        List<MuseumComment> list = museumCommentService.selectMuseumCommentList(museumComment);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @PreAuthorize("@ss.hasPermi('web:comment:export')")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumComment museumComment)
    {
        List<MuseumComment> list = museumCommentService.selectMuseumCommentList(museumComment);
        ExcelUtil<MuseumComment> util = new ExcelUtil<MuseumComment>(MuseumComment.class);
        util.exportExcel(response, list, "评论数据");
    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:comment:query')")
    @GetMapping(value = "/{commentId}")
    public AjaxResult getInfo(@PathVariable("commentId") Integer commentId)
    {
        return success(museumCommentService.selectMuseumCommentByCommentId(commentId));
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('web:comment:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumComment museumComment)
    {
        return toAjax(museumCommentService.insertMuseumComment(museumComment));
    }

    /**
     * 修改评论
     */
    @PreAuthorize("@ss.hasPermi('web:comment:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumComment museumComment)
    {
        return toAjax(museumCommentService.updateMuseumComment(museumComment));
    }

    /**
     * 删除评论
     */
    @PreAuthorize("@ss.hasPermi('web:comment:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commentIds}")
    public AjaxResult remove(@PathVariable Integer[] commentIds)
    {
        return toAjax(museumCommentService.deleteMuseumCommentByCommentIds(commentIds));
    }
}
