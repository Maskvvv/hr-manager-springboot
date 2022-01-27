package com.zhy.hr.userinfo.service;

import java.util.List;

import com.zhy.hr.userinfo.domain.PoliticsStatus;

/**
 * 政治面貌Service接口
 *
 * @author zhy
 * @date 2022-01-27
 */
public interface IPoliticsStatusService {
    /**
     * 查询政治面貌
     *
     * @param politicsId 政治面貌主键
     * @return 政治面貌
     */
    public PoliticsStatus selectPoliticsStatusByPoliticsId(Long politicsId);

    /**
     * 查询政治面貌列表
     *
     * @param politicsStatus 政治面貌
     * @return 政治面貌集合
     */
    public List<PoliticsStatus> selectPoliticsStatusList(PoliticsStatus politicsStatus);

    /**
     * 新增政治面貌
     *
     * @param politicsStatus 政治面貌
     * @return 结果
     */
    public int insertPoliticsStatus(PoliticsStatus politicsStatus);

    /**
     * 修改政治面貌
     *
     * @param politicsStatus 政治面貌
     * @return 结果
     */
    public int updatePoliticsStatus(PoliticsStatus politicsStatus);

    /**
     * 批量删除政治面貌
     *
     * @param politicsIds 需要删除的政治面貌主键集合
     * @return 结果
     */
    public int deletePoliticsStatusByPoliticsIds(Long[] politicsIds);

    /**
     * 删除政治面貌信息
     *
     * @param politicsId 政治面貌主键
     * @return 结果
     */
    public int deletePoliticsStatusByPoliticsId(Long politicsId);
}
