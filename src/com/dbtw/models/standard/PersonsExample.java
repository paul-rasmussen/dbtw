package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonsExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public PersonsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected PersonsExample(PersonsExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
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
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table persons
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table persons
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

        public Criteria andFirstNameIsNull() {
            addCriterion("first_name is null");
            return this;
        }

        public Criteria andFirstNameIsNotNull() {
            addCriterion("first_name is not null");
            return this;
        }

        public Criteria andFirstNameEqualTo(String value) {
            addCriterion("first_name =", value, "firstName");
            return this;
        }

        public Criteria andFirstNameNotEqualTo(String value) {
            addCriterion("first_name <>", value, "firstName");
            return this;
        }

        public Criteria andFirstNameGreaterThan(String value) {
            addCriterion("first_name >", value, "firstName");
            return this;
        }

        public Criteria andFirstNameGreaterThanOrEqualTo(String value) {
            addCriterion("first_name >=", value, "firstName");
            return this;
        }

        public Criteria andFirstNameLessThan(String value) {
            addCriterion("first_name <", value, "firstName");
            return this;
        }

        public Criteria andFirstNameLessThanOrEqualTo(String value) {
            addCriterion("first_name <=", value, "firstName");
            return this;
        }

        public Criteria andFirstNameLike(String value) {
            addCriterion("first_name like", value, "firstName");
            return this;
        }

        public Criteria andFirstNameNotLike(String value) {
            addCriterion("first_name not like", value, "firstName");
            return this;
        }

        public Criteria andFirstNameIn(List<String> values) {
            addCriterion("first_name in", values, "firstName");
            return this;
        }

        public Criteria andFirstNameNotIn(List<String> values) {
            addCriterion("first_name not in", values, "firstName");
            return this;
        }

        public Criteria andFirstNameBetween(String value1, String value2) {
            addCriterion("first_name between", value1, value2, "firstName");
            return this;
        }

        public Criteria andFirstNameNotBetween(String value1, String value2) {
            addCriterion("first_name not between", value1, value2, "firstName");
            return this;
        }

        public Criteria andMiddleNameIsNull() {
            addCriterion("middle_name is null");
            return this;
        }

        public Criteria andMiddleNameIsNotNull() {
            addCriterion("middle_name is not null");
            return this;
        }

        public Criteria andMiddleNameEqualTo(String value) {
            addCriterion("middle_name =", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameNotEqualTo(String value) {
            addCriterion("middle_name <>", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameGreaterThan(String value) {
            addCriterion("middle_name >", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameGreaterThanOrEqualTo(String value) {
            addCriterion("middle_name >=", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameLessThan(String value) {
            addCriterion("middle_name <", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameLessThanOrEqualTo(String value) {
            addCriterion("middle_name <=", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameLike(String value) {
            addCriterion("middle_name like", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameNotLike(String value) {
            addCriterion("middle_name not like", value, "middleName");
            return this;
        }

        public Criteria andMiddleNameIn(List<String> values) {
            addCriterion("middle_name in", values, "middleName");
            return this;
        }

        public Criteria andMiddleNameNotIn(List<String> values) {
            addCriterion("middle_name not in", values, "middleName");
            return this;
        }

        public Criteria andMiddleNameBetween(String value1, String value2) {
            addCriterion("middle_name between", value1, value2, "middleName");
            return this;
        }

        public Criteria andMiddleNameNotBetween(String value1, String value2) {
            addCriterion("middle_name not between", value1, value2, "middleName");
            return this;
        }

        public Criteria andLastNameIsNull() {
            addCriterion("last_name is null");
            return this;
        }

        public Criteria andLastNameIsNotNull() {
            addCriterion("last_name is not null");
            return this;
        }

        public Criteria andLastNameEqualTo(String value) {
            addCriterion("last_name =", value, "lastName");
            return this;
        }

        public Criteria andLastNameNotEqualTo(String value) {
            addCriterion("last_name <>", value, "lastName");
            return this;
        }

        public Criteria andLastNameGreaterThan(String value) {
            addCriterion("last_name >", value, "lastName");
            return this;
        }

        public Criteria andLastNameGreaterThanOrEqualTo(String value) {
            addCriterion("last_name >=", value, "lastName");
            return this;
        }

        public Criteria andLastNameLessThan(String value) {
            addCriterion("last_name <", value, "lastName");
            return this;
        }

        public Criteria andLastNameLessThanOrEqualTo(String value) {
            addCriterion("last_name <=", value, "lastName");
            return this;
        }

        public Criteria andLastNameLike(String value) {
            addCriterion("last_name like", value, "lastName");
            return this;
        }

        public Criteria andLastNameNotLike(String value) {
            addCriterion("last_name not like", value, "lastName");
            return this;
        }

        public Criteria andLastNameIn(List<String> values) {
            addCriterion("last_name in", values, "lastName");
            return this;
        }

        public Criteria andLastNameNotIn(List<String> values) {
            addCriterion("last_name not in", values, "lastName");
            return this;
        }

        public Criteria andLastNameBetween(String value1, String value2) {
            addCriterion("last_name between", value1, value2, "lastName");
            return this;
        }

        public Criteria andLastNameNotBetween(String value1, String value2) {
            addCriterion("last_name not between", value1, value2, "lastName");
            return this;
        }

        public Criteria andDobIsNull() {
            addCriterion("dob is null");
            return this;
        }

        public Criteria andDobIsNotNull() {
            addCriterion("dob is not null");
            return this;
        }

        public Criteria andDobEqualTo(Date value) {
            addCriterionForJDBCDate("dob =", value, "dob");
            return this;
        }

        public Criteria andDobNotEqualTo(Date value) {
            addCriterionForJDBCDate("dob <>", value, "dob");
            return this;
        }

        public Criteria andDobGreaterThan(Date value) {
            addCriterionForJDBCDate("dob >", value, "dob");
            return this;
        }

        public Criteria andDobGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dob >=", value, "dob");
            return this;
        }

        public Criteria andDobLessThan(Date value) {
            addCriterionForJDBCDate("dob <", value, "dob");
            return this;
        }

        public Criteria andDobLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dob <=", value, "dob");
            return this;
        }

        public Criteria andDobIn(List<Date> values) {
            addCriterionForJDBCDate("dob in", values, "dob");
            return this;
        }

        public Criteria andDobNotIn(List<Date> values) {
            addCriterionForJDBCDate("dob not in", values, "dob");
            return this;
        }

        public Criteria andDobBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dob between", value1, value2, "dob");
            return this;
        }

        public Criteria andDobNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dob not between", value1, value2, "dob");
            return this;
        }

        public Criteria andSsnIsNull() {
            addCriterion("ssn is null");
            return this;
        }

        public Criteria andSsnIsNotNull() {
            addCriterion("ssn is not null");
            return this;
        }

        public Criteria andSsnEqualTo(Integer value) {
            addCriterion("ssn =", value, "ssn");
            return this;
        }

        public Criteria andSsnNotEqualTo(Integer value) {
            addCriterion("ssn <>", value, "ssn");
            return this;
        }

        public Criteria andSsnGreaterThan(Integer value) {
            addCriterion("ssn >", value, "ssn");
            return this;
        }

        public Criteria andSsnGreaterThanOrEqualTo(Integer value) {
            addCriterion("ssn >=", value, "ssn");
            return this;
        }

        public Criteria andSsnLessThan(Integer value) {
            addCriterion("ssn <", value, "ssn");
            return this;
        }

        public Criteria andSsnLessThanOrEqualTo(Integer value) {
            addCriterion("ssn <=", value, "ssn");
            return this;
        }

        public Criteria andSsnIn(List<Integer> values) {
            addCriterion("ssn in", values, "ssn");
            return this;
        }

        public Criteria andSsnNotIn(List<Integer> values) {
            addCriterion("ssn not in", values, "ssn");
            return this;
        }

        public Criteria andSsnBetween(Integer value1, Integer value2) {
            addCriterion("ssn between", value1, value2, "ssn");
            return this;
        }

        public Criteria andSsnNotBetween(Integer value1, Integer value2) {
            addCriterion("ssn not between", value1, value2, "ssn");
            return this;
        }
    }
}