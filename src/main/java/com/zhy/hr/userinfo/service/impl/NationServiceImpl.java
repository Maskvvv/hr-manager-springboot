package com.zhy.hr.userinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.userinfo.mapper.NationMapper;
import com.zhy.hr.userinfo.domain.Nation;
import com.zhy.hr.userinfo.service.INationService;

/**
 * 民族Service业务层处理
 *
 * @author zhy
 * @date 2022-01-25
 */
@Service
public class NationServiceImpl implements INationService {
    @Autowired
    private NationMapper nationMapper;

    /**
     * 查询民族
     *
     * @param nationId 民族主键
     * @return 民族
     */
    @Override
    public Nation selectNationByNationId(Long nationId) {
        return nationMapper.selectNationByNationId(nationId);
    }

    /**
     * 查询民族列表
     *
     * @param nation 民族
     * @return 民族
     */
    @Override
    public List<Nation> selectNationList(Nation nation) {
        return nationMapper.selectNationList(nation);
    }

    /**
     * 新增民族
     *
     * @param nation 民族
     * @return 结果
     */
    @Override
    public int insertNation(Nation nation) {
        return nationMapper.insertNation(nation);
    }

    /**
     * 修改民族
     *
     * @param nation 民族
     * @return 结果
     */
    @Override
    public int updateNation(Nation nation) {
        return nationMapper.updateNation(nation);
    }

    /**
     * 批量删除民族
     *
     * @param nationIds 需要删除的民族主键
     * @return 结果
     */
    @Override
    public int deleteNationByNationIds(Long[] nationIds) {
        return nationMapper.deleteNationByNationIds(nationIds);
    }

    /**
     * 删除民族信息
     *
     * @param nationId 民族主键
     * @return 结果
     */
    @Override
    public int deleteNationByNationId(Long nationId) {
        return nationMapper.deleteNationByNationId(nationId);
    }
}
