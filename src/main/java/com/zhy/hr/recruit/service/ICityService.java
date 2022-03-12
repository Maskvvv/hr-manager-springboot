package com.zhy.hr.recruit.service;

import java.util.List;

import com.zhy.hr.recruit.domain.City;

/**
 * 城市Service接口
 *
 * @author zhouhongyin
 * @date 2022-03-12
 */
public interface ICityService {
    /**
     * 查询城市
     *
     * @param code 城市主键
     * @return 城市
     */
    public City selectCityByCode(String code);

    /**
     * 查询城市列表
     *
     * @param city 城市
     * @return 城市集合
     */
    public List<City> selectCityList(City city);

    /**
     * 新增城市
     *
     * @param city 城市
     * @return 结果
     */
    public int insertCity(City city);

    /**
     * 修改城市
     *
     * @param city 城市
     * @return 结果
     */
    public int updateCity(City city);

    /**
     * 批量删除城市
     *
     * @param codes 需要删除的城市主键集合
     * @return 结果
     */
    public int deleteCityByCodes(String[] codes);

    /**
     * 删除城市信息
     *
     * @param code 城市主键
     * @return 结果
     */
    public int deleteCityByCode(String code);
}
