package com.zhy.hr.recruit.mapper;

import java.util.List;

import com.zhy.hr.recruit.domain.JobType;

/**
 * 职位类型Mapper接口
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
public interface JobTypeMapper {
    /**
     * 查询职位类型
     *
     * @param id 职位类型主键
     * @return 职位类型
     */
    public JobType selectJobTypeById(String id);

    /**
     * 查询职位类型列表
     *
     * @param jobType 职位类型
     * @return 职位类型集合
     */
    public List<JobType> selectJobTypeList(JobType jobType);

    /**
     * 新增职位类型
     *
     * @param jobType 职位类型
     * @return 结果
     */
    public int insertJobType(JobType jobType);

    /**
     * 修改职位类型
     *
     * @param jobType 职位类型
     * @return 结果
     */
    public int updateJobType(JobType jobType);

    /**
     * 删除职位类型
     *
     * @param id 职位类型主键
     * @return 结果
     */
    public int deleteJobTypeById(String id);

    /**
     * 批量删除职位类型
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobTypeByIds(String[] ids);
}
