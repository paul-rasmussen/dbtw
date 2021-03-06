package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeclockExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public TimeclockExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected TimeclockExample(TimeclockExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
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
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table timeclock
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table timeclock
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

        public Criteria andEmployeeIdIsNull() {
            addCriterion("employee_id is null");
            return this;
        }

        public Criteria andEmployeeIdIsNotNull() {
            addCriterion("employee_id is not null");
            return this;
        }

        public Criteria andEmployeeIdEqualTo(Integer value) {
            addCriterion("employee_id =", value, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdNotEqualTo(Integer value) {
            addCriterion("employee_id <>", value, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdGreaterThan(Integer value) {
            addCriterion("employee_id >", value, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("employee_id >=", value, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdLessThan(Integer value) {
            addCriterion("employee_id <", value, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("employee_id <=", value, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdIn(List<Integer> values) {
            addCriterion("employee_id in", values, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdNotIn(List<Integer> values) {
            addCriterion("employee_id not in", values, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("employee_id between", value1, value2, "employeeId");
            return this;
        }

        public Criteria andEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("employee_id not between", value1, value2, "employeeId");
            return this;
        }

        public Criteria andWorkperformedIdIsNull() {
            addCriterion("workperformed_id is null");
            return this;
        }

        public Criteria andWorkperformedIdIsNotNull() {
            addCriterion("workperformed_id is not null");
            return this;
        }

        public Criteria andWorkperformedIdEqualTo(Integer value) {
            addCriterion("workperformed_id =", value, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdNotEqualTo(Integer value) {
            addCriterion("workperformed_id <>", value, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdGreaterThan(Integer value) {
            addCriterion("workperformed_id >", value, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("workperformed_id >=", value, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdLessThan(Integer value) {
            addCriterion("workperformed_id <", value, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdLessThanOrEqualTo(Integer value) {
            addCriterion("workperformed_id <=", value, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdIn(List<Integer> values) {
            addCriterion("workperformed_id in", values, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdNotIn(List<Integer> values) {
            addCriterion("workperformed_id not in", values, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdBetween(Integer value1, Integer value2) {
            addCriterion("workperformed_id between", value1, value2, "workperformedId");
            return this;
        }

        public Criteria andWorkperformedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("workperformed_id not between", value1, value2, "workperformedId");
            return this;
        }

        public Criteria andTimeInIsNull() {
            addCriterion("time_in is null");
            return this;
        }

        public Criteria andTimeInIsNotNull() {
            addCriterion("time_in is not null");
            return this;
        }

        public Criteria andTimeInEqualTo(Date value) {
            addCriterion("time_in =", value, "timeIn");
            return this;
        }

        public Criteria andTimeInNotEqualTo(Date value) {
            addCriterion("time_in <>", value, "timeIn");
            return this;
        }

        public Criteria andTimeInGreaterThan(Date value) {
            addCriterion("time_in >", value, "timeIn");
            return this;
        }

        public Criteria andTimeInGreaterThanOrEqualTo(Date value) {
            addCriterion("time_in >=", value, "timeIn");
            return this;
        }

        public Criteria andTimeInLessThan(Date value) {
            addCriterion("time_in <", value, "timeIn");
            return this;
        }

        public Criteria andTimeInLessThanOrEqualTo(Date value) {
            addCriterion("time_in <=", value, "timeIn");
            return this;
        }

        public Criteria andTimeInIn(List<Date> values) {
            addCriterion("time_in in", values, "timeIn");
            return this;
        }

        public Criteria andTimeInNotIn(List<Date> values) {
            addCriterion("time_in not in", values, "timeIn");
            return this;
        }

        public Criteria andTimeInBetween(Date value1, Date value2) {
            addCriterion("time_in between", value1, value2, "timeIn");
            return this;
        }

        public Criteria andTimeInNotBetween(Date value1, Date value2) {
            addCriterion("time_in not between", value1, value2, "timeIn");
            return this;
        }

        public Criteria andTimeOutIsNull() {
            addCriterion("time_out is null");
            return this;
        }

        public Criteria andTimeOutIsNotNull() {
            addCriterion("time_out is not null");
            return this;
        }

        public Criteria andTimeOutEqualTo(Date value) {
            addCriterion("time_out =", value, "timeOut");
            return this;
        }

        public Criteria andTimeOutNotEqualTo(Date value) {
            addCriterion("time_out <>", value, "timeOut");
            return this;
        }

        public Criteria andTimeOutGreaterThan(Date value) {
            addCriterion("time_out >", value, "timeOut");
            return this;
        }

        public Criteria andTimeOutGreaterThanOrEqualTo(Date value) {
            addCriterion("time_out >=", value, "timeOut");
            return this;
        }

        public Criteria andTimeOutLessThan(Date value) {
            addCriterion("time_out <", value, "timeOut");
            return this;
        }

        public Criteria andTimeOutLessThanOrEqualTo(Date value) {
            addCriterion("time_out <=", value, "timeOut");
            return this;
        }

        public Criteria andTimeOutIn(List<Date> values) {
            addCriterion("time_out in", values, "timeOut");
            return this;
        }

        public Criteria andTimeOutNotIn(List<Date> values) {
            addCriterion("time_out not in", values, "timeOut");
            return this;
        }

        public Criteria andTimeOutBetween(Date value1, Date value2) {
            addCriterion("time_out between", value1, value2, "timeOut");
            return this;
        }

        public Criteria andTimeOutNotBetween(Date value1, Date value2) {
            addCriterion("time_out not between", value1, value2, "timeOut");
            return this;
        }
    }
}