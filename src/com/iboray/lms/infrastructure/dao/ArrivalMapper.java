package com.iboray.lms.infrastructure.dao;

import com.iboray.lms.domain.entity.Arrival;
import com.iboray.lms.domain.entity.ArrivalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArrivalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int countByExample(ArrivalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int deleteByExample(ArrivalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int insert(Arrival record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int insertSelective(Arrival record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    List<Arrival> selectByExample(ArrivalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    Arrival selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") Arrival record, @Param("example") ArrivalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") Arrival record, @Param("example") ArrivalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Arrival record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_d_arrival
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Arrival record);
}