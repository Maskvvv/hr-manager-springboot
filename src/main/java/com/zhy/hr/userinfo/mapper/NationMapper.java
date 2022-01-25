package com.zhy.hr.userinfo.mapper;

import java.util.List;

import com.zhy.hr.userinfo.domain.Nation;

/**
 * 民族Mapper接口
 *
 * @author zhy
 * @date 2022-01-25
 */
public interface NationMapper {
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
     * 删除民族
     *
     * @param nationId 民族主键
     * @return 结果
     */
    public int deleteNationByNationId(Long nationId);

    /**
     * 批量删除民族
     *
     * @param nationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNationByNationIds(Long[] nationIds);
}
