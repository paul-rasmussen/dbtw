package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GasExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public GasExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected GasExample(GasExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
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
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table gas
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table gas
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

        public Criteria andGallonsIsNull() {
            addCriterion("gallons is null");
            return this;
        }

        public Criteria andGallonsIsNotNull() {
            addCriterion("gallons is not null");
            return this;
        }

        public Criteria andGallonsEqualTo(Double value) {
            addCriterion("gallons =", value, "gallons");
            return this;
        }

        public Criteria andGallonsNotEqualTo(Double value) {
            addCriterion("gallons <>", value, "gallons");
            return this;
        }

        public Criteria andGallonsGreaterThan(Double value) {
            addCriterion("gallons >", value, "gallons");
            return this;
        }

        public Criteria andGallonsGreaterThanOrEqualTo(Double value) {
            addCriterion("gallons >=", value, "gallons");
            return this;
        }

        public Criteria andGallonsLessThan(Double value) {
            addCriterion("gallons <", value, "gallons");
            return this;
        }

        public Criteria andGallonsLessThanOrEqualTo(Double value) {
            addCriterion("gallons <=", value, "gallons");
            return this;
        }

        public Criteria andGallonsIn(List<Double> values) {
            addCriterion("gallons in", values, "gallons");
            return this;
        }

        public Criteria andGallonsNotIn(List<Double> values) {
            addCriterion("gallons not in", values, "gallons");
            return this;
        }

        public Criteria andGallonsBetween(Double value1, Double value2) {
            addCriterion("gallons between", value1, value2, "gallons");
            return this;
        }

        public Criteria andGallonsNotBetween(Double value1, Double value2) {
            addCriterion("gallons not between", value1, value2, "gallons");
            return this;
        }

        public Criteria andActualIsNull() {
            addCriterion("actual is null");
            return this;
        }

        public Criteria andActualIsNotNull() {
            addCriterion("actual is not null");
            return this;
        }

        public Criteria andActualEqualTo(Double value) {
            addCriterion("actual =", value, "actual");
            return this;
        }

        public Criteria andActualNotEqualTo(Double value) {
            addCriterion("actual <>", value, "actual");
            return this;
        }

        public Criteria andActualGreaterThan(Double value) {
            addCriterion("actual >", value, "actual");
            return this;
        }

        public Criteria andActualGreaterThanOrEqualTo(Double value) {
            addCriterion("actual >=", value, "actual");
            return this;
        }

        public Criteria andActualLessThan(Double value) {
            addCriterion("actual <", value, "actual");
            return this;
        }

        public Criteria andActualLessThanOrEqualTo(Double value) {
            addCriterion("actual <=", value, "actual");
            return this;
        }

        public Criteria andActualIn(List<Double> values) {
            addCriterion("actual in", values, "actual");
            return this;
        }

        public Criteria andActualNotIn(List<Double> values) {
            addCriterion("actual not in", values, "actual");
            return this;
        }

        public Criteria andActualBetween(Double value1, Double value2) {
            addCriterion("actual between", value1, value2, "actual");
            return this;
        }

        public Criteria andActualNotBetween(Double value1, Double value2) {
            addCriterion("actual not between", value1, value2, "actual");
            return this;
        }

        public Criteria andPumpedIsNull() {
            addCriterion("pumped is null");
            return this;
        }

        public Criteria andPumpedIsNotNull() {
            addCriterion("pumped is not null");
            return this;
        }

        public Criteria andPumpedEqualTo(Date value) {
            addCriterionForJDBCDate("pumped =", value, "pumped");
            return this;
        }

        public Criteria andPumpedNotEqualTo(Date value) {
            addCriterionForJDBCDate("pumped <>", value, "pumped");
            return this;
        }

        public Criteria andPumpedGreaterThan(Date value) {
            addCriterionForJDBCDate("pumped >", value, "pumped");
            return this;
        }

        public Criteria andPumpedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pumped >=", value, "pumped");
            return this;
        }

        public Criteria andPumpedLessThan(Date value) {
            addCriterionForJDBCDate("pumped <", value, "pumped");
            return this;
        }

        public Criteria andPumpedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pumped <=", value, "pumped");
            return this;
        }

        public Criteria andPumpedIn(List<Date> values) {
            addCriterionForJDBCDate("pumped in", values, "pumped");
            return this;
        }

        public Criteria andPumpedNotIn(List<Date> values) {
            addCriterionForJDBCDate("pumped not in", values, "pumped");
            return this;
        }

        public Criteria andPumpedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pumped between", value1, value2, "pumped");
            return this;
        }

        public Criteria andPumpedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pumped not between", value1, value2, "pumped");
            return this;
        }

        public Criteria andAutorentalIdIsNull() {
            addCriterion("autorental_id is null");
            return this;
        }

        public Criteria andAutorentalIdIsNotNull() {
            addCriterion("autorental_id is not null");
            return this;
        }

        public Criteria andAutorentalIdEqualTo(Integer value) {
            addCriterion("autorental_id =", value, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdNotEqualTo(Integer value) {
            addCriterion("autorental_id <>", value, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdGreaterThan(Integer value) {
            addCriterion("autorental_id >", value, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("autorental_id >=", value, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdLessThan(Integer value) {
            addCriterion("autorental_id <", value, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdLessThanOrEqualTo(Integer value) {
            addCriterion("autorental_id <=", value, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdIn(List<Integer> values) {
            addCriterion("autorental_id in", values, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdNotIn(List<Integer> values) {
            addCriterion("autorental_id not in", values, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdBetween(Integer value1, Integer value2) {
            addCriterion("autorental_id between", value1, value2, "autorentalId");
            return this;
        }

        public Criteria andAutorentalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("autorental_id not between", value1, value2, "autorentalId");
            return this;
        }

        public Criteria andAutorentalsIdIsNull() {
            addCriterion("AutoRentals_id is null");
            return this;
        }

        public Criteria andAutorentalsIdIsNotNull() {
            addCriterion("AutoRentals_id is not null");
            return this;
        }

        public Criteria andAutorentalsIdEqualTo(Integer value) {
            addCriterion("AutoRentals_id =", value, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdNotEqualTo(Integer value) {
            addCriterion("AutoRentals_id <>", value, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdGreaterThan(Integer value) {
            addCriterion("AutoRentals_id >", value, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AutoRentals_id >=", value, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdLessThan(Integer value) {
            addCriterion("AutoRentals_id <", value, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdLessThanOrEqualTo(Integer value) {
            addCriterion("AutoRentals_id <=", value, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdIn(List<Integer> values) {
            addCriterion("AutoRentals_id in", values, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdNotIn(List<Integer> values) {
            addCriterion("AutoRentals_id not in", values, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdBetween(Integer value1, Integer value2) {
            addCriterion("AutoRentals_id between", value1, value2, "autorentalsId");
            return this;
        }

        public Criteria andAutorentalsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AutoRentals_id not between", value1, value2, "autorentalsId");
            return this;
        }
    }
}