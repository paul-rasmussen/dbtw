package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TaskordersExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public TaskordersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected TaskordersExample(TaskordersExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table taskorders
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public static class Criteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return this;
        }

        public Criteria andSeqEqualTo(Integer value) {
            addCriterion("seq =", value, "seq");
            return this;
        }

        public Criteria andSeqNotEqualTo(Integer value) {
            addCriterion("seq <>", value, "seq");
            return this;
        }

        public Criteria andSeqGreaterThan(Integer value) {
            addCriterion("seq >", value, "seq");
            return this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("seq >=", value, "seq");
            return this;
        }

        public Criteria andSeqLessThan(Integer value) {
            addCriterion("seq <", value, "seq");
            return this;
        }

        public Criteria andSeqLessThanOrEqualTo(Integer value) {
            addCriterion("seq <=", value, "seq");
            return this;
        }

        public Criteria andSeqIn(List<Integer> values) {
            addCriterion("seq in", values, "seq");
            return this;
        }

        public Criteria andSeqNotIn(List<Integer> values) {
            addCriterion("seq not in", values, "seq");
            return this;
        }

        public Criteria andSeqBetween(Integer value1, Integer value2) {
            addCriterion("seq between", value1, value2, "seq");
            return this;
        }

        public Criteria andSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return this;
        }

        public Criteria andStartIsNull() {
            addCriterion("start is null");
            return this;
        }

        public Criteria andStartIsNotNull() {
            addCriterion("start is not null");
            return this;
        }

        public Criteria andStartEqualTo(Date value) {
            addCriterionForJDBCDate("start =", value, "start");
            return this;
        }

        public Criteria andStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("start <>", value, "start");
            return this;
        }

        public Criteria andStartGreaterThan(Date value) {
            addCriterionForJDBCDate("start >", value, "start");
            return this;
        }

        public Criteria andStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start >=", value, "start");
            return this;
        }

        public Criteria andStartLessThan(Date value) {
            addCriterionForJDBCDate("start <", value, "start");
            return this;
        }

        public Criteria andStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("start <=", value, "start");
            return this;
        }

        public Criteria andStartIn(List<Date> values) {
            addCriterionForJDBCDate("start in", values, "start");
            return this;
        }

        public Criteria andStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("start not in", values, "start");
            return this;
        }

        public Criteria andStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start between", value1, value2, "start");
            return this;
        }

        public Criteria andStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("start not between", value1, value2, "start");
            return this;
        }

        public Criteria andStopIsNull() {
            addCriterion("stop is null");
            return this;
        }

        public Criteria andStopIsNotNull() {
            addCriterion("stop is not null");
            return this;
        }

        public Criteria andStopEqualTo(Date value) {
            addCriterionForJDBCDate("stop =", value, "stop");
            return this;
        }

        public Criteria andStopNotEqualTo(Date value) {
            addCriterionForJDBCDate("stop <>", value, "stop");
            return this;
        }

        public Criteria andStopGreaterThan(Date value) {
            addCriterionForJDBCDate("stop >", value, "stop");
            return this;
        }

        public Criteria andStopGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stop >=", value, "stop");
            return this;
        }

        public Criteria andStopLessThan(Date value) {
            addCriterionForJDBCDate("stop <", value, "stop");
            return this;
        }

        public Criteria andStopLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stop <=", value, "stop");
            return this;
        }

        public Criteria andStopIn(List<Date> values) {
            addCriterionForJDBCDate("stop in", values, "stop");
            return this;
        }

        public Criteria andStopNotIn(List<Date> values) {
            addCriterionForJDBCDate("stop not in", values, "stop");
            return this;
        }

        public Criteria andStopBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stop between", value1, value2, "stop");
            return this;
        }

        public Criteria andStopNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stop not between", value1, value2, "stop");
            return this;
        }

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return this;
        }

        public Criteria andContractIdEqualTo(Integer value) {
            addCriterion("contract_id =", value, "contractId");
            return this;
        }

        public Criteria andContractIdNotEqualTo(Integer value) {
            addCriterion("contract_id <>", value, "contractId");
            return this;
        }

        public Criteria andContractIdGreaterThan(Integer value) {
            addCriterion("contract_id >", value, "contractId");
            return this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_id >=", value, "contractId");
            return this;
        }

        public Criteria andContractIdLessThan(Integer value) {
            addCriterion("contract_id <", value, "contractId");
            return this;
        }

        public Criteria andContractIdLessThanOrEqualTo(Integer value) {
            addCriterion("contract_id <=", value, "contractId");
            return this;
        }

        public Criteria andContractIdIn(List<Integer> values) {
            addCriterion("contract_id in", values, "contractId");
            return this;
        }

        public Criteria andContractIdNotIn(List<Integer> values) {
            addCriterion("contract_id not in", values, "contractId");
            return this;
        }

        public Criteria andContractIdBetween(Integer value1, Integer value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return this;
        }

        public Criteria andContractIdNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return this;
        }

        public Criteria andContractsIdIsNull() {
            addCriterion("Contracts_id is null");
            return this;
        }

        public Criteria andContractsIdIsNotNull() {
            addCriterion("Contracts_id is not null");
            return this;
        }

        public Criteria andContractsIdEqualTo(Integer value) {
            addCriterion("Contracts_id =", value, "contractsId");
            return this;
        }

        public Criteria andContractsIdNotEqualTo(Integer value) {
            addCriterion("Contracts_id <>", value, "contractsId");
            return this;
        }

        public Criteria andContractsIdGreaterThan(Integer value) {
            addCriterion("Contracts_id >", value, "contractsId");
            return this;
        }

        public Criteria andContractsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Contracts_id >=", value, "contractsId");
            return this;
        }

        public Criteria andContractsIdLessThan(Integer value) {
            addCriterion("Contracts_id <", value, "contractsId");
            return this;
        }

        public Criteria andContractsIdLessThanOrEqualTo(Integer value) {
            addCriterion("Contracts_id <=", value, "contractsId");
            return this;
        }

        public Criteria andContractsIdIn(List<Integer> values) {
            addCriterion("Contracts_id in", values, "contractsId");
            return this;
        }

        public Criteria andContractsIdNotIn(List<Integer> values) {
            addCriterion("Contracts_id not in", values, "contractsId");
            return this;
        }

        public Criteria andContractsIdBetween(Integer value1, Integer value2) {
            addCriterion("Contracts_id between", value1, value2, "contractsId");
            return this;
        }

        public Criteria andContractsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Contracts_id not between", value1, value2, "contractsId");
            return this;
        }
    }
}