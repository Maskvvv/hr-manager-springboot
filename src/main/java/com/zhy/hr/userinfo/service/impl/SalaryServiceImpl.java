package com.zhy.hr.userinfo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.userinfo.mapper.SalaryMapper;
import com.zhy.hr.userinfo.domain.Salary;
import com.zhy.hr.userinfo.service.ISalaryService;

/**
 * 套账Service业务层处理
 *
 * @author zhy
 * @date 2022-01-25
 */
@Service
public class SalaryServiceImpl implements ISalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    /**
     * 查询套账
     *
     * @param salaryId 套账主键
     * @return 套账
     */
    @Override
    public Salary selectSalaryBySalaryId(Long salaryId) {
        return salaryMapper.selectSalaryBySalaryId(salaryId);
    }

    /**
     * 查询套账列表
     *
     * @param salary 套账
     * @return 套账
     */
    @Override
    public List<Salary> selectSalaryList(Salary salary) {
        return salaryMapper.selectSalaryList(salary);
    }

    /**
     * 新增套账
     *
     * @param salary 套账
     * @return 结果
     */
    @Override
    public int insertSalary(Salary salary) {
        salary.setCreateDate(new Date());
        return salaryMapper.insertSalary(salary);
    }

    /**
     * 修改套账
     *
     * @param salary 套账
     * @return 结果
     */
    @Override
    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }

    /**
     * 批量删除套账
     *
     * @param salaryIds 需要删除的套账主键
     * @return 结果
     */
    @Override
    public int deleteSalaryBySalaryIds(Long[] salaryIds) {
        return salaryMapper.deleteSalaryBySalaryIds(salaryIds);
    }

    /**
     * 删除套账信息
     *
     * @param salaryId 套账主键
     * @return 结果
     */
    @Override
    public int deleteSalaryBySalaryId(Long salaryId) {
        return salaryMapper.deleteSalaryBySalaryId(salaryId);
    }
}
