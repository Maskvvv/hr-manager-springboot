package com.zhy.hr.approval.service.impl;

import com.zhy.common.core.domain.entity.SysDept;
import com.zhy.common.utils.SecurityUtils;
import com.zhy.common.utils.uuid.UUID;
import com.zhy.hr.approval.domain.ApprovalProcess;
import com.zhy.hr.approval.enums.AprrovalState;
import com.zhy.hr.approval.mapper.ApprovalProcessMapper;
import com.zhy.hr.approval.service.IApprovalProcessService;
import com.zhy.system.mapper.SysDeptMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 审批申请Service业务层处理
 *
 * @author zhy
 * @date 2022-01-23
 */
@Service
public class ApprovalProcessServiceImpl implements IApprovalProcessService {
    @Autowired
    private ApprovalProcessMapper approvalProcessMapper;

    @Resource
    private SysDeptMapper sysDeptMapper;

    /**
     * 查询审批申请
     *
     * @param approvalId 审批申请主键
     * @return 审批申请
     */
    @Override
    public ApprovalProcess selectApprovalProcessByApprovalId(String approvalId) {
        return approvalProcessMapper.selectApprovalProcessByApprovalId(approvalId);
    }

    /**
     * 审批人查询审批申请列表
     *
     * @param approvalProcess 审批申请
     * @return 审批申请
     */
    @Override
    public List<ApprovalProcess> selectApprovalList(ApprovalProcess approvalProcess) {

        // 获取审批人为自己的审批，管理员获取所有
        Long userId = SecurityUtils.getUserId();
        boolean isAdmin = SecurityUtils.isAdmin(userId);
        approvalProcess.setApprovalUserId(isAdmin ? null : userId);

        return approvalProcessMapper.selectApprovalProcessList(approvalProcess);
    }

    /**
     * 申请人查询审批申请列表
     *
     * @param approvalProcess 审批申请
     * @return 审批申请
     */
    @Override
    public List<ApprovalProcess> selectApplyList(ApprovalProcess approvalProcess) {
        // 只获取申请然是自己的审批记录
        Long userId = SecurityUtils.getUserId();
        approvalProcess.setApplyUserId(userId);
        return approvalProcessMapper.selectApprovalProcessList(approvalProcess);
    }

    /**
     * 新增审批申请
     *
     * @param approvalProcess 审批申请
     * @return 结果
     */
    @Override
    public int insertApprovalProcess(ApprovalProcess approvalProcess) {
        // 获取该人员所在部门管理者
        Long userId = sysDeptMapper.selectDeptById(SecurityUtils.getDeptId()).getUserId();

        // 初始化审批数据
        approvalProcess.setApplyUserId(SecurityUtils.getUserId());
        approvalProcess.setApprovalUserId(ObjectUtils.isEmpty(userId) ? 1L : userId);
        approvalProcess.setAprrovalState(AprrovalState.underway.getValue());
        approvalProcess.setCreatTime(new Date());
        return approvalProcessMapper.insertApprovalProcess(approvalProcess);
    }

    /**
     * 修改审批申请
     *
     * @param approvalProcess 审批申请
     * @return 结果
     */
    @Override
    public int updateApprovalProcess(ApprovalProcess approvalProcess) {
        // 设置通过时间
        if (approvalProcess.getAprrovalState().equals(AprrovalState.successful.getValue())) {
            approvalProcess.setPassTime(new Date());
        }

        if ("1".equals(approvalProcess.getAprrovalState())) {
            approvalProcess.setReasonFailure(null);
        }

        return approvalProcessMapper.updateApprovalProcess(approvalProcess);
    }

    /**
     * 批量删除审批申请
     *
     * @param approvalIds 需要删除的审批申请主键
     * @return 结果
     */
    @Override
    public int deleteApprovalProcessByApprovalIds(String[] approvalIds) {
        return approvalProcessMapper.deleteApprovalProcessByApprovalIds(approvalIds);
    }

    /**
     * 删除审批申请信息
     *
     * @param approvalId 审批申请主键
     * @return 结果
     */
    @Override
    public int deleteApprovalProcessByApprovalId(String approvalId) {
        return approvalProcessMapper.deleteApprovalProcessByApprovalId(approvalId);
    }
}
