package com.zhy.controller.hr.recruit;

import java.util.List;

import com.zhy.common.annotation.Log;
import com.zhy.common.core.controller.BaseController;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.page.TableDataInfo;
import com.zhy.common.enums.BusinessType;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.hr.recruit.domain.JobPost;
import com.zhy.hr.recruit.service.IJobPostService;
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
 * 招聘职位Controller
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@RestController
@RequestMapping("/recruit/jobPost")
public class JobPostController extends BaseController
{
    @Autowired
    private IJobPostService jobPostService;

    /**
     * 查询招聘职位列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:list')")
    @GetMapping("/list")
    public TableDataInfo list(JobPost jobPost)
    {
        startPage();
        List<JobPost> list = jobPostService.selectJobPostList(jobPost);
        return getDataTable(list);
    }

    /**
     * 导出招聘职位列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:export')")
    @Log(title = "招聘职位", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JobPost jobPost)
    {
        List<JobPost> list = jobPostService.selectJobPostList(jobPost);
        ExcelUtil<JobPost> util = new ExcelUtil<JobPost>(JobPost.class);
        return util.exportExcel(list, "招聘职位数据");
    }

    /**
     * 获取招聘职位详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return AjaxResult.success(jobPostService.selectJobPostById(id));
    }

    /**
     * 新增招聘职位
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:add')")
    @Log(title = "招聘职位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JobPost jobPost)
    {
        return toAjax(jobPostService.insertJobPost(jobPost));
    }

    /**
     * 修改招聘职位
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:edit')")
    @Log(title = "招聘职位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JobPost jobPost)
    {
        return toAjax(jobPostService.updateJobPost(jobPost));
    }

    /**
     * 删除招聘职位
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:remove')")
    @Log(title = "招聘职位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(jobPostService.deleteJobPostByIds(ids));
    }
}
