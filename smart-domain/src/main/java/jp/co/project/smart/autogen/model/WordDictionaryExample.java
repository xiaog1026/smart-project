package jp.co.project.smart.autogen.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WordDictionaryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public WordDictionaryExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
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
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andWordIdIsNull() {
            addCriterion("word_id is null");
            return (Criteria) this;
        }

        public Criteria andWordIdIsNotNull() {
            addCriterion("word_id is not null");
            return (Criteria) this;
        }

        public Criteria andWordIdEqualTo(Integer value) {
            addCriterion("word_id =", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotEqualTo(Integer value) {
            addCriterion("word_id <>", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThan(Integer value) {
            addCriterion("word_id >", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("word_id >=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThan(Integer value) {
            addCriterion("word_id <", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdLessThanOrEqualTo(Integer value) {
            addCriterion("word_id <=", value, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdIn(List<Integer> values) {
            addCriterion("word_id in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotIn(List<Integer> values) {
            addCriterion("word_id not in", values, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdBetween(Integer value1, Integer value2) {
            addCriterion("word_id between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordIdNotBetween(Integer value1, Integer value2) {
            addCriterion("word_id not between", value1, value2, "wordId");
            return (Criteria) this;
        }

        public Criteria andWordLengthIsNull() {
            addCriterion("word_length is null");
            return (Criteria) this;
        }

        public Criteria andWordLengthIsNotNull() {
            addCriterion("word_length is not null");
            return (Criteria) this;
        }

        public Criteria andWordLengthEqualTo(Integer value) {
            addCriterion("word_length =", value, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthNotEqualTo(Integer value) {
            addCriterion("word_length <>", value, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthGreaterThan(Integer value) {
            addCriterion("word_length >", value, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthGreaterThanOrEqualTo(Integer value) {
            addCriterion("word_length >=", value, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthLessThan(Integer value) {
            addCriterion("word_length <", value, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthLessThanOrEqualTo(Integer value) {
            addCriterion("word_length <=", value, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthIn(List<Integer> values) {
            addCriterion("word_length in", values, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthNotIn(List<Integer> values) {
            addCriterion("word_length not in", values, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthBetween(Integer value1, Integer value2) {
            addCriterion("word_length between", value1, value2, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordLengthNotBetween(Integer value1, Integer value2) {
            addCriterion("word_length not between", value1, value2, "wordLength");
            return (Criteria) this;
        }

        public Criteria andWordDecimalIsNull() {
            addCriterion("word_decimal is null");
            return (Criteria) this;
        }

        public Criteria andWordDecimalIsNotNull() {
            addCriterion("word_decimal is not null");
            return (Criteria) this;
        }

        public Criteria andWordDecimalEqualTo(Integer value) {
            addCriterion("word_decimal =", value, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalNotEqualTo(Integer value) {
            addCriterion("word_decimal <>", value, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalGreaterThan(Integer value) {
            addCriterion("word_decimal >", value, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalGreaterThanOrEqualTo(Integer value) {
            addCriterion("word_decimal >=", value, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalLessThan(Integer value) {
            addCriterion("word_decimal <", value, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalLessThanOrEqualTo(Integer value) {
            addCriterion("word_decimal <=", value, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalIn(List<Integer> values) {
            addCriterion("word_decimal in", values, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalNotIn(List<Integer> values) {
            addCriterion("word_decimal not in", values, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalBetween(Integer value1, Integer value2) {
            addCriterion("word_decimal between", value1, value2, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andWordDecimalNotBetween(Integer value1, Integer value2) {
            addCriterion("word_decimal not between", value1, value2, "wordDecimal");
            return (Criteria) this;
        }

        public Criteria andArrayFlgIsNull() {
            addCriterion("array_flg is null");
            return (Criteria) this;
        }

        public Criteria andArrayFlgIsNotNull() {
            addCriterion("array_flg is not null");
            return (Criteria) this;
        }

        public Criteria andArrayFlgEqualTo(Boolean value) {
            addCriterion("array_flg =", value, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgNotEqualTo(Boolean value) {
            addCriterion("array_flg <>", value, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgGreaterThan(Boolean value) {
            addCriterion("array_flg >", value, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgGreaterThanOrEqualTo(Boolean value) {
            addCriterion("array_flg >=", value, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgLessThan(Boolean value) {
            addCriterion("array_flg <", value, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgLessThanOrEqualTo(Boolean value) {
            addCriterion("array_flg <=", value, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgIn(List<Boolean> values) {
            addCriterion("array_flg in", values, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgNotIn(List<Boolean> values) {
            addCriterion("array_flg not in", values, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgBetween(Boolean value1, Boolean value2) {
            addCriterion("array_flg between", value1, value2, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayFlgNotBetween(Boolean value1, Boolean value2) {
            addCriterion("array_flg not between", value1, value2, "arrayFlg");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionIsNull() {
            addCriterion("array_dimension is null");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionIsNotNull() {
            addCriterion("array_dimension is not null");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionEqualTo(Integer value) {
            addCriterion("array_dimension =", value, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionNotEqualTo(Integer value) {
            addCriterion("array_dimension <>", value, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionGreaterThan(Integer value) {
            addCriterion("array_dimension >", value, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionGreaterThanOrEqualTo(Integer value) {
            addCriterion("array_dimension >=", value, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionLessThan(Integer value) {
            addCriterion("array_dimension <", value, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionLessThanOrEqualTo(Integer value) {
            addCriterion("array_dimension <=", value, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionIn(List<Integer> values) {
            addCriterion("array_dimension in", values, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionNotIn(List<Integer> values) {
            addCriterion("array_dimension not in", values, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionBetween(Integer value1, Integer value2) {
            addCriterion("array_dimension between", value1, value2, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andArrayDimensionNotBetween(Integer value1, Integer value2) {
            addCriterion("array_dimension not between", value1, value2, "arrayDimension");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andLogicNameIsNull() {
            addCriterion("logic_name is null");
            return (Criteria) this;
        }

        public Criteria andLogicNameIsNotNull() {
            addCriterion("logic_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogicNameEqualTo(String value) {
            addCriterion("logic_name =", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameNotEqualTo(String value) {
            addCriterion("logic_name <>", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameGreaterThan(String value) {
            addCriterion("logic_name >", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameGreaterThanOrEqualTo(String value) {
            addCriterion("logic_name >=", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameLessThan(String value) {
            addCriterion("logic_name <", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameLessThanOrEqualTo(String value) {
            addCriterion("logic_name <=", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameLike(String value) {
            addCriterion("logic_name like", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameNotLike(String value) {
            addCriterion("logic_name not like", value, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameIn(List<String> values) {
            addCriterion("logic_name in", values, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameNotIn(List<String> values) {
            addCriterion("logic_name not in", values, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameBetween(String value1, String value2) {
            addCriterion("logic_name between", value1, value2, "logicName");
            return (Criteria) this;
        }

        public Criteria andLogicNameNotBetween(String value1, String value2) {
            addCriterion("logic_name not between", value1, value2, "logicName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIsNull() {
            addCriterion("physical_name is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIsNotNull() {
            addCriterion("physical_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameEqualTo(String value) {
            addCriterion("physical_name =", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotEqualTo(String value) {
            addCriterion("physical_name <>", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameGreaterThan(String value) {
            addCriterion("physical_name >", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("physical_name >=", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLessThan(String value) {
            addCriterion("physical_name <", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLessThanOrEqualTo(String value) {
            addCriterion("physical_name <=", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLike(String value) {
            addCriterion("physical_name like", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotLike(String value) {
            addCriterion("physical_name not like", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIn(List<String> values) {
            addCriterion("physical_name in", values, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotIn(List<String> values) {
            addCriterion("physical_name not in", values, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameBetween(String value1, String value2) {
            addCriterion("physical_name between", value1, value2, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotBetween(String value1, String value2) {
            addCriterion("physical_name not between", value1, value2, "physicalName");
            return (Criteria) this;
        }

        public Criteria andWordTypeIsNull() {
            addCriterion("word_type is null");
            return (Criteria) this;
        }

        public Criteria andWordTypeIsNotNull() {
            addCriterion("word_type is not null");
            return (Criteria) this;
        }

        public Criteria andWordTypeEqualTo(String value) {
            addCriterion("word_type =", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotEqualTo(String value) {
            addCriterion("word_type <>", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeGreaterThan(String value) {
            addCriterion("word_type >", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeGreaterThanOrEqualTo(String value) {
            addCriterion("word_type >=", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeLessThan(String value) {
            addCriterion("word_type <", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeLessThanOrEqualTo(String value) {
            addCriterion("word_type <=", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeLike(String value) {
            addCriterion("word_type like", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotLike(String value) {
            addCriterion("word_type not like", value, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeIn(List<String> values) {
            addCriterion("word_type in", values, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotIn(List<String> values) {
            addCriterion("word_type not in", values, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeBetween(String value1, String value2) {
            addCriterion("word_type between", value1, value2, "wordType");
            return (Criteria) this;
        }

        public Criteria andWordTypeNotBetween(String value1, String value2) {
            addCriterion("word_type not between", value1, value2, "wordType");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table word_dictionary
     *
     * @mbg.generated do_not_delete_during_merge Fri Jan 22 13:43:20 JST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table word_dictionary
     *
     * @mbg.generated Fri Jan 22 13:43:20 JST 2021
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