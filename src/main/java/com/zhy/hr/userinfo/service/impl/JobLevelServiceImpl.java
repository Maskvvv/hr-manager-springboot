package com.zhy.hr.userinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.userinfo.mapper.JobLevelMapper;
import com.zhy.hr.userinfo.domain.JobLevel;
import com.zhy.hr.userinfo.service.IJobLevelService;

/**
 * 职称Service业务层处理
 *
 * @author zhy
 * @date 2022-01-27
 */
@Service
public class JobLevelServiceImpl implements IJobLevelService {
    @Autowired
    private JobLevelMapper jobLevelMapper;

    /**
     * 查询职称
     *
     * @param id 职称主键
     * @return 职称
     */
    @Override
    public JobLevel selectJobLevelById(Long id) {
        return jobLevelMapper.selectJobLevelById(id);
    }

    /**
     * 查询职称列表
     *
     * @param jobLevel 职称
     * @return 职称
     */
    @Override
    public List<JobLevel> selectJobLevelList(JobLevel jobLevel) {
        return jobLevelMapper.selectJobLevelList(jobLevel);
    }

    /**
     * 新增职称
     *
     * @param jobLevel 职称
     * @return 结果
     */
    @Override
    public int insertJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.insertJobLevel(jobLevel);
    }

    /**
     * 修改职称
     *
     * @param jobLevel 职称
     * @return 结果
     */
    @Override
    public int updateJobLevel(JobLevel jobLevel) {
        return jobLevelMapper.updateJobLevel(jobLevel);
    }

    /**
     * 批量删除职称
     *
     * @param ids 需要删除的职称主键
     * @return 结果
     */
    @Override
    public int deleteJobLevelByIds(Long[] ids) {
        return jobLevelMapper.deleteJobLevelByIds(ids);
    }

    /**
     * 删除职称信息
     *
     * @param id 职称主键
     * @return 结果
     */
    @Override
    public int deleteJobLevelById(Long id) {
        return jobLevelMapper.deleteJobLevelById(id);
    }
}
