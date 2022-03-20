package com.zhy.controller.hr.recruit;

import java.util.List;

import com.zhy.common.annotation.Log;
import com.zhy.common.core.controller.BaseController;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.page.TableDataInfo;
import com.zhy.common.enums.BusinessType;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.hr.recruit.domain.City;
import com.zhy.hr.recruit.service.ICityService;
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
 * 城市Controller
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
@RestController
@RequestMapping("/recruit/city")
public class CityController extends BaseController {
    @Autowired
    private ICityService cityService;

    /**
     * 查询城市列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:city:list')")
    @GetMapping("/list")
    public TableDataInfo list(City city) {
        startPage();
        List<City> list = cityService.selectCityList(city);
        return getDataTable(list);
    }

    /**
     * 导出城市列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:city:export')")
    @Log(title = "城市", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(City city) {
        List<City> list = cityService.selectCityList(city);
        ExcelUtil<City> util = new ExcelUtil<City>(City.class);
        return util.exportExcel(list, "城市数据");
    }

    /**
     * 获取城市详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:city:query')")
    @GetMapping(value = "/{code}")
    public AjaxResult getInfo(@PathVariable("code") String code) {
        return AjaxResult.success(cityService.selectCityByCode(code));
    }

    /**
     * 新增城市
     */
    @PreAuthorize("@ss.hasPermi('recruit:city:add')")
    @Log(title = "城市", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody City city) {
        return toAjax(cityService.insertCity(city));
    }

    /**
     * 修改城市
     */
    @PreAuthorize("@ss.hasPermi('recruit:city:edit')")
    @Log(title = "城市", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody City city) {
        return toAjax(cityService.updateCity(city));
    }

    /**
     * 删除城市
     */
    @PreAuthorize("@ss.hasPermi('recruit:city:remove')")
    @Log(title = "城市", businessType = BusinessType.DELETE)
    @DeleteMapping("/{codes}")
    public AjaxResult remove(@PathVariable String[] codes) {
        return toAjax(cityService.deleteCityByCodes(codes));
    }
}
