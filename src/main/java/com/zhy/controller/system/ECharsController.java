package com.zhy.controller.system;

import com.zhy.common.core.controller.BaseController;
import com.zhy.system.domain.EChars;
import com.zhy.system.service.impl.ECharsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息
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

}
