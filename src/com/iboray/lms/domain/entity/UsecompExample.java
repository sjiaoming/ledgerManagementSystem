package com.iboray.lms.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class UsecompExample {
	
	/**
	 * 分页起始
	 */
	protected int offset;
	/**
	 * 分页偏移量
	 */	
	protected int limit;
	
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public UsecompExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUsecompnoIsNull() {
            addCriterion("usecompNo is null");
            return (Criteria) this;
        }

        public Criteria andUsecompnoIsNotNull() {
            addCriterion("usecompNo is not null");
            return (Criteria) this;
        }

        public Criteria andUsecompnoEqualTo(String value) {
            addCriterion("usecompNo =", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoNotEqualTo(String value) {
            addCriterion("usecompNo <>", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoGreaterThan(String value) {
            addCriterion("usecompNo >", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoGreaterThanOrEqualTo(String value) {
            addCriterion("usecompNo >=", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoLessThan(String value) {
            addCriterion("usecompNo <", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoLessThanOrEqualTo(String value) {
            addCriterion("usecompNo <=", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoLike(String value) {
            addCriterion("usecompNo like", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoNotLike(String value) {
            addCriterion("usecompNo not like", value, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoIn(List<String> values) {
            addCriterion("usecompNo in", values, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoNotIn(List<String> values) {
            addCriterion("usecompNo not in", values, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoBetween(String value1, String value2) {
            addCriterion("usecompNo between", value1, value2, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompnoNotBetween(String value1, String value2) {
            addCriterion("usecompNo not between", value1, value2, "usecompno");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeIsNull() {
            addCriterion("usecompCode is null");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeIsNotNull() {
            addCriterion("usecompCode is not null");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeEqualTo(String value) {
            addCriterion("usecompCode =", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeNotEqualTo(String value) {
            addCriterion("usecompCode <>", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeGreaterThan(String value) {
            addCriterion("usecompCode >", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeGreaterThanOrEqualTo(String value) {
            addCriterion("usecompCode >=", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeLessThan(String value) {
            addCriterion("usecompCode <", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeLessThanOrEqualTo(String value) {
            addCriterion("usecompCode <=", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeLike(String value) {
            addCriterion("usecompCode like", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeNotLike(String value) {
            addCriterion("usecompCode not like", value, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeIn(List<String> values) {
            addCriterion("usecompCode in", values, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeNotIn(List<String> values) {
            addCriterion("usecompCode not in", values, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeBetween(String value1, String value2) {
            addCriterion("usecompCode between", value1, value2, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompcodeNotBetween(String value1, String value2) {
            addCriterion("usecompCode not between", value1, value2, "usecompcode");
            return (Criteria) this;
        }

        public Criteria andUsecompnameIsNull() {
            addCriterion("usecompName is null");
            return (Criteria) this;
        }

        public Criteria andUsecompnameIsNotNull() {
            addCriterion("usecompName is not null");
            return (Criteria) this;
        }

        public Criteria andUsecompnameEqualTo(String value) {
            addCriterion("usecompName =", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameNotEqualTo(String value) {
            addCriterion("usecompName <>", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameGreaterThan(String value) {
            addCriterion("usecompName >", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameGreaterThanOrEqualTo(String value) {
            addCriterion("usecompName >=", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameLessThan(String value) {
            addCriterion("usecompName <", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameLessThanOrEqualTo(String value) {
            addCriterion("usecompName <=", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameLike(String value) {
            addCriterion("usecompName like", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameNotLike(String value) {
            addCriterion("usecompName not like", value, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameIn(List<String> values) {
            addCriterion("usecompName in", values, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameNotIn(List<String> values) {
            addCriterion("usecompName not in", values, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameBetween(String value1, String value2) {
            addCriterion("usecompName between", value1, value2, "usecompname");
            return (Criteria) this;
        }

        public Criteria andUsecompnameNotBetween(String value1, String value2) {
            addCriterion("usecompName not between", value1, value2, "usecompname");
            return (Criteria) this;
        }

        public Criteria andSortname1IsNull() {
            addCriterion("sortName1 is null");
            return (Criteria) this;
        }

        public Criteria andSortname1IsNotNull() {
            addCriterion("sortName1 is not null");
            return (Criteria) this;
        }

        public Criteria andSortname1EqualTo(String value) {
            addCriterion("sortName1 =", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1NotEqualTo(String value) {
            addCriterion("sortName1 <>", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1GreaterThan(String value) {
            addCriterion("sortName1 >", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1GreaterThanOrEqualTo(String value) {
            addCriterion("sortName1 >=", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1LessThan(String value) {
            addCriterion("sortName1 <", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1LessThanOrEqualTo(String value) {
            addCriterion("sortName1 <=", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1Like(String value) {
            addCriterion("sortName1 like", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1NotLike(String value) {
            addCriterion("sortName1 not like", value, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1In(List<String> values) {
            addCriterion("sortName1 in", values, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1NotIn(List<String> values) {
            addCriterion("sortName1 not in", values, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1Between(String value1, String value2) {
            addCriterion("sortName1 between", value1, value2, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname1NotBetween(String value1, String value2) {
            addCriterion("sortName1 not between", value1, value2, "sortname1");
            return (Criteria) this;
        }

        public Criteria andSortname2IsNull() {
            addCriterion("sortName2 is null");
            return (Criteria) this;
        }

        public Criteria andSortname2IsNotNull() {
            addCriterion("sortName2 is not null");
            return (Criteria) this;
        }

        public Criteria andSortname2EqualTo(String value) {
            addCriterion("sortName2 =", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2NotEqualTo(String value) {
            addCriterion("sortName2 <>", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2GreaterThan(String value) {
            addCriterion("sortName2 >", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2GreaterThanOrEqualTo(String value) {
            addCriterion("sortName2 >=", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2LessThan(String value) {
            addCriterion("sortName2 <", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2LessThanOrEqualTo(String value) {
            addCriterion("sortName2 <=", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2Like(String value) {
            addCriterion("sortName2 like", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2NotLike(String value) {
            addCriterion("sortName2 not like", value, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2In(List<String> values) {
            addCriterion("sortName2 in", values, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2NotIn(List<String> values) {
            addCriterion("sortName2 not in", values, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2Between(String value1, String value2) {
            addCriterion("sortName2 between", value1, value2, "sortname2");
            return (Criteria) this;
        }

        public Criteria andSortname2NotBetween(String value1, String value2) {
            addCriterion("sortName2 not between", value1, value2, "sortname2");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoIsNull() {
            addCriterion("FK_parentUsecompNo is null");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoIsNotNull() {
            addCriterion("FK_parentUsecompNo is not null");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoEqualTo(String value) {
            addCriterion("FK_parentUsecompNo =", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoNotEqualTo(String value) {
            addCriterion("FK_parentUsecompNo <>", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoGreaterThan(String value) {
            addCriterion("FK_parentUsecompNo >", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoGreaterThanOrEqualTo(String value) {
            addCriterion("FK_parentUsecompNo >=", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoLessThan(String value) {
            addCriterion("FK_parentUsecompNo <", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoLessThanOrEqualTo(String value) {
            addCriterion("FK_parentUsecompNo <=", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoLike(String value) {
            addCriterion("FK_parentUsecompNo like", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoNotLike(String value) {
            addCriterion("FK_parentUsecompNo not like", value, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoIn(List<String> values) {
            addCriterion("FK_parentUsecompNo in", values, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoNotIn(List<String> values) {
            addCriterion("FK_parentUsecompNo not in", values, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoBetween(String value1, String value2) {
            addCriterion("FK_parentUsecompNo between", value1, value2, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andFkParentusecompnoNotBetween(String value1, String value2) {
            addCriterion("FK_parentUsecompNo not between", value1, value2, "fkParentusecompno");
            return (Criteria) this;
        }

        public Criteria andInvalidIsNull() {
            addCriterion("invalid is null");
            return (Criteria) this;
        }

        public Criteria andInvalidIsNotNull() {
            addCriterion("invalid is not null");
            return (Criteria) this;
        }

        public Criteria andInvalidEqualTo(String value) {
            addCriterion("invalid =", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotEqualTo(String value) {
            addCriterion("invalid <>", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidGreaterThan(String value) {
            addCriterion("invalid >", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidGreaterThanOrEqualTo(String value) {
            addCriterion("invalid >=", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidLessThan(String value) {
            addCriterion("invalid <", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidLessThanOrEqualTo(String value) {
            addCriterion("invalid <=", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidLike(String value) {
            addCriterion("invalid like", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotLike(String value) {
            addCriterion("invalid not like", value, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidIn(List<String> values) {
            addCriterion("invalid in", values, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotIn(List<String> values) {
            addCriterion("invalid not in", values, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidBetween(String value1, String value2) {
            addCriterion("invalid between", value1, value2, "invalid");
            return (Criteria) this;
        }

        public Criteria andInvalidNotBetween(String value1, String value2) {
            addCriterion("invalid not between", value1, value2, "invalid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(String value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(String value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(String value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(String value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLike(String value) {
            addCriterion("createTime like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotLike(String value) {
            addCriterion("createTime not like", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<String> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<String> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(String value1, String value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(String value1, String value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(String value) {
            addCriterion("updateTime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(String value) {
            addCriterion("updateTime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(String value) {
            addCriterion("updateTime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("updateTime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(String value) {
            addCriterion("updateTime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("updateTime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLike(String value) {
            addCriterion("updateTime like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotLike(String value) {
            addCriterion("updateTime not like", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<String> values) {
            addCriterion("updateTime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<String> values) {
            addCriterion("updateTime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(String value1, String value2) {
            addCriterion("updateTime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("updateTime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table lm_c_usecomp
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}