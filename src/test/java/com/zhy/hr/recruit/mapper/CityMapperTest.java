package com.zhy.hr.recruit.mapper;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zhy.hr.recruit.domain.City;
import com.zhy.hr.recruit.domain.JobPost;
import com.zhy.hr.recruit.domain.JobType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhouhongyin
 * @since 2022/3/12 21:15
 */
@SpringBootTest
class CityMapperTest {

    @Resource
    private CityMapper cityMapper;

    @Resource
    private JobTypeMapper jobTypeMapper;

    @Resource
    private JobPostMapper jobPostMapper;

    @Test
    void insertJobType() {

        String result = HttpRequest.get("http://123.57.204.48:3000/api/job-filters")
                .execute().body();

        JSONObject jsonObject = JSONUtil.parseObj(result);
        //System.out.println(jsonObject);

        // 职位类型
        List<JobType> jobTypeList = jsonObject.getJSONArray("job_type_list").toList(JobType.class);

        System.out.println(jobTypeList.size());
        for (JobType jobType : jobTypeList) {
            jobTypeMapper.insertJobType(jobType);
            if (CollectionUtils.isNotEmpty(jobType.getChildren())) {
                for (JobType child : jobType.getChildren()) {
                    JSONObject jsonChild = JSONUtil.parseObj(child.getParent());
                    child.setParent(jsonChild.get("id", String.class));
                    jobTypeMapper.insertJobType(child);
                }
            }
        }

    }

    @Test
    void insertCity() {

        String result = HttpRequest.get("http://123.57.204.48:3000/api/job-filters")
                .execute().body();

        JSONObject jsonObject = JSONUtil.parseObj(result);
        //System.out.println(jsonObject);

        // 职位类型
        List<City> cityList = jsonObject.getJSONArray("city_list").toList(City.class);

        for (City city : cityList) {

            //System.out.println(city.getName());
            cityMapper.insertCity(city);
        }

    }

    @Test
    void insertJobs() throws InterruptedException {

        for (int offset = 0; offset <= 5000; offset+=10) {
            JSONObject pageInfo = JSONUtil.parseObj("{ \"job_category_id_list\": [], \"location_code_list\": [], \"keyword\": \"\", \"offset\": 0 }");
            pageInfo.putOpt("offset", offset);

            String result = HttpRequest.post("http://123.57.204.48:3000/api/jobs").body(pageInfo.toString())
                    .execute().body();

            Thread.sleep((long) (2000 * Math.random()));

            JSONObject jsonObject = JSONUtil.parseObj(result);
            System.out.println("page:" + offset + "jsonObject");
            //System.out.println(jsonObject);

            // 职位类型
            List<JobPost> jobPostList = jsonObject.getJSONArray("job_post_list").toList(JobPost.class);

            for (JobPost jobPost : jobPostList) {
                //jobPost.setJobCategory(JSONUtil.parseObj(jobPost.getJobCategory()).get("id", String.class));
                //jobPost.setCityInfo(JSONUtil.parseObj(jobPost.getCityInfo()).get("code", String.class));
                //jobPostMapper.insertJobPost(jobPost);
            }
        }


    }
}
