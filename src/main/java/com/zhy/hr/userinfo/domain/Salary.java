package com.zhy.hr.userinfo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;

/**
 * 套账对象 salary
 *
 * @author zhy
 * @date 2022-01-25
 */
public class Salary extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long salaryId;

    /**
     * 套账名
     */
    @Excel(name = "套账名")
    private String salaryName;

    /**
     * 基本工资
     */
    @Excel(name = "基本工资")
    private Long basicSalary;

    /**
     * 奖金
     */
    @Excel(name = "奖金")
    private Long bonus;

    /**
     * 午餐补助
     */
    @Excel(name = "午餐补助")
    private Long lunchSalary;

    /**
     * 交通补助
     */
    @Excel(name = "交通补助")
    private Long trafficSalary;

    /**
     * 应发工资
     */
    @Excel(name = "应发工资")
    private Long allSalary;

    /**
     * 养老金基数
     */
    @Excel(name = "养老金基数")
    private Long pensionBase;

    /**
     * 养老金比率
     */
    @Excel(name = "养老金比率")
    private Long pensionPer;

    /**
     * 启用时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "启用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDate;

    /**
     * 医疗基数
     */
    @Excel(name = "医疗基数")
    private Long medicalBase;

    /**
     * 医疗保险比率
     */
    @Excel(name = "医疗保险比率")
    private Long medicalPer;

    /**
     * 公积金基数
     */
    @Excel(name = "公积金基数")
    private Long accumulationFundBase;

    /**
     * 公积金比率
     */
    @Excel(name = "公积金比率")
    private Long accumulationFundPer;

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setBasicSalary(Long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Long getBasicSalary() {
        return basicSalary;
    }

    public void setBonus(Long bonus) {
        this.bonus = bonus;
    }

    public Long getBonus() {
        return bonus;
    }

    public void setLunchSalary(Long lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public Long getLunchSalary() {
        return lunchSalary;
    }

    public void setTrafficSalary(Long trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public Long getTrafficSalary() {
        return trafficSalary;
    }

    public void setAllSalary(Long allSalary) {
        this.allSalary = allSalary;
    }

    public Long getAllSalary() {
        return allSalary;
    }

    public void setPensionBase(Long pensionBase) {
        this.pensionBase = pensionBase;
    }

    public Long getPensionBase() {
        return pensionBase;
    }

    public void setPensionPer(Long pensionPer) {
        this.pensionPer = pensionPer;
    }

    public Long getPensionPer() {
        return pensionPer;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setMedicalBase(Long medicalBase) {
        this.medicalBase = medicalBase;
    }

    public Long getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalPer(Long medicalPer) {
        this.medicalPer = medicalPer;
    }

    public Long getMedicalPer() {
        return medicalPer;
    }

    public void setAccumulationFundBase(Long accumulationFundBase) {
        this.accumulationFundBase = accumulationFundBase;
    }

    public Long getAccumulationFundBase() {
        return accumulationFundBase;
    }

    public void setAccumulationFundPer(Long accumulationFundPer) {
        this.accumulationFundPer = accumulationFundPer;
    }

    public Long getAccumulationFundPer() {
        return accumulationFundPer;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("salaryId", getSalaryId())
                .append("salaryName", getSalaryName())
                .append("basicSalary", getBasicSalary())
                .append("bonus", getBonus())
                .append("lunchSalary", getLunchSalary())
                .append("trafficSalary", getTrafficSalary())
                .append("allSalary", getAllSalary())
                .append("pensionBase", getPensionBase())
                .append("pensionPer", getPensionPer())
                .append("createDate", getCreateDate())
                .append("medicalBase", getMedicalBase())
                .append("medicalPer", getMedicalPer())
                .append("accumulationFundBase", getAccumulationFundBase())
                .append("accumulationFundPer", getAccumulationFundPer())
                .toString();
    }
}
