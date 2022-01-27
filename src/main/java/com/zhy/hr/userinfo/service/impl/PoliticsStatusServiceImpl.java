package com.zhy.hr.userinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.userinfo.mapper.PoliticsStatusMapper;
import com.zhy.hr.userinfo.domain.PoliticsStatus;
import com.zhy.hr.userinfo.service.IPoliticsStatusService;

/**
 * 政治面貌Service业务层处理
 *
 * @author zhy
 * @date 2022-01-27
 */
@Service
public class PoliticsStatusServiceImpl implements IPoliticsStatusService {
    @Autowired
    private PoliticsStatusMapper politicsStatusMapper;

    /**
     * 查询政治面貌
     *
     * @param politicsId 政治面貌主键
     * @return 政治面貌
     */
    @Override
    public PoliticsStatus selectPoliticsStatusByPoliticsId(Long politicsId) {
        return politicsStatusMapper.selectPoliticsStatusByPoliticsId(politicsId);
    }

    /**
     * 查询政治面貌列表
     *
     * @param politicsStatus 政治面貌
     * @return 政治面貌
     */
    @Override
    public List<PoliticsStatus> selectPoliticsStatusList(PoliticsStatus politicsStatus) {
        return politicsStatusMapper.selectPoliticsStatusList(politicsStatus);
    }

    /**
     * 新增政治面貌
     *
     * @param politicsStatus 政治面貌
     * @return 结果
     */
    @Override
    public int insertPoliticsStatus(PoliticsStatus politicsStatus) {
        return politicsStatusMapper.insertPoliticsStatus(politicsStatus);
    }

    /**
     * 修改政治面貌
     *
     * @param politicsStatus 政治面貌
     * @return 结果
     */
    @Override
    public int updatePoliticsStatus(PoliticsStatus politicsStatus) {
        return politicsStatusMapper.updatePoliticsStatus(politicsStatus);
    }

    /**
     * 批量删除政治面貌
     *
     * @param politicsIds 需要删除的政治面貌主键
     * @return 结果
     */
    @Override
    public int deletePoliticsStatusByPoliticsIds(Long[] politicsIds) {
        return politicsStatusMapper.deletePoliticsStatusByPoliticsIds(politicsIds);
    }

    /**
     * 删除政治面貌信息
     *
     * @param politicsId 政治面貌主键
     * @return 结果
     */
    @Override
    public int deletePoliticsStatusByPoliticsId(Long politicsId) {
        return politicsStatusMapper.deletePoliticsStatusByPoliticsId(politicsId);
    }
}
