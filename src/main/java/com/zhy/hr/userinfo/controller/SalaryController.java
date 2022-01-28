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
import com.zhy.hr.userinfo.domain.Salary;
import com.zhy.hr.userinfo.service.ISalaryService;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.common.core.page.TableDataInfo;

/**
 * 套账Controller
 *
 * @author zhy
 * @date 2022-01-25
 */
@RestController
@RequestMapping("/userinfo/salary")
public class SalaryController extends BaseController {
    @Autowired
    private ISalaryService salaryService;

    /**
     * 查询套账列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:salary:list')")
    @GetMapping("/list")
    public TableDataInfo list(Salary salary) {
        startPage();
        List<Salary> list = salaryService.selectSalaryList(salary);
        return getDataTable(list);
    }

    @GetMapping("/listAll")
    public List<Salary> listAll(Salary salary) {
        return salaryService.selectSalaryList(salary);
    }

    /**
     * 导出套账列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:salary:export')")
    @Log(title = "套账", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Salary salary) {
        List<Salary> list = salaryService.selectSalaryList(salary);
        ExcelUtil<Salary> util = new ExcelUtil<Salary>(Salary.class);
        return util.exportExcel(list, "套账数据");
    }

    /**
     * 获取套账详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:salary:query')")
    @GetMapping(value = "/{salaryId}")
    public AjaxResult getInfo(@PathVariable("salaryId") Long salaryId) {
        return AjaxResult.success(salaryService.selectSalaryBySalaryId(salaryId));
    }

    /**
     * 新增套账
     */
    @PreAuthorize("@ss.hasPermi('userinfo:salary:add')")
    @Log(title = "套账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Salary salary) {
        return toAjax(salaryService.insertSalary(salary));
    }

    /**
     * 修改套账
     */
    @PreAuthorize("@ss.hasPermi('userinfo:salary:edit')")
    @Log(title = "套账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Salary salary) {
        return toAjax(salaryService.updateSalary(salary));
    }

    /**
     * 删除套账
     */
    @PreAuthorize("@ss.hasPermi('userinfo:salary:remove')")
    @Log(title = "套账", businessType = BusinessType.DELETE)
    @DeleteMapping("/{salaryIds}")
    public AjaxResult remove(@PathVariable Long[] salaryIds) {
        return toAjax(salaryService.deleteSalaryBySalaryIds(salaryIds));
    }
}
