package com.zhy.system.mapper;

import com.zhy.system.domain.DayActiveUser;
import com.zhy.system.domain.SysOperLog;

import java.util.List;

/**
 * 日活 数据层
 *
 * @author zhy
 */
public interface DayActiveUserMapper {
    /**
     * 新增日活
     */
    void insertDayActiveUser(DayActiveUser dayActiveUser);

}
