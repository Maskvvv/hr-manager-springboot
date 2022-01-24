package com.zhy.hr.approval.mapper;

import java.util.List;

import com.zhy.hr.approval.domain.ApprovalProcess;

/**
 * 审批申请Mapper接口
 *
 * @author zhy
 * @date 2022-01-23
 */
public interface ApprovalProcessMapper {
    /**
     * 查询审批申请
     *
     * @param approvalId 审批申请主键
     * @return 审批申请
     */
    public ApprovalProcess selectApprovalProcessByApprovalId(String approvalId);

    /**
     * 查询审批申请列表
     *
     * @param approvalProcess 审批申请
     * @return 审批申请集合
     */
    public List<ApprovalProcess> selectApprovalProcessList(ApprovalProcess approvalProcess);

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
     * 删除审批申请
     *
     * @param approvalId 审批申请主键
     * @return 结果
     */
    public int deleteApprovalProcessByApprovalId(String approvalId);

    /**
     * 批量删除审批申请
     *
     * @param approvalIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteApprovalProcessByApprovalIds(String[] approvalIds);
}
