package com.zhy.hr.approval.service;

import com.zhy.hr.approval.domain.ApprovalProcess;

import java.util.List;


/**
 * 审批申请Service接口
 *
 * @author zhy
 * @date 2022-01-23
 */
public interface IApprovalProcessService {
    /**
     * 查询审批申请
     *
     * @param approvalId 审批申请主键
     * @return 审批申请
     */
    public ApprovalProcess selectApprovalProcessByApprovalId(String approvalId);

    /**
     * 审批人查询审批申请列表
     *
     * @param approvalProcess 审批申请
     * @return 审批申请集合
     */
    public List<ApprovalProcess> selectApprovalList(ApprovalProcess approvalProcess);

    /**
     * 查询审批申请列表
     *
     * @param approvalProcess 审批申请
     * @return 审批申请集合
     */
    public List<ApprovalProcess> selectApplyList(ApprovalProcess approvalProcess);

    /**
     * 新增审批申请
     *
     * @param approvalProcess 审批申请
     * @return 结果
     */
    public int insertApprovalProcess(ApprovalProcess approvalProcess);

    /**
     * 修改审批申请
     *
     * @param approvalProcess 审批申请
     * @return 结果
     */
    public int updateApprovalProcess(ApprovalProcess approvalProcess);

    /**
     * 批量删除审批申请
     *
     * @param approvalIds 需要删除的审批申请主键集合
     * @return 结果
     */
    public int deleteApprovalProcessByApprovalIds(String[] approvalIds);

    /**
     * 删除审批申请信息
     *
     * @param approvalId 审批申请主键
     * @return 结果
     */
    public int deleteApprovalProcessByApprovalId(String approvalId);
}
