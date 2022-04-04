package com.zhy.controller.hr.recruit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONUtil;
import com.zhy.common.annotation.Log;
import com.zhy.common.core.controller.BaseController;
import com.zhy.common.core.domain.AjaxResult;
import com.zhy.common.core.page.TableDataInfo;
import com.zhy.common.enums.BusinessType;
import com.zhy.common.utils.poi.ExcelUtil;
import com.zhy.hr.recruit.domain.ByteStandards;
import com.zhy.hr.recruit.domain.City;
import com.zhy.hr.recruit.domain.JobCategory;
import com.zhy.hr.recruit.domain.JobPost;
import com.zhy.hr.recruit.domain.JobPostParam;
import com.zhy.hr.recruit.domain.JobType;
import com.zhy.hr.recruit.domain.RecruitType;
import com.zhy.hr.recruit.service.ICityService;
import com.zhy.hr.recruit.service.IJobPostService;
import com.zhy.hr.recruit.service.IJobTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 招聘职位Controller
 *
 * @author ruoyi
 * @date 2022-03-12
 */
@RestController
@RequestMapping("/recruit/jobPost")
public class JobPostController extends BaseController {
    @Autowired
    private IJobPostService jobPostService;

    @Autowired
    private IJobTypeService jobTypeService;

    @Autowired
    private ICityService cityService;

    /**
     * 获取去职位列表前台用
     */
    @PostMapping("/jobs")
    public Map<String, Object> Jobslist(@RequestBody JobPostParam jobPostParam) {
        Map<String, Object> map = new HashMap<>();
        JobPost jobPost = new JobPost();
        jobPost.setJobPostParam(jobPostParam);

        startPage();
        List<JobPost> list = jobPostService.selectJobPostList(jobPost);
        TableDataInfo dataTable = getDataTable(list);

        map.put("job_post_list", dataTable.getRows());
        map.put("count", dataTable.getTotal());
        map.put("extra", "{\"fe_tracking\":{\"log_id\":\"202203122225420102112000850136A160\",\"query_length\":0,\"total\":" + dataTable.getTotal() + "}}");
        return map;
    }

    /**
     * 获取职位详情前台用
     */
    @GetMapping(value = "/jobs/{id}")
    public Map<String, Object> jobInfo(@PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<>();
        JobPost jobPost = jobPostService.selectJobPostById(id);
        //jobPost.setRecruit(JSONUtil.toBean(jobPost.getRecruitType(), RecruitType.class));
        map.put("job_post_detail", jobPost);
        return map;
    }

    /**
     * 获取职位详情（前台用）
     */
    @GetMapping(value = "/job-filters")
    public Map<String, Object> jobFilters() {
        Map<String, Object> map = new HashMap<>();
        List<City> cityList = cityService.selectCityList(new City());
        List<JobType> jobTypeList = jobTypeService.selectJobTypeList(new JobType());

        map.put("job_type_list", jobTypeList);
        map.put("city_list", cityList);

        return map;
    }

    /**
     * （前台用）
     */
    @GetMapping(value = "/job-categories")
    public List<JobCategory> jobCategories() {
        String json = "[{\"id\":\"6704215862603155720\",\"en_name\":\"developer\",\"zh_name\":\"研发\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/rd2.png\"},{\"id\":\"6704215864629004552\",\"en_name\":\"productManager\",\"zh_name\":\"产品\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/prod2.png\"},{\"id\":\"6704215882479962371\",\"en_name\":\"operator\",\"zh_name\":\"运营\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/operation2.png\"},{\"id\":\"6709824272514156812\",\"en_name\":\"designer\",\"zh_name\":\"设计\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/design2.png\"},{\"id\":\"6704215901438216462\",\"en_name\":\"marketer\",\"zh_name\":\"市场\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/market2.png\"},{\"id\":\"6709824272505768200\",\"en_name\":\"seller\",\"zh_name\":\"销售\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/sales2.png\"},{\"id\":\"6704215913488451847\",\"en_name\":\"supporter\",\"zh_name\":\"职能支持\",\"image\":\"https://sf1-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/jobslight/support2.png\"},{\"id\":\"\",\"en_name\":\"whole\",\"zh_name\":\"全部\",\"image\":\"//sf3-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/alljobs_2x_crop_min.png\"}]";

        return JSONUtil.parseArray(json).toList(JobCategory.class);
    }

    /**
     * （前台用）
     */
    @GetMapping(value = "/byte-standards")
    public List<ByteStandards> byteStandards() {
        String json = "[{\"title\":\"追求极致\",\"content\":\"不断提高要求，延迟满足感<br>在更大范围里找最优解，不放过问题，思考本质<br>持续学习和成长\",\"image\":\"https://sf3-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/bytestyle1clear.png\"},{\"title\":\"务实敢为\",\"content\":\"直接体验，深入事实<br>不自嗨，注重效果，能突破有担当，打破定式<br>尝试多种可能，快速迭代\",\"image\":\"https://sf3-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/story/tancheng.png\"},{\"title\":\"开放谦逊\",\"content\":\"内心阳光，信任伙伴<br>乐于助人和求助，合作成大事<br>格局大，上个台阶想问题<br>对外敏锐谦虚，ego 小，听得进意见\",\"image\":\"https://sf3-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/style03_1576395987141.png\"},{\"title\":\"坦诚清晰\",\"content\":\"敢当面表达真实想法<br>能承认错误，不装不爱面子<br>实事求是，暴露问题，反对“向上管理”<br>准确、简洁、直接，有条理有重点\",\"image\":\"https://sf3-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/story/tancheng.png\"},{\"title\":\"始终创业\",\"content\":\"自驱，不设边界，不怕麻烦<br>有韧性，直面现实并改变它<br>拥抱变化，对不确定性保持乐观<br>始终像公司创业第一天那样思考\",\"image\":\"https://sf3-ttcdn-tos.pstatp.com/obj/ttfe/ATSX/mainland/bytestyle5clear.png\"},{\"title\":\"多元兼容\",\"content\":\"理解并重视差异和多元，建立火星视角<br>打造多元化的团队，欢迎不同背景的人才，激发潜力<br>鼓励人人参与，集思广益，主动用不同的想法来挑战自己<br>创造海纳百川，兼容友好的工作环境\",\"image\":\"https://sf3-ttcdn-tos.pstatp.com/obj/atsx-fe/p/assets/duoyuanjianrong_1584512668065.jpg\"}]";

        return JSONUtil.parseArray(json).toList(ByteStandards.class);
    }

    /**
     * 查询招聘职位列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:list')")
    @GetMapping("/list")
    public TableDataInfo list(JobPost jobPost) {
        startPage();
        List<JobPost> list = jobPostService.selectJobPostList(jobPost);
        return getDataTable(list);
    }

    /**
     * 导出招聘职位列表
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:export')")
    @Log(title = "招聘职位", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(JobPost jobPost) {
        List<JobPost> list = jobPostService.selectJobPostList(jobPost);
        ExcelUtil<JobPost> util = new ExcelUtil<JobPost>(JobPost.class);
        return util.exportExcel(list, "招聘职位数据");
    }

    /**
     * 获取招聘职位详细信息
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id) {
        return AjaxResult.success(jobPostService.selectJobPostById(id));
    }

    /**
     * 新增招聘职位
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:add')")
    @Log(title = "招聘职位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody JobPost jobPost) {
        return toAjax(jobPostService.insertJobPost(jobPost));
    }

    /**
     * 修改招聘职位
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:edit')")
    @Log(title = "招聘职位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody JobPost jobPost) {
        return toAjax(jobPostService.updateJobPost(jobPost));
    }

    /**
     * 删除招聘职位
     */
    @PreAuthorize("@ss.hasPermi('recruit:jobPost:remove')")
    @Log(title = "招聘职位", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids) {
        return toAjax(jobPostService.deleteJobPostByIds(ids));
    }
}
