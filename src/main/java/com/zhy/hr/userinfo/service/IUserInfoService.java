package com.zhy.hr.userinfo.service;

import java.io.IOException;
import java.util.List;

import com.zhy.common.core.domain.AjaxResult;
import com.zhy.hr.userinfo.domain.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 用户详细信息Service接口
 *
 * @author zhy
 * @date 2022-01-27
 */
public interface IUserInfoService {
    /**
     * 查询用户详细信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 用户详细信息
     */
    public UserInfo selectUserInfoByUserInfoId(Long userInfoId);

    /**
     * 查询用户详细信息列表
     *
     * @param userInfo 用户详细信息
     * @return 用户详细信息集合
     */
    public List<UserInfo> selectUserInfoList(UserInfo userInfo);

    /**
     * 新增用户详细信息
     *
     * @param userInfo 用户详细信息
     * @return 结果
     */
    public int insertUserInfo(UserInfo userInfo);

    /**
     * 修改用户详细信息
     *
     * @param userInfo 用户详细信息
     * @return 结果
     */
    public int updateUserInfo(UserInfo userInfo);

    /**
     * 批量删除用户详细信息
     *
     * @param userInfoIds 需要删除的用户详细信息主键集合
     * @return 结果
     */
    public int deleteUserInfoByUserInfoIds(Long[] userInfoIds);

    /**
     * 删除用户详细信息信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 结果
     */
    public int deleteUserInfoByUserInfoId(Long userInfoId);

    /**
     * 根据用户id删除用户信息
     * @param userIds
     * @return
     */
    public int deleteUserInfoByUserIds(Long[] userIds);

    /**
     * 导入模板
     */
    AjaxResult importTemplate() throws IOException;

    /**
     * 导入数据
     */
    String importData(MultipartFile file) throws IOException;
}
