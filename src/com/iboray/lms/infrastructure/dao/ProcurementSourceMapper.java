package com.iboray.lms.infrastructure.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iboray.lms.domain.entity.ProcurementSource;
import com.iboray.lms.domain.entity.ProcurementSourceExample;

public interface ProcurementSourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int countByExample(ProcurementSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int deleteByExample(ProcurementSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int insert(ProcurementSource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int insertSelective(ProcurementSource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    List<ProcurementSource> selectByExample(ProcurementSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    ProcurementSource selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") ProcurementSource record, @Param("example") ProcurementSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") ProcurementSource record, @Param("example") ProcurementSourceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProcurementSource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_procurementsource
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProcurementSource record);
    
    ProcurementSource selectByNo(String no);
}