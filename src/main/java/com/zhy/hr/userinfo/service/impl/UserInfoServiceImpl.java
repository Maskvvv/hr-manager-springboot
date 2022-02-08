package com.zhy.hr.userinfo.service.impl;
import com.zhy.framework.rabbitmq.config.RabbitMQConfig;
import com.zhy.hr.userinfo.domain.PoliticsStatus;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.zhy.common.config.RuoYiConfig;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.domain.entity.SysDept;
import com.zhy.common.core.domain.entity.SysUser;
import com.zhy.common.utils.SecurityUtils;
import com.zhy.hr.userinfo.domain.JobLevel;
import com.zhy.hr.userinfo.domain.Nation;
import com.zhy.hr.userinfo.domain.Salary;
import com.zhy.hr.userinfo.mapper.JobLevelMapper;
import com.zhy.hr.userinfo.mapper.NationMapper;
import com.zhy.hr.userinfo.mapper.PoliticsStatusMapper;
import com.zhy.hr.userinfo.mapper.SalaryMapper;
import com.zhy.system.mapper.SysDeptMapper;
import com.zhy.system.mapper.SysUserMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhy.hr.userinfo.mapper.UserInfoMapper;
import com.zhy.hr.userinfo.domain.UserInfo;
import com.zhy.hr.userinfo.service.IUserInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 用户详细信息Service业务层处理
 *
 * @author zhy
 * @date 2022-01-27
 */
@Service
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SalaryMapper salaryMapper;

    @Autowired
    private SysDeptMapper sysDeptMapper;

    @Autowired
    private JobLevelMapper jobLevelMapper;

    @Autowired
    private NationMapper nationMapper;

    @Autowired
    private PoliticsStatusMapper politicsStatusMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 查询用户详细信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 用户详细信息
     */
    @Override
    public UserInfo selectUserInfoByUserInfoId(Long userInfoId) {
        return userInfoMapper.selectUserInfoByUserInfoId(userInfoId);
    }

    /**
     * 查询用户详细信息列表
     *
     * @param userInfo 用户详细信息
     * @return 用户详细信息
     */
    @Override
    public List<UserInfo> selectUserInfoList(UserInfo userInfo) {
        return userInfoMapper.selectUserInfoList(userInfo);
    }

    /**
     * 新增用户详细信息
     *
     * @param userInfo 用户详细信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertUserInfo(UserInfo userInfo) {

        // 创建账号
        SysUser sysUser = userInfo.getSysUser();
        sysUser.setPassword(SecurityUtils.encryptPassword("123456"));
        sysUser.setNickName(userInfo.getUserInfoName());
        sysUser.setCreateBy(SecurityUtils.getUsername());
        sysUser.setCreateTime(new Date());
        sysUser.setUserName(generateUsername(userInfo));
        sysUser.setRoleIds(new Long[]{2L});
        sysUserMapper.insertUser(sysUser);

        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, RabbitMQConfig.SENDMAIL_CREAT_USERINFO_KEY, sysUser.getUserId());

        // 创建用户信息
        userInfo.setUserId(sysUser.getUserId());
        return userInfoMapper.insertUserInfo(userInfo);
    }

    /**
     * 修改用户详细信息
     *
     * @param userInfo 用户详细信息
     * @return 结果
     */
    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userInfoMapper.updateUserInfo(userInfo);
    }

    /**
     * 批量删除用户详细信息
     *
     * @param userInfoIds 需要删除的用户详细信息主键
     * @return 结果
     */
    @Override
    public int deleteUserInfoByUserInfoIds(Long[] userInfoIds) {
        return userInfoMapper.deleteUserInfoByUserInfoIds(userInfoIds);
    }

    /**
     * 删除用户详细信息信息
     *
     * @param userInfoId 用户详细信息主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteUserInfoByUserInfoId(Long userInfoId) {
        UserInfo userInfo = userInfoMapper.selectUserInfoByUserInfoId(userInfoId);
        sysUserMapper.deleteUserById(userInfo.getUserId());
        return userInfoMapper.deleteUserInfoByUserInfoId(userInfoId);
    }

    /**
     * 用户名生成逻辑
     */
    private String generateUsername(UserInfo userInfo) {
        String username = PinyinUtil.getPinyin(userInfo.getUserInfoName(), "");
        List<String> usernameList = sysUserMapper.selectUserList(SysUser.builder().userName(username).build()).stream().map(SysUser::getUserName).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(usernameList)) {
            String preUsername = usernameList.get(usernameList.size() - 1);
            String[] usernameSuffix = preUsername.split(username);
            if (usernameSuffix.length > 1) {
                username = username + (Integer.parseInt(usernameSuffix[1]) + 1);
            } else {
                username = username + 1;
            }
        }
        return username;
    }

    /**
     * 生成导入模板
     * // TODO: 2022/2/7 用户信息导入
     */
    @Override
    public AjaxResult importTemplate() throws IOException {
        String fileName = "writeTest.xlsx";
        String filePath = RuoYiConfig.getDownloadPath() + fileName;

        File file = new File(filePath);
        if (file.isFile() && file.exists()) {
            FileUtil.del(file);
        }

        List<String> row1 = CollUtil.newArrayList("员工姓名", "出生日期", "用户性别", "手机号码", "邮箱", "身份证号",
                "婚姻状况", "民族", "套账", "所属部门", "籍贯", "政治面貌", "联系地址", "职称", "聘用形式", "最高学历", "所属专业", "毕业院校",
                "入职日期", "在职状态", "转正日期", "合同起始日期", "合同终止日期");

        ExcelWriter writer = ExcelUtil.getWriter(filePath);

        writer.writeHeadRow(row1);

        //关闭writer，释放内存
        writer.close();

        return AjaxResult.success(fileName);

    }

    /**
     * 导入数据
     */
    @Override
    public String importData(MultipartFile file) throws IOException {

        // TODO: 2022/1/28 导入excel
        // 获取excel
        ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
        List<Map<String,Object>> userinfoList = reader.readAll();

        // 查询salary
        List<Salary> salaryList = salaryMapper.selectSalaryList(null);
        List<SysDept> sysDeptList = sysDeptMapper.selectDeptList(null);
        List<JobLevel> jobLevelList = jobLevelMapper.selectJobLevelList(null);
        List<Nation> nationList = nationMapper.selectNationList(null);
        List<PoliticsStatus> politicsStatusList = politicsStatusMapper.selectPoliticsStatusList(null);

        List<String> titleList = CollUtil.newArrayList("员工姓名", "出生日期", "用户性别", "手机号码", "邮箱", "身份证号",
                "婚姻状况", "民族", "套账", "所属部门", "籍贯", "政治面貌", "联系地址", "职称", "聘用形式", "最高学历", "所属专业", "毕业院校",
                "入职日期", "在职状态", "转正日期", "合同起始日期", "合同终止日期");

        for (Map<String, Object> userinfoMap : userinfoList) {
            UserInfo userInfo = new UserInfo();
            SysUser sysUser = new SysUser();
            userInfo.setSysUser(sysUser);

            userInfo.setUserInfoName((String) userinfoMap.get(titleList.get(0)));
            userInfo.setBirthday((Date) userinfoMap.get(titleList.get(1)));

            String sex = (String) userinfoMap.get(titleList.get(2));
            userInfo.getSysUser().setSex( "男".equals(sex) ? "0" : "女".equals(sex) ? "1" : "2");

            userInfo.getSysUser().setPhonenumber((String) userinfoMap.get(titleList.get(3)));
            userInfo.getSysUser().setEmail((String) userinfoMap.get(titleList.get(4)));
            userInfo.setIdCard((String) userinfoMap.get(titleList.get(5)));
            userInfo.setMaritalStatus("0");

            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(7)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(8)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(9)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(10)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(11)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(12)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(13)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(14)));
            userInfo.getSysUser().setSex((String) userinfoMap.get(titleList.get(15)));

        }

        return "success";

    }
}
