package com.zhy.hr.userinfo.mapper;

import java.util.List;

import com.zhy.hr.userinfo.domain.UserInfo;

/**
 * 用户详细信息Mapper接口
 *
 * @author zhy
 * @date 2022-01-27
 */
public interface UserInfoMapper {
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
     * 删除用户详细信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 结果
     */
    public int deleteUserInfoByUserInfoId(Long userInfoId);

    /**
     * 批量删除用户详细信息
     *
     * @param userInfoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserInfoByUserInfoIds(Long[] userInfoIds);
}
