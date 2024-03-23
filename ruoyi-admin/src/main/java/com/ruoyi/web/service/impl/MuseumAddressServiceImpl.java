package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumAddressMapper;
import com.ruoyi.web.domain.MuseumAddress;
import com.ruoyi.web.service.IMuseumAddressService;

/**
 * 地址Service业务层处理
 * 
 * @author keloid
 * @date 2024-03-16
 */
@Service
public class MuseumAddressServiceImpl implements IMuseumAddressService 
{
    @Autowired
    private MuseumAddressMapper museumAddressMapper;

    /**
     * 查询地址
     * 
     * @param addressId 地址主键
     * @return 地址
     */
    @Override
    public MuseumAddress selectMuseumAddressByAddressId(Long addressId)
    {
        return museumAddressMapper.selectMuseumAddressByAddressId(addressId);
    }

    /**
     * 查询地址列表
     * 
     * @param museumAddress 地址
     * @return 地址
     */
    @Override
    public List<MuseumAddress> selectMuseumAddressList(MuseumAddress museumAddress)
    {
        return museumAddressMapper.selectMuseumAddressList(museumAddress);
    }

    /**
     * 新增地址
     * 
     * @param museumAddress 地址
     * @return 结果
     */
    @Override
    public int insertMuseumAddress(MuseumAddress museumAddress)
    {
        museumAddress.setCreateTime(DateUtils.getNowDate());
        return museumAddressMapper.insertMuseumAddress(museumAddress);
    }

    /**
     * 修改地址
     * 
     * @param museumAddress 地址
     * @return 结果
     */
    @Override
    public int updateMuseumAddress(MuseumAddress museumAddress)
    {
        return museumAddressMapper.updateMuseumAddress(museumAddress);
    }

    /**
     * 批量删除地址
     * 
     * @param addressIds 需要删除的地址主键
     * @return 结果
     */
    @Override
    public int deleteMuseumAddressByAddressIds(Long[] addressIds)
    {
        return museumAddressMapper.deleteMuseumAddressByAddressIds(addressIds);
    }

    /**
     * 删除地址信息
     * 
     * @param addressId 地址主键
     * @return 结果
     */
    @Override
    public int deleteMuseumAddressByAddressId(Long addressId)
    {
        return museumAddressMapper.deleteMuseumAddressByAddressId(addressId);
    }
}
