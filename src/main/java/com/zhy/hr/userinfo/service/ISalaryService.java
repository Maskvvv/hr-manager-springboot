package com.zhy.hr.userinfo.service;

import java.util.List;

import com.zhy.hr.userinfo.domain.Salary;

/**
 * 套账Service接口
 *
 * @author zhy
 * @date 2022-01-25
 */
public interface ISalaryService {
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
     * 批量删除套账
     *
     * @param salaryIds 需要删除的套账主键集合
     * @return 结果
     */
    public int deleteSalaryBySalaryIds(Long[] salaryIds);

    /**
     * 删除套账信息
     *
     * @param salaryId 套账主键
     * @return 结果
     */
    public int deleteSalaryBySalaryId(Long salaryId);
}
