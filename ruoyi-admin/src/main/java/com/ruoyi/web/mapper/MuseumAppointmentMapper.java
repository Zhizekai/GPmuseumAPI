package com.ruoyi.web.mapper;

import java.util.List;
import com.ruoyi.web.domain.MuseumAppointment;

/**
 * 预定管理Mapper接口
 * 
 * @author keloid
 * @date 2024-03-24
 */
public interface MuseumAppointmentMapper 
{
    /**
     * 查询预定管理
     * 
     * @param id 预定管理主键
     * @return 预定管理
     */
    public MuseumAppointment selectMuseumAppointmentById(Long id);

    /**
     * 查询预定管理列表
     * 
     * @param museumAppointment 预定管理
     * @return 预定管理集合
     */
    public List<MuseumAppointment> selectMuseumAppointmentList(MuseumAppointment museumAppointment);

    /**
     * 新增预定管理
     * 
     * @param museumAppointment 预定管理
     * @return 结果
     */
    public int insertMuseumAppointment(MuseumAppointment museumAppointment);

    /**
     * 修改预定管理
     * 
     * @param museumAppointment 预定管理
     * @return 结果
     */
    public int updateMuseumAppointment(MuseumAppointment museumAppointment);

    /**
     * 删除预定管理
     * 
     * @param id 预定管理主键
     * @return 结果
     */
    public int deleteMuseumAppointmentById(Long id);

    /**
     * 批量删除预定管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMuseumAppointmentByIds(Long[] ids);
}
