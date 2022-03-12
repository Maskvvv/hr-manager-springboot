package com.zhy.hr.recruit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.recruit.mapper.CityMapper;
import com.zhy.hr.recruit.domain.City;
import com.zhy.hr.recruit.service.ICityService;

/**
 * 城市Service业务层处理
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
@Service
public class CityServiceImpl implements ICityService {
    @Autowired
    private CityMapper cityMapper;

    /**
     * 查询城市
     *
     * @param code 城市主键
     * @return 城市
     */
    @Override
    public City selectCityByCode(String code) {
        return cityMapper.selectCityByCode(code);
    }

    /**
     * 查询城市列表
     *
     * @param city 城市
     * @return 城市
     */
    @Override
    public List<City> selectCityList(City city) {
        return cityMapper.selectCityList(city);
    }

    /**
     * 新增城市
     *
     * @param city 城市
     * @return 结果
     */
    @Override
    public int insertCity(City city) {
        return cityMapper.insertCity(city);
    }

    /**
     * 修改城市
     *
     * @param city 城市
     * @return 结果
     */
    @Override
    public int updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    /**
     * 批量删除城市
     *
     * @param codes 需要删除的城市主键
     * @return 结果
     */
    @Override
    public int deleteCityByCodes(String[] codes) {
        return cityMapper.deleteCityByCodes(codes);
    }

    /**
     * 删除城市信息
     *
     * @param code 城市主键
     * @return 结果
     */
    @Override
    public int deleteCityByCode(String code) {
        return cityMapper.deleteCityByCode(code);
    }
}
