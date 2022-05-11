package com.zhy.controller.system;

import com.zhy.common.core.controller.BaseController;
import com.zhy.system.domain.EChars;
import com.zhy.system.domain.LineChars;
import com.zhy.system.service.impl.ECharsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * echars
 *
 * @author zhy
 */
@RestController
@RequestMapping("/echars")
public class ECharsController extends BaseController {
    @Autowired
    private ECharsServiceImpl eCharsService;

    /**
     * 获取职位城市工作统计数据
     */
    @GetMapping("/job/city")
    public List<EChars> getJobCityData() {
        return eCharsService.getJobCityData();
    }

    /**
     * 获取职位类别工作统计数据
     */
    @GetMapping("/job/category")
    public List<EChars> getJobCategoryData() {
        return eCharsService.getJobCategoryData();
    }

    /**
     * 获取日活数据
     */
    @GetMapping("/day/active/user")
    public LineChars getDayActiveUserData() {
        return eCharsService.getDayActiveUserData();
    }

    /**
     * 日活、系统用户数、部门数、职位数量
     */
    @GetMapping("/three/data")
    public List<Integer> getThreeData() {
        return eCharsService.getThreeData();
    }
}
