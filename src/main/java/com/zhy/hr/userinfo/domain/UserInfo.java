package com.zhy.hr.userinfo.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhy.common.core.domain.entity.SysDept;
import com.zhy.common.core.domain.entity.SysUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

}
