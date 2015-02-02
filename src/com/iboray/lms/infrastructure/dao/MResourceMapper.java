package com.iboray.lms.infrastructure.dao;

import com.iboray.lms.domain.entity.MResource;
import com.iboray.lms.domain.entity.MResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int countByExample(MResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int deleteByExample(MResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int insert(MResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int insertSelective(MResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    List<MResource> selectByExample(MResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    MResource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MResource record, @Param("example") MResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MResource record, @Param("example") MResourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresource
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MResource record);
    
    MResource selectByNo(String no);
}