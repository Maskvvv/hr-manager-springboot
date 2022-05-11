package com.zhy.system.service.impl;

import com.zhy.hr.recruit.domain.JobPost;
import com.zhy.hr.recruit.mapper.JobPostMapper;
import com.zhy.system.domain.EChars;
import com.zhy.system.domain.LineChars;
import com.zhy.system.mapper.ECharsMapper;
import com.zhy.system.mapper.SysDeptMapper;
import com.zhy.system.mapper.SysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private JobPostMapper jobPostMapper;


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

    /**
     * 获取日活数据
     */
    public LineChars getDayActiveUserData() {
        List<EChars> dayActiveUserData = eCharsMapper.getDayActiveUserData();

        LineChars lineChars = new LineChars();
        lineChars.setXAxis(new ArrayList<>());
        lineChars.setYAxis(new ArrayList<>());

        for (EChars dayActiveUserDatum : dayActiveUserData) {
            switch (dayActiveUserDatum.getName()) {
                case "1" : lineChars.getXAxis().add("周一" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue()); break;
                case "2" : lineChars.getXAxis().add("周二" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue()); break;
                case "3" : lineChars.getXAxis().add("周三" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue()); break;
                case "4" : lineChars.getXAxis().add("周四" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue()); break;
                case "5" : lineChars.getXAxis().add("周五" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue()); break;
                case "6" : lineChars.getXAxis().add("周六" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue()); break;
                default: lineChars.getXAxis().add("周日" ); lineChars.getYAxis().add(dayActiveUserDatum.getValue());
            }
        }

        return lineChars;

    }

    /**
     * 今日日活、系统用户数、部门数、职位数量
     */
    public List<Integer> getThreeData() {
        List<Integer> dataList = new ArrayList<>(4);
        dataList.add(eCharsMapper.countTodayActiveUser());
        dataList.add(sysUserMapper.countUser());
        dataList.add(sysDeptMapper.countDept());
        dataList.add(jobPostMapper.countJobPost());
        return dataList;
    }


}
