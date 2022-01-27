package com.zhy.hr.userinfo.mapper;

import java.util.List;

import com.zhy.hr.userinfo.domain.JobLevel;

/**
 * 职称Mapper接口
 *
 * @author zhy
 * @date 2022-01-27
 */
public interface JobLevelMapper {
    /**
     * 查询职称
     *
     * @param id 职称主键
     * @return 职称
     */
    public JobLevel selectJobLevelById(Long id);

    /**
     * 查询职称列表
     *
     * @param jobLevel 职称
     * @return 职称集合
     */
    public List<JobLevel> selectJobLevelList(JobLevel jobLevel);

    /**
     * 新增职称
     *
     * @param jobLevel 职称
     * @return 结果
     */
    public int insertJobLevel(JobLevel jobLevel);

    /**
     * 修改职称
     *
     * @param jobLevel 职称
     * @return 结果
     */
    public int updateJobLevel(JobLevel jobLevel);

    /**
     * 删除职称
     *
     * @param id 职称主键
     * @return 结果
     */
    public int deleteJobLevelById(Long id);

    /**
     * 批量删除职称
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobLevelByIds(Long[] ids);
}
