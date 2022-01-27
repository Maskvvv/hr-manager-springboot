package com.zhy.hr.userinfo.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zhy.common.annotation.Log;
import com.zhy.common.core.controller.BaseController;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.enums.BusinessType;
import com.zhy.hr.userinfo.domain.JobLevel;
import com.zhy.hr.userinfo.service.IJobLevelService;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.common.core.page.TableDataInfo;

/**
 * 职称Controller
 *
 * @author zhy
 * @date 2022-01-27
 */
@RestController
@RequestMapping("/userinfo/joblevel")
public class JobLevelController extends BaseController {
    @Autowired
    private IJobLevelService jobLevelService;

    /**
     * 查询职称列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:joblevel:list')")
    @GetMapping("/list")
    public TableDataInfo list(JobLevel jobLevel) {
        startPage();
        List<JobLevel> list = jobLevelService.selectJobLevelList(jobLevel);
        return getDataTable(list);
    }

    /**
     * 导出职称列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:joblevel:export')")
    @Log(title = "职称", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JobLevel jobLevel) {
        List<JobLevel> list = jobLevelService.selectJobLevelList(jobLevel);
        ExcelUtil<JobLevel> util = new ExcelUtil<JobLevel>(JobLevel.class);
        return util.exportExcel(list, "职称数据");
    }

    /**
     * 获取职称详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:joblevel:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(jobLevelService.selectJobLevelById(id));
    }

    /**
     * 新增职称
     */
    @PreAuthorize("@ss.hasPermi('userinfo:joblevel:add')")
    @Log(title = "职称", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JobLevel jobLevel) {
        return toAjax(jobLevelService.insertJobLevel(jobLevel));
    }

    /**
     * 修改职称
     */
    @PreAuthorize("@ss.hasPermi('userinfo:joblevel:edit')")
    @Log(title = "职称", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JobLevel jobLevel) {
        return toAjax(jobLevelService.updateJobLevel(jobLevel));
    }

    /**
     * 删除职称
     */
    @PreAuthorize("@ss.hasPermi('userinfo:joblevel:remove')")
    @Log(title = "职称", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(jobLevelService.deleteJobLevelByIds(ids));
    }
}
