package com.ruoyi.web.service;

import java.util.List;
import com.ruoyi.web.domain.MuseumAddress;

/**
 * 地址Service接口
 * 
 * @author keloid
 * @date 2024-03-16
 */
public interface IMuseumAddressService 
{
    /**
     * 查询地址
     * 
     * @param addressId 地址主键
     * @return 地址
     */
    public MuseumAddress selectMuseumAddressByAddressId(Long addressId);

    /**
     * 查询地址列表
     * 
     * @param museumAddress 地址
     * @return 地址集合
     */
    public List<MuseumAddress> selectMuseumAddressList(MuseumAddress museumAddress);

    /**
     * 新增地址
     * 
     * @param museumAddress 地址
     * @return 结果
     */
    public int insertMuseumAddress(MuseumAddress museumAddress);

    /**
     * 修改地址
     * 
     * @param museumAddress 地址
     * @return 结果
     */
    public int updateMuseumAddress(MuseumAddress museumAddress);

    /**
     * 批量删除地址
     * 
     * @param addressIds 需要删除的地址主键集合
     * @return 结果
     */
    public int deleteMuseumAddressByAddressIds(Long[] addressIds);

    /**
     * 删除地址信息
     * 
     * @param addressId 地址主键
     * @return 结果
     */
    public int deleteMuseumAddressByAddressId(Long addressId);
}
