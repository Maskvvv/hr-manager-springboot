package com.zhy.hr.userinfo.mapper;

import java.util.List;

import com.zhy.hr.userinfo.domain.Salary;

/**
 * 套账Mapper接口
 *
 * @author zhy
 * @date 2022-01-25
 */
public interface SalaryMapper {
    /**
     * 查询套账
     *
     * @param salaryId 套账主键
     * @return 套账
     */
    public Salary selectSalaryBySalaryId(Long salaryId);

    /**
     * 查询套账列表
     *
     * @param salary 套账
     * @return 套账集合
     */
    public List<Salary> selectSalaryList(Salary salary);

    /**
     * 新增套账
     *
     * @param salary 套账
     * @return 结果
     */
    public int insertSalary(Salary salary);

    /**
     * 修改套账
     *
     * @param salary 套账
     * @return 结果
     */
    public int updateSalary(Salary salary);

    /**
     * 删除套账
     *
     * @param salaryId 套账主键
     * @return 结果
     */
    public int deleteSalaryBySalaryId(Long salaryId);

    /**
     * 批量删除套账
     *
     * @param salaryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSalaryBySalaryIds(Long[] salaryIds);
}
