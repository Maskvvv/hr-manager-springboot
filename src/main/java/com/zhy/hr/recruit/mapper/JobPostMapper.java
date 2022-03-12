package com.zhy.hr.recruit.mapper;

import java.util.List;

import com.zhy.hr.recruit.domain.JobPost;

/**
 * 招聘职位Mapper接口
 *
 * @author ruoyi
 * @date 2022-03-12
 */
public interface JobPostMapper {
    /**
     * 查询招聘职位
     *
     * @param id 招聘职位主键
     * @return 招聘职位
     */
    public JobPost selectJobPostById(String id);

    /**
     * 查询招聘职位列表
     *
     * @param jobPost 招聘职位
     * @return 招聘职位集合
     */
    public List<JobPost> selectJobPostList(JobPost jobPost);

    /**
     * 新增招聘职位
     *
     * @param jobPost 招聘职位
     * @return 结果
     */
    public int insertJobPost(JobPost jobPost);

    /**
     * 修改招聘职位
     *
     * @param jobPost 招聘职位
     * @return 结果
     */
    public int updateJobPost(JobPost jobPost);

    /**
     * 删除招聘职位
     *
     * @param id 招聘职位主键
     * @return 结果
     */
    public int deleteJobPostById(String id);

    /**
     * 批量删除招聘职位
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteJobPostByIds(String[] ids);
}
