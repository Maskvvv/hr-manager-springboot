package com.zhy.hr.userinfo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhy.common.core.domain.entity.SysDept;
import com.zhy.common.core.domain.entity.SysUser;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

/**
 * 用户详细信息对象 user_info
 *
 * @author zhy
 * @date 2022-01-27
 */
@Data
public class UserInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    private Long userInfoId;

    /**
     * 套账id
     */
    @Excel(name = "套账id")
    private Long salaryId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 员工姓名
     */
    @Excel(name = "员工姓名")
    private String userInfoName;

    /**
     * 出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 身份证号
     */
    @Excel(name = "身份证号")
    private String idCard;

    /**
     * 婚姻状况
     */
    @Excel(name = "婚姻状况")
    private String maritalStatus;

    /**
     * 民族
     */
    @Excel(name = "民族")
    private Long nationId;

    /**
     * 籍贯
     */
    @Excel(name = "籍贯")
    private String nativePlace;

    /**
     * 政治面貌
     */
    @Excel(name = "政治面貌")
    private Long politicsId;

    /**
     * 联系地址
     */
    @Excel(name = "联系地址")
    private String address;

    /**
     * 职称ID
     */
    @Excel(name = "职称ID")
    private Long jobLevelId;

    /**
     * 聘用形式
     */
    @Excel(name = "聘用形式")
    private String engageForm;

    /**
     * 最高学历
     */
    @Excel(name = "最高学历")
    private String tiptopDegree;

    /**
     * 所属专业
     */
    @Excel(name = "所属专业")
    private String specialty;

    /**
     * 毕业院校
     */
    @Excel(name = "毕业院校")
    private String school;

    /**
     * 入职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginDate;

    /**
     * 在职状态
     */
    @Excel(name = "在职状态")
    private String workState;

    /**
     * 转正日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "转正日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date conversionTime;

    /**
     * 离职日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "离职日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date notWorkDate;

    /**
     * 合同起始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同起始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginContract;

    /**
     * 合同终止日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "合同终止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endContract;

    /**
     * 工龄
     */
    @Excel(name = "工龄")
    private Long workAge;

    /**
     * 套账
     */
    private Salary salary;

    /**
     * 用户
     */
    private SysUser sysUser;

    /**
     * 民族
     */
    private Nation nation;

    /**
     * 政治面貌
     */
    private PoliticsStatus politicsStatus;

    /**
     * 职称
     */
    private JobLevel jobLevel;

    /**
     * 部门
     */
    private SysDept sysDept;

    public void setUserInfoId(Long userInfoId) {
        this.userInfoId = userInfoId;
    }

    public Long getUserInfoId() {
        return userInfoId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserInfoName(String userInfoName) {
        this.userInfoName = userInfoName;
    }

    public String getUserInfoName() {
        return userInfoName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setPoliticsId(Long politicsId) {
        this.politicsId = politicsId;
    }

    public Long getPoliticsId() {
        return politicsId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setJobLevelId(Long jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public Long getJobLevelId() {
        return jobLevelId;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkState() {
        return workState;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setWorkAge(Long workAge) {
        this.workAge = workAge;
    }

    public Long getWorkAge() {
        return workAge;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userInfoId", getUserInfoId())
                .append("salaryId", getSalaryId())
                .append("userId", getUserId())
                .append("userInfoName", getUserInfoName())
                .append("birthday", getBirthday())
                .append("idCard", getIdCard())
                .append("maritalStatus", getMaritalStatus())
                .append("nationId", getNationId())
                .append("nativePlace", getNativePlace())
                .append("politicsId", getPoliticsId())
                .append("address", getAddress())
                .append("jobLevelId", getJobLevelId())
                .append("engageForm", getEngageForm())
                .append("tiptopDegree", getTiptopDegree())
                .append("specialty", getSpecialty())
                .append("school", getSchool())
                .append("beginDate", getBeginDate())
                .append("workState", getWorkState())
                .append("conversionTime", getConversionTime())
                .append("notWorkDate", getNotWorkDate())
                .append("beginContract", getBeginContract())
                .append("endContract", getEndContract())
                .append("workAge", getWorkAge())
                .toString();
    }
}
