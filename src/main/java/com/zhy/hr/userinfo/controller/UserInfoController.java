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
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.IUserInfoService;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.common.core.page.TableDataInfo;

/**
 * 用户详细信息Controller
 *
 * @author zhy
 * @date 2022-01-27
 */
@RestController
@RequestMapping("/userinfo/uinfo")
public class UserInfoController extends BaseController {
    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 查询用户详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:uinfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserInfo userInfo) {
        startPage();
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        return getDataTable(list);
    }

    /**
     * 导出用户详细信息列表
     */
    @PreAuthorize("@ss.hasPermi('userinfo:uinfo:export')")
    @Log(title = "用户详细信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(UserInfo userInfo) {
        List<UserInfo> list = userInfoService.selectUserInfoList(userInfo);
        ExcelUtil<UserInfo> util = new ExcelUtil<UserInfo>(UserInfo.class);
        return util.exportExcel(list, "用户详细信息数据");
    }

    /**
     * 获取用户详细信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:uinfo:query')")
    @GetMapping(value = "/{userInfoId}")
    public AjaxResult getInfo(@PathVariable("userInfoId") Long userInfoId) {
        return AjaxResult.success(userInfoService.selectUserInfoByUserInfoId(userInfoId));
    }

    /**
     * 新增用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:uinfo:add')")
    @Log(title = "用户详细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserInfo userInfo) {
        return toAjax(userInfoService.insertUserInfo(userInfo));
    }

    /**
     * 修改用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:uinfo:edit')")
    @Log(title = "用户详细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserInfo userInfo) {
        return toAjax(userInfoService.updateUserInfo(userInfo));
    }

    /**
     * 删除用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('userinfo:uinfo:remove')")
    @Log(title = "用户详细信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userInfoIds}")
    public AjaxResult remove(@PathVariable Long[] userInfoIds) {
        return toAjax(userInfoService.deleteUserInfoByUserInfoIds(userInfoIds));
    }
}
