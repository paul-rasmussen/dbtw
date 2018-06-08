package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmployeesExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public EmployeesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected EmployeesExample(EmployeesExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
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
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table employees
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table employees
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

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return this;
        }

        public Criteria andPersonIdEqualTo(Integer value) {
            addCriterion("person_id =", value, "personId");
            return this;
        }

        public Criteria andPersonIdNotEqualTo(Integer value) {
            addCriterion("person_id <>", value, "personId");
            return this;
        }

        public Criteria andPersonIdGreaterThan(Integer value) {
            addCriterion("person_id >", value, "personId");
            return this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_id >=", value, "personId");
            return this;
        }

        public Criteria andPersonIdLessThan(Integer value) {
            addCriterion("person_id <", value, "personId");
            return this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(Integer value) {
            addCriterion("person_id <=", value, "personId");
            return this;
        }

        public Criteria andPersonIdIn(List<Integer> values) {
            addCriterion("person_id in", values, "personId");
            return this;
        }

        public Criteria andPersonIdNotIn(List<Integer> values) {
            addCriterion("person_id not in", values, "personId");
            return this;
        }

        public Criteria andPersonIdBetween(Integer value1, Integer value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return this;
        }

        public Criteria andPersonIdNotBetween(Integer value1, Integer value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return this;
        }

        public Criteria andCompanyIdEqualTo(Integer value) {
            addCriterion("company_id =", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotEqualTo(Integer value) {
            addCriterion("company_id <>", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdGreaterThan(Integer value) {
            addCriterion("company_id >", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("company_id >=", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdLessThan(Integer value) {
            addCriterion("company_id <", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Integer value) {
            addCriterion("company_id <=", value, "companyId");
            return this;
        }

        public Criteria andCompanyIdIn(List<Integer> values) {
            addCriterion("company_id in", values, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotIn(List<Integer> values) {
            addCriterion("company_id not in", values, "companyId");
            return this;
        }

        public Criteria andCompanyIdBetween(Integer value1, Integer value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return this;
        }

        public Criteria andCompanyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return this;
        }

        public Criteria andEffectiveFromIsNull() {
            addCriterion("effective_from is null");
            return this;
        }

        public Criteria andEffectiveFromIsNotNull() {
            addCriterion("effective_from is not null");
            return this;
        }

        public Criteria andEffectiveFromEqualTo(Date value) {
            addCriterionForJDBCDate("effective_from =", value, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromNotEqualTo(Date value) {
            addCriterionForJDBCDate("effective_from <>", value, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromGreaterThan(Date value) {
            addCriterionForJDBCDate("effective_from >", value, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_from >=", value, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromLessThan(Date value) {
            addCriterionForJDBCDate("effective_from <", value, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_from <=", value, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromIn(List<Date> values) {
            addCriterionForJDBCDate("effective_from in", values, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromNotIn(List<Date> values) {
            addCriterionForJDBCDate("effective_from not in", values, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_from between", value1, value2, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveFromNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_from not between", value1, value2, "effectiveFrom");
            return this;
        }

        public Criteria andEffectiveToIsNull() {
            addCriterion("effective_to is null");
            return this;
        }

        public Criteria andEffectiveToIsNotNull() {
            addCriterion("effective_to is not null");
            return this;
        }

        public Criteria andEffectiveToEqualTo(Date value) {
            addCriterionForJDBCDate("effective_to =", value, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToNotEqualTo(Date value) {
            addCriterionForJDBCDate("effective_to <>", value, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToGreaterThan(Date value) {
            addCriterionForJDBCDate("effective_to >", value, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_to >=", value, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToLessThan(Date value) {
            addCriterionForJDBCDate("effective_to <", value, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_to <=", value, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToIn(List<Date> values) {
            addCriterionForJDBCDate("effective_to in", values, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToNotIn(List<Date> values) {
            addCriterionForJDBCDate("effective_to not in", values, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_to between", value1, value2, "effectiveTo");
            return this;
        }

        public Criteria andEffectiveToNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_to not between", value1, value2, "effectiveTo");
            return this;
        }
    }
}