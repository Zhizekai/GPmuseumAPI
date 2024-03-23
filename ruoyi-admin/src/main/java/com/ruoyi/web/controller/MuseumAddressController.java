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
import com.ruoyi.web.domain.MuseumAddress;
import com.ruoyi.web.service.IMuseumAddressService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地址Controller
 * 
 * @author keloid
 * @date 2024-03-16
 */
@RestController
@RequestMapping("/web/address")
public class MuseumAddressController extends BaseController
{
    @Autowired
    private IMuseumAddressService museumAddressService;

    /**
     * 查询地址列表
     */
    @PreAuthorize("@ss.hasPermi('web:address:list')")
    @GetMapping("/list")
    public TableDataInfo list(MuseumAddress museumAddress)
    {
        startPage();
        List<MuseumAddress> list = museumAddressService.selectMuseumAddressList(museumAddress);
        return getDataTable(list);
    }

    /**
     * 导出地址列表
     */
    @PreAuthorize("@ss.hasPermi('web:address:export')")
    @Log(title = "地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MuseumAddress museumAddress)
    {
        List<MuseumAddress> list = museumAddressService.selectMuseumAddressList(museumAddress);
        ExcelUtil<MuseumAddress> util = new ExcelUtil<MuseumAddress>(MuseumAddress.class);
        util.exportExcel(response, list, "地址数据");
    }

    /**
     * 获取地址详细信息
     */
    @PreAuthorize("@ss.hasPermi('web:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return success(museumAddressService.selectMuseumAddressByAddressId(addressId));
    }

    /**
     * 新增地址
     */
    @PreAuthorize("@ss.hasPermi('web:address:add')")
    @Log(title = "地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MuseumAddress museumAddress)
    {
        return toAjax(museumAddressService.insertMuseumAddress(museumAddress));
    }

    /**
     * 修改地址
     */
    @PreAuthorize("@ss.hasPermi('web:address:edit')")
    @Log(title = "地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MuseumAddress museumAddress)
    {
        return toAjax(museumAddressService.updateMuseumAddress(museumAddress));
    }

    /**
     * 删除地址
     */
    @PreAuthorize("@ss.hasPermi('web:address:remove')")
    @Log(title = "地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addressIds}")
    public AjaxResult remove(@PathVariable Long[] addressIds)
    {
        return toAjax(museumAddressService.deleteMuseumAddressByAddressIds(addressIds));
    }
}
