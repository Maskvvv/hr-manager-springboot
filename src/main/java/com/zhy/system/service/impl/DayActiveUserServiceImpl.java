package com.zhy.system.service.impl;

import cn.hutool.core.util.IdUtil;
import com.zhy.common.core.domain.model.LoginUser;
import com.zhy.system.domain.DayActiveUser;
import com.zhy.system.mapper.DayActiveUserMapper;
import com.zhy.system.service.DayActiveUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日活 业务层处理
 *
 * @author zhy
 */
@Service
public class DayActiveUserServiceImpl implements DayActiveUserService {
    private static final Logger log = LoggerFactory.getLogger(DayActiveUserServiceImpl.class);

    @Autowired
    private DayActiveUserMapper dayActiveUserMapper;


    /**
     * 添加日活记录
     */
    @Override
    public void insertDayActiveUser(LoginUser loginUser) {
        DayActiveUser dayActiveUser = new DayActiveUser();
        dayActiveUser.setId(IdUtil.simpleUUID());
        if (loginUser != null) {
            dayActiveUser.setUserId(loginUser.getUserId());
        }
        dayActiveUser.setCreatTime(System.currentTimeMillis());
        dayActiveUserMapper.insertDayActiveUser(dayActiveUser);
    }
}
