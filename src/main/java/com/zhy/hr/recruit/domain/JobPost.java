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
     *
     */
    private String subTitle;

    /**
     * 职位描述
     */
    @Excel(name = "职位描述")
    private String description;

    /**
     * 职位要求
     */
    @Excel(name = "职位要求")
    private String requirement;

    /**
     * 职位类型
     */
    private String jobCategoryId;

    @Excel(name = "职位类型", targetAttr = "name")
    private JobType jobCategory;

    /**
     * 城市信息
     */
    private String cityInfoId;

    @Excel(name = "职位名称", targetAttr = "name")
    private City cityInfo;

    /**
     * 招聘类型
     */
    private String recruitType;

    @Excel(name = "职位名称")
    private RecruitType recruit;

    /**
     * 发布时间
     */

    private Long publishTime;

    @Excel(name = "发布时间")
    private String publishDate;

    /**
     * 投递信息
     */
    private String deliveryInfoId;

    /**
     *
     */
    private Long channelOnlineStatus;

    /**
     *
     */
    private Long jobHotFlag;

    /**
     *
     */
    private String jobSubject;

    /**
     *
     */
    private String code;

    /**
     *
     */
    private String departmentId;

    /**
     *
     */
    private String jobProcessId;

    /**
     *
     */
    private String jobId;

    /**
     *
     */
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
