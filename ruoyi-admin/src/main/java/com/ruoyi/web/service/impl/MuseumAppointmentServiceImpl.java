package com.ruoyi.web.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.mapper.MuseumAppointmentMapper;
import com.ruoyi.web.domain.MuseumAppointment;
import com.ruoyi.web.service.IMuseumAppointmentService;

/**
 * 预定管理Service业务层处理
 * 
 * @author keloid
 * @date 2024-03-24
 */
@Service
public class MuseumAppointmentServiceImpl implements IMuseumAppointmentService 
{
    @Autowired
    private MuseumAppointmentMapper museumAppointmentMapper;

    /**
     * 查询预定管理
     * 
     * @param id 预定管理主键
     * @return 预定管理
     */
    @Override
    public MuseumAppointment selectMuseumAppointmentById(Long id)
    {
        return museumAppointmentMapper.selectMuseumAppointmentById(id);
    }

    /**
     * 查询预定管理列表
     * 
     * @param museumAppointment 预定管理
     * @return 预定管理
     */
    @Override
    public List<MuseumAppointment> selectMuseumAppointmentList(MuseumAppointment museumAppointment)
    {
        return museumAppointmentMapper.selectMuseumAppointmentList(museumAppointment);
    }

    /**
     * 新增预定管理
     * 
     * @param museumAppointment 预定管理
     * @return 结果
     */
    @Override
    public int insertMuseumAppointment(MuseumAppointment museumAppointment)
    {
        museumAppointment.setCreateTime(DateUtils.getNowDate());
        return museumAppointmentMapper.insertMuseumAppointment(museumAppointment);
    }

    /**
     * 修改预定管理
     * 
     * @param museumAppointment 预定管理
     * @return 结果
     */
    @Override
    public int updateMuseumAppointment(MuseumAppointment museumAppointment)
    {
        return museumAppointmentMapper.updateMuseumAppointment(museumAppointment);
    }

    /**
     * 批量删除预定管理
     * 
     * @param ids 需要删除的预定管理主键
     * @return 结果
     */
    @Override
    public int deleteMuseumAppointmentByIds(Long[] ids)
    {
        return museumAppointmentMapper.deleteMuseumAppointmentByIds(ids);
    }

    /**
     * 删除预定管理信息
     * 
     * @param id 预定管理主键
     * @return 结果
     */
    @Override
    public int deleteMuseumAppointmentById(Long id)
    {
        return museumAppointmentMapper.deleteMuseumAppointmentById(id);
    }
}
