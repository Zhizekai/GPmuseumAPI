package com.ruoyi.web.controller.frontApi;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.controller.FrontApiBaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.petFront.APIResponse;
import com.ruoyi.common.core.domain.petFront.ResponseCode;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.domain.MuseumAddress;
import com.ruoyi.web.service.IMuseumAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 地址Controller
 * 
 * @author keloid
 * @date 2024-03-16
 */
@RestController
@RequestMapping("/v1/address")
public class AddressFrontController extends FrontApiBaseController
{
    @Autowired
    private IMuseumAddressService museumAddressService;

    /**
     * 查询地址列表
     */
//    @PreAuthorize("@ss.hasPermi('web:address:list')")
    @GetMapping("/list")
    public APIResponse list(MuseumAddress museumAddress)
    {
        startPage();
        List<MuseumAddress> list = museumAddressService.selectMuseumAddressList(museumAddress);
        return new APIResponse(ResponseCode.SUCCESS, "查询成功",list);
    }

    /**
     * 获取地址详细信息
     */
//    @PreAuthorize("@ss.hasPermi('web:address:query')")
    @GetMapping(value = "/{addressId}")
    public AjaxResult getInfo(@PathVariable("addressId") Long addressId)
    {
        return success(museumAddressService.selectMuseumAddressByAddressId(addressId));
    }

    /**
     * 新增地址
     */
//    @PreAuthorize("@ss.hasPermi('web:address:add')")
//    @Log(title = "地址", businessType = BusinessType.INSERT)
    @PostMapping("/create")
    public AjaxResult add(@RequestBody MuseumAddress museumAddress)
    {
        return toAjax(museumAddressService.insertMuseumAddress(museumAddress));
    }

    /**
     * 修改地址
     */
//    @PreAuthorize("@ss.hasPermi('web:address:edit')")
//    @Log(title = "地址", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(@RequestBody MuseumAddress museumAddress)
    {
        return toAjax(museumAddressService.updateMuseumAddress(museumAddress));
    }

    /**
     * 删除地址
     */
//    @PreAuthorize("@ss.hasPermi('web:address:remove')")
//    @Log(title = "地址", businessType = BusinessType.DELETE)
    @PostMapping("/delete")
    public AjaxResult remove(@RequestBody MuseumAddress museumAddress)
    {
        return toAjax(museumAddressService.deleteMuseumAddressByAddressId(museumAddress.getAddressId()));
    }
}
