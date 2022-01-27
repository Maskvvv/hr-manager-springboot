package com.zhy.hr.userinfo.mapper;

import java.util.List;

import com.zhy.hr.userinfo.domain.PoliticsStatus;

/**
 * 政治面貌Mapper接口
 *
 * @author zhy
 * @date 2022-01-27
 */
public interface PoliticsStatusMapper {
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
     * 删除政治面貌
     *
     * @param politicsId 政治面貌主键
     * @return 结果
     */
    public int deletePoliticsStatusByPoliticsId(Long politicsId);

    /**
     * 批量删除政治面貌
     *
     * @param politicsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePoliticsStatusByPoliticsIds(Long[] politicsIds);
}
