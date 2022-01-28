package com.zhy.hr.userinfo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import cn.hutool.extra.pinyin.PinyinUtil;
import com.zhy.common.core.domain.entity.SysUser;
import com.zhy.common.utils.SecurityUtils;
import com.zhy.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.userinfo.mapper.UserInfoMapper;
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.IUserInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

/**
 * 用户详细信息Service业务层处理
 *
 * @author zhy
 * @date 2022-01-27
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户详细信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 用户详细信息
     */
    @Override
    public UserInfo selectUserInfoByUserInfoId(Long userInfoId) {
        return userInfoMapper.selectUserInfoByUserInfoId(userInfoId);
    }

    /**
     * 查询用户详细信息列表
     *
     * @param userInfo 用户详细信息
     * @return 用户详细信息
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增用户详细信息
     *
     * @param userInfo 用户详细信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUserInfo(UserInfo userInfo) {

        // 创建账号
        SysUser sysUser = userInfo.getSysUser();
        sysUser.setPassword(SecurityUtils.encryptPassword("123456"));
        sysUser.setNickName(userInfo.getUserInfoName());
        sysUser.setCreateBy(SecurityUtils.getUsername());
        sysUser.setCreateTime(new Date());
        sysUser.setUserName(generateUsername(userInfo));
        sysUser.setRoleIds(new Long[]{2L});
        sysUserMapper.insertUser(sysUser);

        userInfo.setUserId(sysUser.getUserId());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改用户详细信息
     *
     * @param userInfo 用户详细信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除用户详细信息
     *
     * @param userInfoIds 需要删除的用户详细信息主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByUserInfoIds(Long[] userInfoIds) {
        return userInfoMapper.deleteUserInfoByUserInfoIds(userInfoIds);
    }

    /**
     * 删除用户详细信息信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUserInfoByUserInfoId(Long userInfoId) {
        UserInfo userInfo = userInfoMapper.selectUserInfoByUserInfoId(userInfoId);
        sysUserMapper.deleteUserById(userInfo.getUserId());
        return userInfoMapper.deleteUserInfoByUserInfoId(userInfoId);
    }

    /**
     * 用户名生成逻辑
     */
    private String generateUsername(UserInfo userInfo) {
        String username = PinyinUtil.getPinyin(userInfo.getUserInfoName(), "");
        List<String> usernameList = sysUserMapper.selectUserList(SysUser.builder().userName(username).build()).stream().map(SysUser::getUserName).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(usernameList)) {
            String preUsername = usernameList.get(usernameList.size() - 1);
            String[] usernameSuffix = preUsername.split(username);
            if (usernameSuffix.length > 1) {
                username = username + (Integer.parseInt(usernameSuffix[1]) + 1);
            } else {
                username = username + 1;
            }
        }
        return username;
    }
}
