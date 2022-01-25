package com.zhy.hr.approval.domain;

import com.zhy.common.annotation.Excel;
import com.zhy.common.core.domain.BaseEntity;
import com.zhy.common.core.domain.entity.SysUser;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 审批申请对象 approval_process
 *
 * @author zhy
 * @date 2022-01-23
 */
@Data
public class ApprovalProcess extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long approvalId;

    /**
     * 审批类型
     */
    @Excel(name = "审批类型")
    private String approvalType;

    /**
     * 审批人id
     */
    @Excel(name = "审批人id")
    private Long approvalUserId;

    /**
     * 审批人
     */
    private SysUser approvalUser;

    /**
     * 审批内容
     */
    @Excel(name = "审批内容")
    private String approvalRemark;

    /**
     * 申请人id
     */
    @Excel(name = "申请人id")
    private Long applyUserId;

    /**
     * 审批人
     */
    private SysUser applyUser;

    /**
     * 审批状态
     */
    @Excel(name = "审批状态")
    private String aprrovalState;

    /**
     * 失败理由
     */
    @Excel(name = "失败理由")
    private String reasonFailure;

    /**
     * $column.columnComment
     */
    private Date passTime;

    /**
     * $column.columnComment
     */
    private Date creatTime;


    public void setApprovalType(String approvalType) {
        this.approvalType = approvalType;
    }

    public String getApprovalType() {
        return approvalType;
    }


    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }

    public String getApprovalRemark() {
        return approvalRemark;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setAprrovalState(String aprrovalState) {
        this.aprrovalState = aprrovalState;
    }

    public String getAprrovalState() {
        return aprrovalState;
    }

    public void setReasonFailure(String reasonFailure) {
        this.reasonFailure = reasonFailure;
    }

    public String getReasonFailure() {
        return reasonFailure;
    }

    public void setPassTime(Date passTime) {
        this.passTime = passTime;
    }

    public Date getPassTime() {
        return passTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("approvalId", getApprovalId())
                .append("approvalType", getApprovalType())
                .append("approvalUserId", getApprovalUserId())
                .append("approvalRemark", getApprovalRemark())
                .append("applyUserId", getApplyUserId())
                .append("aprrovalState", getAprrovalState())
                .append("reasonFailure", getReasonFailure())
                .append("passTime", getPassTime())
                .append("creatTime", getCreatTime())
                .toString();
    }
}
