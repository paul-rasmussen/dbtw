package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InvoicesExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public InvoicesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected InvoicesExample(InvoicesExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
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
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table invoices
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table invoices
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

        public Criteria andTrackingNoIsNull() {
            addCriterion("tracking_no is null");
            return this;
        }

        public Criteria andTrackingNoIsNotNull() {
            addCriterion("tracking_no is not null");
            return this;
        }

        public Criteria andTrackingNoEqualTo(String value) {
            addCriterion("tracking_no =", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoNotEqualTo(String value) {
            addCriterion("tracking_no <>", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoGreaterThan(String value) {
            addCriterion("tracking_no >", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoGreaterThanOrEqualTo(String value) {
            addCriterion("tracking_no >=", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoLessThan(String value) {
            addCriterion("tracking_no <", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoLessThanOrEqualTo(String value) {
            addCriterion("tracking_no <=", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoLike(String value) {
            addCriterion("tracking_no like", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoNotLike(String value) {
            addCriterion("tracking_no not like", value, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoIn(List<String> values) {
            addCriterion("tracking_no in", values, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoNotIn(List<String> values) {
            addCriterion("tracking_no not in", values, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoBetween(String value1, String value2) {
            addCriterion("tracking_no between", value1, value2, "trackingNo");
            return this;
        }

        public Criteria andTrackingNoNotBetween(String value1, String value2) {
            addCriterion("tracking_no not between", value1, value2, "trackingNo");
            return this;
        }

        public Criteria andGeneratedIsNull() {
            addCriterion("generated is null");
            return this;
        }

        public Criteria andGeneratedIsNotNull() {
            addCriterion("generated is not null");
            return this;
        }

        public Criteria andGeneratedEqualTo(Date value) {
            addCriterionForJDBCDate("generated =", value, "generated");
            return this;
        }

        public Criteria andGeneratedNotEqualTo(Date value) {
            addCriterionForJDBCDate("generated <>", value, "generated");
            return this;
        }

        public Criteria andGeneratedGreaterThan(Date value) {
            addCriterionForJDBCDate("generated >", value, "generated");
            return this;
        }

        public Criteria andGeneratedGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("generated >=", value, "generated");
            return this;
        }

        public Criteria andGeneratedLessThan(Date value) {
            addCriterionForJDBCDate("generated <", value, "generated");
            return this;
        }

        public Criteria andGeneratedLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("generated <=", value, "generated");
            return this;
        }

        public Criteria andGeneratedIn(List<Date> values) {
            addCriterionForJDBCDate("generated in", values, "generated");
            return this;
        }

        public Criteria andGeneratedNotIn(List<Date> values) {
            addCriterionForJDBCDate("generated not in", values, "generated");
            return this;
        }

        public Criteria andGeneratedBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("generated between", value1, value2, "generated");
            return this;
        }

        public Criteria andGeneratedNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("generated not between", value1, value2, "generated");
            return this;
        }

        public Criteria andDeliveredIsNull() {
            addCriterion("delivered is null");
            return this;
        }

        public Criteria andDeliveredIsNotNull() {
            addCriterion("delivered is not null");
            return this;
        }

        public Criteria andDeliveredEqualTo(Date value) {
            addCriterionForJDBCDate("delivered =", value, "delivered");
            return this;
        }

        public Criteria andDeliveredNotEqualTo(Date value) {
            addCriterionForJDBCDate("delivered <>", value, "delivered");
            return this;
        }

        public Criteria andDeliveredGreaterThan(Date value) {
            addCriterionForJDBCDate("delivered >", value, "delivered");
            return this;
        }

        public Criteria andDeliveredGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("delivered >=", value, "delivered");
            return this;
        }

        public Criteria andDeliveredLessThan(Date value) {
            addCriterionForJDBCDate("delivered <", value, "delivered");
            return this;
        }

        public Criteria andDeliveredLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("delivered <=", value, "delivered");
            return this;
        }

        public Criteria andDeliveredIn(List<Date> values) {
            addCriterionForJDBCDate("delivered in", values, "delivered");
            return this;
        }

        public Criteria andDeliveredNotIn(List<Date> values) {
            addCriterionForJDBCDate("delivered not in", values, "delivered");
            return this;
        }

        public Criteria andDeliveredBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("delivered between", value1, value2, "delivered");
            return this;
        }

        public Criteria andDeliveredNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("delivered not between", value1, value2, "delivered");
            return this;
        }

        public Criteria andPayorIdIsNull() {
            addCriterion("payor_id is null");
            return this;
        }

        public Criteria andPayorIdIsNotNull() {
            addCriterion("payor_id is not null");
            return this;
        }

        public Criteria andPayorIdEqualTo(Integer value) {
            addCriterion("payor_id =", value, "payorId");
            return this;
        }

        public Criteria andPayorIdNotEqualTo(Integer value) {
            addCriterion("payor_id <>", value, "payorId");
            return this;
        }

        public Criteria andPayorIdGreaterThan(Integer value) {
            addCriterion("payor_id >", value, "payorId");
            return this;
        }

        public Criteria andPayorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payor_id >=", value, "payorId");
            return this;
        }

        public Criteria andPayorIdLessThan(Integer value) {
            addCriterion("payor_id <", value, "payorId");
            return this;
        }

        public Criteria andPayorIdLessThanOrEqualTo(Integer value) {
            addCriterion("payor_id <=", value, "payorId");
            return this;
        }

        public Criteria andPayorIdIn(List<Integer> values) {
            addCriterion("payor_id in", values, "payorId");
            return this;
        }

        public Criteria andPayorIdNotIn(List<Integer> values) {
            addCriterion("payor_id not in", values, "payorId");
            return this;
        }

        public Criteria andPayorIdBetween(Integer value1, Integer value2) {
            addCriterion("payor_id between", value1, value2, "payorId");
            return this;
        }

        public Criteria andPayorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payor_id not between", value1, value2, "payorId");
            return this;
        }

        public Criteria andPayeeIdIsNull() {
            addCriterion("payee_id is null");
            return this;
        }

        public Criteria andPayeeIdIsNotNull() {
            addCriterion("payee_id is not null");
            return this;
        }

        public Criteria andPayeeIdEqualTo(Integer value) {
            addCriterion("payee_id =", value, "payeeId");
            return this;
        }

        public Criteria andPayeeIdNotEqualTo(Integer value) {
            addCriterion("payee_id <>", value, "payeeId");
            return this;
        }

        public Criteria andPayeeIdGreaterThan(Integer value) {
            addCriterion("payee_id >", value, "payeeId");
            return this;
        }

        public Criteria andPayeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("payee_id >=", value, "payeeId");
            return this;
        }

        public Criteria andPayeeIdLessThan(Integer value) {
            addCriterion("payee_id <", value, "payeeId");
            return this;
        }

        public Criteria andPayeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("payee_id <=", value, "payeeId");
            return this;
        }

        public Criteria andPayeeIdIn(List<Integer> values) {
            addCriterion("payee_id in", values, "payeeId");
            return this;
        }

        public Criteria andPayeeIdNotIn(List<Integer> values) {
            addCriterion("payee_id not in", values, "payeeId");
            return this;
        }

        public Criteria andPayeeIdBetween(Integer value1, Integer value2) {
            addCriterion("payee_id between", value1, value2, "payeeId");
            return this;
        }

        public Criteria andPayeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("payee_id not between", value1, value2, "payeeId");
            return this;
        }

        public Criteria andPerodStartIsNull() {
            addCriterion("perod_start is null");
            return this;
        }

        public Criteria andPerodStartIsNotNull() {
            addCriterion("perod_start is not null");
            return this;
        }

        public Criteria andPerodStartEqualTo(Date value) {
            addCriterionForJDBCDate("perod_start =", value, "perodStart");
            return this;
        }

        public Criteria andPerodStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("perod_start <>", value, "perodStart");
            return this;
        }

        public Criteria andPerodStartGreaterThan(Date value) {
            addCriterionForJDBCDate("perod_start >", value, "perodStart");
            return this;
        }

        public Criteria andPerodStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("perod_start >=", value, "perodStart");
            return this;
        }

        public Criteria andPerodStartLessThan(Date value) {
            addCriterionForJDBCDate("perod_start <", value, "perodStart");
            return this;
        }

        public Criteria andPerodStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("perod_start <=", value, "perodStart");
            return this;
        }

        public Criteria andPerodStartIn(List<Date> values) {
            addCriterionForJDBCDate("perod_start in", values, "perodStart");
            return this;
        }

        public Criteria andPerodStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("perod_start not in", values, "perodStart");
            return this;
        }

        public Criteria andPerodStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("perod_start between", value1, value2, "perodStart");
            return this;
        }

        public Criteria andPerodStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("perod_start not between", value1, value2, "perodStart");
            return this;
        }

        public Criteria andPeriodEndIsNull() {
            addCriterion("period_end is null");
            return this;
        }

        public Criteria andPeriodEndIsNotNull() {
            addCriterion("period_end is not null");
            return this;
        }

        public Criteria andPeriodEndEqualTo(Date value) {
            addCriterionForJDBCDate("period_end =", value, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("period_end <>", value, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndGreaterThan(Date value) {
            addCriterionForJDBCDate("period_end >", value, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("period_end >=", value, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndLessThan(Date value) {
            addCriterionForJDBCDate("period_end <", value, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("period_end <=", value, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndIn(List<Date> values) {
            addCriterionForJDBCDate("period_end in", values, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("period_end not in", values, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("period_end between", value1, value2, "periodEnd");
            return this;
        }

        public Criteria andPeriodEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("period_end not between", value1, value2, "periodEnd");
            return this;
        }
    }
}