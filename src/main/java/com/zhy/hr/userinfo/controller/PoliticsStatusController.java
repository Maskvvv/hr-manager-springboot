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
import com.zhy.hr.userinfo.domain.PoliticsStatus;
import com.zhy.hr.userinfo.service.IPoliticsStatusService;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.common.core.page.TableDataInfo;

/**
 * 政治面貌Controller
 *
 * @author zhy
 * @date 2022-01-27
 */
@RestController
@RequestMapping("/userinfo/politics")
public class PoliticsStatusController extends BaseController {
    @Autowired
    private IPoliticsStatusService politicsStatusService;

    /**
     * 查询政治面貌列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:politics:list')")
    @GetMapping("/list")
    public TableDataInfo list(PoliticsStatus politicsStatus) {
        startPage();
        List<PoliticsStatus> list = politicsStatusService.selectPoliticsStatusList(politicsStatus);
        return getDataTable(list);
    }

    /**
     * 导出政治面貌列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:politics:export')")
    @Log(title = "政治面貌", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PoliticsStatus politicsStatus) {
        List<PoliticsStatus> list = politicsStatusService.selectPoliticsStatusList(politicsStatus);
        ExcelUtil<PoliticsStatus> util = new ExcelUtil<PoliticsStatus>(PoliticsStatus.class);
        return util.exportExcel(list, "政治面貌数据");
    }

    /**
     * 获取政治面貌详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:politics:query')")
    @GetMapping(value = "/{politicsId}")
    public AjaxResult getInfo(@PathVariable("politicsId") Long politicsId) {
        return AjaxResult.success(politicsStatusService.selectPoliticsStatusByPoliticsId(politicsId));
    }

    /**
     * 新增政治面貌
     */
    @PreAuthorize("@ss.hasPermi('userinfo:politics:add')")
    @Log(title = "政治面貌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PoliticsStatus politicsStatus) {
        return toAjax(politicsStatusService.insertPoliticsStatus(politicsStatus));
    }

    /**
     * 修改政治面貌
     */
    @PreAuthorize("@ss.hasPermi('userinfo:politics:edit')")
    @Log(title = "政治面貌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PoliticsStatus politicsStatus) {
        return toAjax(politicsStatusService.updatePoliticsStatus(politicsStatus));
    }

    /**
     * 删除政治面貌
     */
    @PreAuthorize("@ss.hasPermi('userinfo:politics:remove')")
    @Log(title = "政治面貌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{politicsIds}")
    public AjaxResult remove(@PathVariable Long[] politicsIds) {
        return toAjax(politicsStatusService.deletePoliticsStatusByPoliticsIds(politicsIds));
    }
}
