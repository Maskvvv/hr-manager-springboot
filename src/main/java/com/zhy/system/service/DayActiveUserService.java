package com.zhy.system.service;

import cn.hutool.core.util.IdUtil;
import com.zhy.common.core.domain.model.LoginUser;
import com.zhy.system.domain.DayActiveUser;
import com.zhy.system.mapper.DayActiveUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日活 业务层处理
 *
 * @author zhy
 */
public interface DayActiveUserService {
    /**
     * 添加日活记录
     */
    void insertDayActiveUser(LoginUser loginUser);
}
