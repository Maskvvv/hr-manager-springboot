package com.zhy.hr.userinfo.service;

import java.util.List;
import com.zhy.hr.userinfo.domain.Nation;

/**
 * 民族Service接口
 * 
 * @author zhy
 * @date 2022-01-25
 */
public interface INationService 
{
    /**
     * 查询民族
     * 
     * @param nationId 民族主键
     * @return 民族
     */
    public Nation selectNationByNationId(Long nationId);

    /**
     * 查询民族列表
     * 
     * @param nation 民族
     * @return 民族集合
     */
    public List<Nation> selectNationList(Nation nation);

    /**
     * 新增民族
     * 
     * @param nation 民族
     * @return 结果
     */
    public int insertNation(Nation nation);

    /**
     * 修改民族
     * 
     * @param nation 民族
     * @return 结果
     */
    public int updateNation(Nation nation);

    /**
     * 批量删除民族
     * 
     * @param nationIds 需要删除的民族主键集合
     * @return 结果
     */
    public int deleteNationByNationIds(Long[] nationIds);

    /**
     * 删除民族信息
     * 
     * @param nationId 民族主键
     * @return 结果
     */
    public int deleteNationByNationId(Long nationId);
}
