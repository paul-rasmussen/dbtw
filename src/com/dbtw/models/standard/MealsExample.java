package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MealsExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public MealsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected MealsExample(MealsExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
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
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table meals
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table meals
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

        public Criteria andEatenIsNull() {
            addCriterion("eaten is null");
            return this;
        }

        public Criteria andEatenIsNotNull() {
            addCriterion("eaten is not null");
            return this;
        }

        public Criteria andEatenEqualTo(Date value) {
            addCriterionForJDBCDate("eaten =", value, "eaten");
            return this;
        }

        public Criteria andEatenNotEqualTo(Date value) {
            addCriterionForJDBCDate("eaten <>", value, "eaten");
            return this;
        }

        public Criteria andEatenGreaterThan(Date value) {
            addCriterionForJDBCDate("eaten >", value, "eaten");
            return this;
        }

        public Criteria andEatenGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eaten >=", value, "eaten");
            return this;
        }

        public Criteria andEatenLessThan(Date value) {
            addCriterionForJDBCDate("eaten <", value, "eaten");
            return this;
        }

        public Criteria andEatenLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("eaten <=", value, "eaten");
            return this;
        }

        public Criteria andEatenIn(List<Date> values) {
            addCriterionForJDBCDate("eaten in", values, "eaten");
            return this;
        }

        public Criteria andEatenNotIn(List<Date> values) {
            addCriterionForJDBCDate("eaten not in", values, "eaten");
            return this;
        }

        public Criteria andEatenBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eaten between", value1, value2, "eaten");
            return this;
        }

        public Criteria andEatenNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("eaten not between", value1, value2, "eaten");
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

        public Criteria andMealtypesIdIsNull() {
            addCriterion("MealTypes_id is null");
            return this;
        }

        public Criteria andMealtypesIdIsNotNull() {
            addCriterion("MealTypes_id is not null");
            return this;
        }

        public Criteria andMealtypesIdEqualTo(Integer value) {
            addCriterion("MealTypes_id =", value, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdNotEqualTo(Integer value) {
            addCriterion("MealTypes_id <>", value, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdGreaterThan(Integer value) {
            addCriterion("MealTypes_id >", value, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("MealTypes_id >=", value, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdLessThan(Integer value) {
            addCriterion("MealTypes_id <", value, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdLessThanOrEqualTo(Integer value) {
            addCriterion("MealTypes_id <=", value, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdIn(List<Integer> values) {
            addCriterion("MealTypes_id in", values, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdNotIn(List<Integer> values) {
            addCriterion("MealTypes_id not in", values, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdBetween(Integer value1, Integer value2) {
            addCriterion("MealTypes_id between", value1, value2, "mealtypesId");
            return this;
        }

        public Criteria andMealtypesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("MealTypes_id not between", value1, value2, "mealtypesId");
            return this;
        }

        public Criteria andExpensetypesIdIsNull() {
            addCriterion("ExpenseTypes_id is null");
            return this;
        }

        public Criteria andExpensetypesIdIsNotNull() {
            addCriterion("ExpenseTypes_id is not null");
            return this;
        }

        public Criteria andExpensetypesIdEqualTo(Integer value) {
            addCriterion("ExpenseTypes_id =", value, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdNotEqualTo(Integer value) {
            addCriterion("ExpenseTypes_id <>", value, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdGreaterThan(Integer value) {
            addCriterion("ExpenseTypes_id >", value, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ExpenseTypes_id >=", value, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdLessThan(Integer value) {
            addCriterion("ExpenseTypes_id <", value, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdLessThanOrEqualTo(Integer value) {
            addCriterion("ExpenseTypes_id <=", value, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdIn(List<Integer> values) {
            addCriterion("ExpenseTypes_id in", values, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdNotIn(List<Integer> values) {
            addCriterion("ExpenseTypes_id not in", values, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdBetween(Integer value1, Integer value2) {
            addCriterion("ExpenseTypes_id between", value1, value2, "expensetypesId");
            return this;
        }

        public Criteria andExpensetypesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ExpenseTypes_id not between", value1, value2, "expensetypesId");
            return this;
        }

        public Criteria andEmployeesIdIsNull() {
            addCriterion("Employees_id is null");
            return this;
        }

        public Criteria andEmployeesIdIsNotNull() {
            addCriterion("Employees_id is not null");
            return this;
        }

        public Criteria andEmployeesIdEqualTo(Integer value) {
            addCriterion("Employees_id =", value, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdNotEqualTo(Integer value) {
            addCriterion("Employees_id <>", value, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdGreaterThan(Integer value) {
            addCriterion("Employees_id >", value, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Employees_id >=", value, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdLessThan(Integer value) {
            addCriterion("Employees_id <", value, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdLessThanOrEqualTo(Integer value) {
            addCriterion("Employees_id <=", value, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdIn(List<Integer> values) {
            addCriterion("Employees_id in", values, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdNotIn(List<Integer> values) {
            addCriterion("Employees_id not in", values, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdBetween(Integer value1, Integer value2) {
            addCriterion("Employees_id between", value1, value2, "employeesId");
            return this;
        }

        public Criteria andEmployeesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Employees_id not between", value1, value2, "employeesId");
            return this;
        }

        public Criteria andAllowableexpensesIdIsNull() {
            addCriterion("AllowableExpenses_id is null");
            return this;
        }

        public Criteria andAllowableexpensesIdIsNotNull() {
            addCriterion("AllowableExpenses_id is not null");
            return this;
        }

        public Criteria andAllowableexpensesIdEqualTo(Integer value) {
            addCriterion("AllowableExpenses_id =", value, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdNotEqualTo(Integer value) {
            addCriterion("AllowableExpenses_id <>", value, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdGreaterThan(Integer value) {
            addCriterion("AllowableExpenses_id >", value, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AllowableExpenses_id >=", value, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdLessThan(Integer value) {
            addCriterion("AllowableExpenses_id <", value, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdLessThanOrEqualTo(Integer value) {
            addCriterion("AllowableExpenses_id <=", value, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdIn(List<Integer> values) {
            addCriterion("AllowableExpenses_id in", values, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdNotIn(List<Integer> values) {
            addCriterion("AllowableExpenses_id not in", values, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdBetween(Integer value1, Integer value2) {
            addCriterion("AllowableExpenses_id between", value1, value2, "allowableexpensesId");
            return this;
        }

        public Criteria andAllowableexpensesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AllowableExpenses_id not between", value1, value2, "allowableexpensesId");
            return this;
        }
    }
}