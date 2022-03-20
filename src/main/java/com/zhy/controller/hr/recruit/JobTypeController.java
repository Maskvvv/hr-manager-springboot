package com.zhy.controller.hr.recruit;

import java.util.List;

import com.zhy.common.annotation.Log;
import com.zhy.common.core.controller.BaseController;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.page.TableDataInfo;
import com.zhy.common.enums.BusinessType;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.hr.recruit.domain.JobType;
import com.zhy.hr.recruit.service.IJobTypeService;
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


/**
 * 职位类型Controller
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
@RestController
@RequestMapping("/recruit/jobType")
public class JobTypeController extends BaseController {
    @Autowired
    private IJobTypeService jobTypeService;

    /**
     * 查询职位类型列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobType:list')")
    @GetMapping("/list")
    public TableDataInfo list(JobType jobType) {
        startPage();
        List<JobType> list = jobTypeService.selectJobTypeList(jobType);
        return getDataTable(list);
    }

    /**
     * 导出职位类型列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobType:export')")
    @Log(title = "职位类型", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JobType jobType) {
        List<JobType> list = jobTypeService.selectJobTypeList(jobType);
        ExcelUtil<JobType> util = new ExcelUtil<JobType>(JobType.class);
        return util.exportExcel(list, "职位类型数据");
    }

    /**
     * 获取职位类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(jobTypeService.selectJobTypeById(id));
    }

    /**
     * 新增职位类型
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobType:add')")
    @Log(title = "职位类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JobType jobType) {
        return toAjax(jobTypeService.insertJobType(jobType));
    }

    /**
     * 修改职位类型
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobType:edit')")
    @Log(title = "职位类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JobType jobType) {
        return toAjax(jobTypeService.updateJobType(jobType));
    }

    /**
     * 删除职位类型
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobType:remove')")
    @Log(title = "职位类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(jobTypeService.deleteJobTypeByIds(ids));
    }
}
