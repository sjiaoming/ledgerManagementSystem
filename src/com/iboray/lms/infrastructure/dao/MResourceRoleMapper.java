package com.iboray.lms.infrastructure.dao;

import com.iboray.lms.domain.entity.MResourceRole;
import com.iboray.lms.domain.entity.MResourceRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MResourceRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int countByExample(MResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int deleteByExample(MResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int insert(MResourceRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int insertSelective(MResourceRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    List<MResourceRole> selectByExample(MResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    MResourceRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MResourceRole record, @Param("example") MResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MResourceRole record, @Param("example") MResourceRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MResourceRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_a_mresourcerole
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MResourceRole record);
}