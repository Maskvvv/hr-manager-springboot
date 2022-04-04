package com.zhy.hr.recruit.domain;

import cn.hutool.json.JSONUtil;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 招聘职位对象 job_post
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@Data
public class JobPost extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private String id;

    /**
     * 职位名称
     */
    @Excel(name = "职位名称")
    private String title;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String subTitle;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String description;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String requirement;

    /**
     * 职位类型
     */
    @Excel(name = "职位名称")
    private String jobCategoryId;

    private JobType jobCategory;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String cityInfoId;

    private City cityInfo;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String recruitType;

    private RecruitType recruit;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private Long publishTime;

    private String publishDate;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String deliveryInfoId;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private Long channelOnlineStatus;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private Long jobHotFlag;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String jobSubject;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String code;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String departmentId;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String jobProcessId;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String jobId;

    /**
     * $column.columnComment
     */
    @Excel(name = "职位名称")
    private String cityList;

    private JobPostParam jobPostParam;

    public RecruitType getRecruit() {
        this.setRecruit(JSONUtil.toBean(this.getRecruitType(), RecruitType.class));
        return recruit;
    }

    public void setRecruit(RecruitType recruit) {
        this.recruit = recruit;
    }

    public String getPublishDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return this.publishTime == null ? "" : dateFormat.format(new Date(this.publishTime));
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
