package com.zhy.hr.recruit.service.impl;

import java.util.List;

import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.recruit.mapper.JobTypeMapper;
import com.zhy.hr.recruit.domain.JobType;
import com.zhy.hr.recruit.service.IJobTypeService;

/**
 * 职位类型Service业务层处理
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
@Service
public class JobTypeServiceImpl implements IJobTypeService {
    @Autowired
    private JobTypeMapper jobTypeMapper;

    /**
     * 查询职位类型
     *
     * @param id 职位类型主键
     * @return 职位类型
     */
    @Override
    public JobType selectJobTypeById(String id) {
        return jobTypeMapper.selectJobTypeById(id);
    }

    /**
     * 查询职位类型列表
     *
     * @param jobType 职位类型
     * @return 职位类型
     */
    @Override
    public List<JobType> selectJobTypeList(JobType jobType) {
        return jobTypeMapper.selectJobTypeList(jobType);
    }

    /**
     * 新增职位类型
     *
     * @param jobType 职位类型
     * @return 结果
     */
    @Override
    public int insertJobType(JobType jobType) {
        jobType.setId(IdUtil.simpleUUID().substring(0, 19));
        return jobTypeMapper.insertJobType(jobType);
    }

    /**
     * 修改职位类型
     *
     * @param jobType 职位类型
     * @return 结果
     */
    @Override
    public int updateJobType(JobType jobType) {
        return jobTypeMapper.updateJobType(jobType);
    }

    /**
     * 批量删除职位类型
     *
     * @param ids 需要删除的职位类型主键
     * @return 结果
     */
    @Override
    public int deleteJobTypeByIds(String[] ids) {
        return jobTypeMapper.deleteJobTypeByIds(ids);
    }

    /**
     * 删除职位类型信息
     *
     * @param id 职位类型主键
     * @return 结果
     */
    @Override
    public int deleteJobTypeById(String id) {
        return jobTypeMapper.deleteJobTypeById(id);
    }
}
