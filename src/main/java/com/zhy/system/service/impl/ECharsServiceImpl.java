package com.zhy.system.service.impl;

import com.zhy.system.domain.EChars;
import com.zhy.system.mapper.ECharsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * echars 业务层处理
 *
 * @author zhy
 */
@Service
public class ECharsServiceImpl{
    private static final Logger log = LoggerFactory.getLogger(ECharsServiceImpl.class);

    @Autowired
    private ECharsMapper eCharsMapper;


    /**
     * 获取职位城市工作统计数据
     */
    public List<EChars> getJobCityData() {
        List<EChars> jobCityData = eCharsMapper.getJobCityData();
        EChars other = jobCityData.get(jobCityData.size() - 1);
        int otherValue = other.getValue();
        for (int i = 0; i < jobCityData.size() - 1; i++) {
            otherValue -= jobCityData.get(i).getValue();
        }
        other.setValue(Math.max(otherValue, 0));
        return jobCityData;
    }

    /**
     * 获取职位城市工作统计数据
     * [
     *               { value: 1048, name: 'Search Engine' },
     *               { value: 735, name: 'Direct' },
     *               { value: 580, name: 'Email' },
     *               { value: 484, name: 'Union Ads' },
     *               { value: 300, name: 'Video Ads' }
     *             ]
     */
    public List<EChars> getJobCategoryData() {
        List<EChars> jobCityData = eCharsMapper.getJobCategoryData();
        EChars other = jobCityData.get(jobCityData.size() - 1);
        int otherValue = other.getValue();
        for (int i = 0; i < jobCityData.size() - 1; i++) {
            otherValue -= jobCityData.get(i).getValue();
        }
        other.setValue(Math.max(otherValue, 0));
        return jobCityData;
    }

}
