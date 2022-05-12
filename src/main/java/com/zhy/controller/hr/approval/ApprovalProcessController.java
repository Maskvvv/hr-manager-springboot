package com.zhy.controller.hr.approval;

import com.zhy.common.annotation.Log;
import com.zhy.common.core.controller.BaseController;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.page.TableDataInfo;
import com.zhy.common.enums.BusinessType;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.hr.approval.domain.ApprovalProcess;
import com.zhy.hr.approval.service.IApprovalProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 审批申请Controller
 *
 * @author zhy
 * @date 2022-01-23
 */
@RestController
@RequestMapping("/approval/apply")
public class ApprovalProcessController extends BaseController {
    @Autowired
    private IApprovalProcessService approvalProcessService;

    /**
     * 审批人查询审批申请列表
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:query')")
    @GetMapping("/approval/list")
    public TableDataInfo approvalList(ApprovalProcess approvalProcess) {
        startPage();
        List<ApprovalProcess> list = approvalProcessService.selectApprovalList(approvalProcess);
        return getDataTable(list);
    }

    /**
     * 查询审批申请列表
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:query')")
    @GetMapping("/list")
    public TableDataInfo applyList(ApprovalProcess approvalProcess) {
        startPage();
        List<ApprovalProcess> list = approvalProcessService.selectApplyList(approvalProcess);
        return getDataTable(list);
    }

    /**
     * 导出审批申请列表
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:export')")
    @Log(title = "审批申请", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ApprovalProcess approvalProcess) {
        List<ApprovalProcess> list = approvalProcessService.selectApplyList(approvalProcess);
        ExcelUtil<ApprovalProcess> util = new ExcelUtil<ApprovalProcess>(ApprovalProcess.class);
        return util.exportExcel(list, "审批申请数据");
    }

    /**
     * 获取审批申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:query')")
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") String approvalId) {
        return AjaxResult.success(approvalProcessService.selectApprovalProcessByApprovalId(approvalId));
    }

    /**
     * 新增审批申请
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:add')")
    @Log(title = "审批申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ApprovalProcess approvalProcess) {
        return toAjax(approvalProcessService.insertApprovalProcess(approvalProcess));
    }

    /**
     * 修改审批申请
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:edit')")
    @Log(title = "审批申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ApprovalProcess approvalProcess) {
        return toAjax(approvalProcessService.updateApprovalProcess(approvalProcess));
    }

    /**
     * 删除审批申请
     */
    @PreAuthorize("@ss.hasPermi('approval:apply:remove')")
    @Log(title = "审批申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable String[] approvalIds) {
        return toAjax(approvalProcessService.deleteApprovalProcessByApprovalIds(approvalIds));
    }
}
