package com.zhy.hr.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.recruit.mapper.JobPostMapper;
import com.zhy.hr.recruit.domain.JobPost;
import com.zhy.hr.recruit.service.IJobPostService;

/**
 * 招聘职位Service业务层处理
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@Service
public class JobPostServiceImpl implements IJobPostService {
    @Autowired
    private JobPostMapper jobPostMapper;

    /**
     * 查询招聘职位
     *
     * @param id 招聘职位主键
     * @return 招聘职位
     */
    @Override
    public JobPost selectJobPostById(String id) {
        return jobPostMapper.selectJobPostById(id);
    }

    /**
     * 查询招聘职位列表
     *
     * @param jobPost 招聘职位
     * @return 招聘职位
     */
    @Override
    public List<JobPost> selectJobPostList(JobPost jobPost) {
        return jobPostMapper.selectJobPostList(jobPost);
    }

    /**
     * 新增招聘职位
     *
     * @param jobPost 招聘职位
     * @return 结果
     */
    @Override
    public int insertJobPost(JobPost jobPost) {
        return jobPostMapper.insertJobPost(jobPost);
    }

    /**
     * 修改招聘职位
     *
     * @param jobPost 招聘职位
     * @return 结果
     */
    @Override
    public int updateJobPost(JobPost jobPost) {
        return jobPostMapper.updateJobPost(jobPost);
    }

    /**
     * 批量删除招聘职位
     *
     * @param ids 需要删除的招聘职位主键
     * @return 结果
     */
    @Override
    public int deleteJobPostByIds(String[] ids) {
        return jobPostMapper.deleteJobPostByIds(ids);
    }

    /**
     * 删除招聘职位信息
     *
     * @param id 招聘职位主键
     * @return 结果
     */
    @Override
    public int deleteJobPostById(String id) {
        return jobPostMapper.deleteJobPostById(id);
    }
}
