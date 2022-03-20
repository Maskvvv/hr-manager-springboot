package com.zhy.hr.recruit.domain;

import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Map;


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

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getRequirement() {
        return requirement;
    }


    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType;
    }

    public String getRecruitType() {
        return recruitType;
    }

    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    public Long getPublishTime() {
        return publishTime;
    }

    public void setDeliveryInfoId(String deliveryInfoId) {
        this.deliveryInfoId = deliveryInfoId;
    }

    public String getDeliveryInfoId() {
        return deliveryInfoId;
    }

    public void setChannelOnlineStatus(Long channelOnlineStatus) {
        this.channelOnlineStatus = channelOnlineStatus;
    }

    public Long getChannelOnlineStatus() {
        return channelOnlineStatus;
    }

    public void setJobHotFlag(Long jobHotFlag) {
        this.jobHotFlag = jobHotFlag;
    }

    public Long getJobHotFlag() {
        return jobHotFlag;
    }

    public void setJobSubject(String jobSubject) {
        this.jobSubject = jobSubject;
    }

    public String getJobSubject() {
        return jobSubject;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setJobProcessId(String jobProcessId) {
        this.jobProcessId = jobProcessId;
    }

    public String getJobProcessId() {
        return jobProcessId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setCityList(String cityList) {
        this.cityList = cityList;
    }

    public String getCityList() {
        return cityList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("subTitle", getSubTitle())
                .append("description", getDescription())
                .append("requirement", getRequirement())
                .append("jobCategory", getJobCategory())
                .append("cityInfo", getCityInfo())
                .append("recruitType", getRecruitType())
                .append("publishTime", getPublishTime())
                .append("deliveryInfoId", getDeliveryInfoId())
                .append("channelOnlineStatus", getChannelOnlineStatus())
                .append("jobHotFlag", getJobHotFlag())
                .append("jobSubject", getJobSubject())
                .append("code", getCode())
                .append("departmentId", getDepartmentId())
                .append("jobProcessId", getJobProcessId())
                .append("jobId", getJobId())
                .append("cityList", getCityList())
                .toString();
    }
}
