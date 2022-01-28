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
import com.zhy.hr.userinfo.domain.Nation;
import com.zhy.hr.userinfo.service.INationService;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.common.core.page.TableDataInfo;

/**
 * 民族Controller
 *
 * @author zhy
 * @date 2022-01-25
 */
@RestController
@RequestMapping("/userinfo/nation")
public class NationController extends BaseController {
    @Autowired
    private INationService nationService;

    /**
     * 查询民族列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:nation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Nation nation) {
        startPage();
        List<Nation> list = nationService.selectNationList(nation);
        return getDataTable(list);
    }

    @GetMapping("/listAll")
    public List<Nation> listAll(Nation nation) {
        return nationService.selectNationList(nation);
    }

    /**
     * 导出民族列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:nation:export')")
    @Log(title = "民族", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Nation nation) {
        List<Nation> list = nationService.selectNationList(nation);
        ExcelUtil<Nation> util = new ExcelUtil<Nation>(Nation.class);
        return util.exportExcel(list, "民族数据");
    }

    /**
     * 获取民族详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:nation:query')")
    @GetMapping(value = "/{nationId}")
    public AjaxResult getInfo(@PathVariable("nationId") Long nationId) {
        return AjaxResult.success(nationService.selectNationByNationId(nationId));
    }

    /**
     * 新增民族
     */
    @PreAuthorize("@ss.hasPermi('userinfo:nation:add')")
    @Log(title = "民族", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Nation nation) {
        return toAjax(nationService.insertNation(nation));
    }

    /**
     * 修改民族
     */
    @PreAuthorize("@ss.hasPermi('userinfo:nation:edit')")
    @Log(title = "民族", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Nation nation) {
        return toAjax(nationService.updateNation(nation));
    }

    /**
     * 删除民族
     */
    @PreAuthorize("@ss.hasPermi('userinfo:nation:remove')")
    @Log(title = "民族", businessType = BusinessType.DELETE)
    @DeleteMapping("/{nationIds}")
    public AjaxResult remove(@PathVariable Long[] nationIds) {
        return toAjax(nationService.deleteNationByNationIds(nationIds));
    }
}
