package com.iboray.lms.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboray.lms.domain.entity.Plan;
import com.iboray.lms.domain.entity.PlanExample;
import com.iboray.lms.domain.entity.PlanProcurementSource;
import com.iboray.lms.domain.entity.PlanProcurementSourceExample;

public interface PlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int countByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int deleteByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int insert(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int insertSelective(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    List<Plan> selectByExample(PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    Plan selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Plan record, @Param("example") PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Plan record, @Param("example") PlanExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Plan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_plan
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Plan record);
    
    Plan selectByNo(String planNo);
    
    List<PlanProcurementSource> selectPlanProcurementSourceByExample(PlanProcurementSourceExample example);
    
    int countByPlanProcurementSourceExample(PlanProcurementSourceExample example);
    
}