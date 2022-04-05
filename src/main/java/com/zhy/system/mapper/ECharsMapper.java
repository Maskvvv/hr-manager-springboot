package com.zhy.system.mapper;

import com.zhy.system.domain.EChars;

import java.util.List;

/**
 *
 *
 * @author zhy
 */
public interface ECharsMapper {
    /**
     * 获取职位城市工作统计数据
     */
    List<EChars> getJobCityData();

    /**
     * 获取职位城市工作统计数据
     */
    List<EChars> getJobCategoryData();

    /**
     * 获取日活数据
     */
    List<EChars> getDayActiveUserData();

}
