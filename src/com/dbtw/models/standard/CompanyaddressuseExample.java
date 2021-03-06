package com.dbtw.models.standard;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CompanyaddressuseExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public CompanyaddressuseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected CompanyaddressuseExample(CompanyaddressuseExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
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
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table companyaddressuse
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table companyaddressuse
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

        public Criteria andEffectiveStartIsNull() {
            addCriterion("effective_start is null");
            return this;
        }

        public Criteria andEffectiveStartIsNotNull() {
            addCriterion("effective_start is not null");
            return this;
        }

        public Criteria andEffectiveStartEqualTo(Date value) {
            addCriterionForJDBCDate("effective_start =", value, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("effective_start <>", value, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartGreaterThan(Date value) {
            addCriterionForJDBCDate("effective_start >", value, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_start >=", value, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartLessThan(Date value) {
            addCriterionForJDBCDate("effective_start <", value, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_start <=", value, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartIn(List<Date> values) {
            addCriterionForJDBCDate("effective_start in", values, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("effective_start not in", values, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_start between", value1, value2, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_start not between", value1, value2, "effectiveStart");
            return this;
        }

        public Criteria andEffectiveEndIsNull() {
            addCriterion("effective_end is null");
            return this;
        }

        public Criteria andEffectiveEndIsNotNull() {
            addCriterion("effective_end is not null");
            return this;
        }

        public Criteria andEffectiveEndEqualTo(Date value) {
            addCriterionForJDBCDate("effective_end =", value, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndNotEqualTo(Date value) {
            addCriterionForJDBCDate("effective_end <>", value, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndGreaterThan(Date value) {
            addCriterionForJDBCDate("effective_end >", value, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_end >=", value, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndLessThan(Date value) {
            addCriterionForJDBCDate("effective_end <", value, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("effective_end <=", value, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndIn(List<Date> values) {
            addCriterionForJDBCDate("effective_end in", values, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndNotIn(List<Date> values) {
            addCriterionForJDBCDate("effective_end not in", values, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_end between", value1, value2, "effectiveEnd");
            return this;
        }

        public Criteria andEffectiveEndNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("effective_end not between", value1, value2, "effectiveEnd");
            return this;
        }

        public Criteria andAddressIdIsNull() {
            addCriterion("Address_id is null");
            return this;
        }

        public Criteria andAddressIdIsNotNull() {
            addCriterion("Address_id is not null");
            return this;
        }

        public Criteria andAddressIdEqualTo(Integer value) {
            addCriterion("Address_id =", value, "addressId");
            return this;
        }

        public Criteria andAddressIdNotEqualTo(Integer value) {
            addCriterion("Address_id <>", value, "addressId");
            return this;
        }

        public Criteria andAddressIdGreaterThan(Integer value) {
            addCriterion("Address_id >", value, "addressId");
            return this;
        }

        public Criteria andAddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Address_id >=", value, "addressId");
            return this;
        }

        public Criteria andAddressIdLessThan(Integer value) {
            addCriterion("Address_id <", value, "addressId");
            return this;
        }

        public Criteria andAddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("Address_id <=", value, "addressId");
            return this;
        }

        public Criteria andAddressIdIn(List<Integer> values) {
            addCriterion("Address_id in", values, "addressId");
            return this;
        }

        public Criteria andAddressIdNotIn(List<Integer> values) {
            addCriterion("Address_id not in", values, "addressId");
            return this;
        }

        public Criteria andAddressIdBetween(Integer value1, Integer value2) {
            addCriterion("Address_id between", value1, value2, "addressId");
            return this;
        }

        public Criteria andAddressIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Address_id not between", value1, value2, "addressId");
            return this;
        }

        public Criteria andAddressusetypesIdIsNull() {
            addCriterion("AddressUseTypes_id is null");
            return this;
        }

        public Criteria andAddressusetypesIdIsNotNull() {
            addCriterion("AddressUseTypes_id is not null");
            return this;
        }

        public Criteria andAddressusetypesIdEqualTo(Integer value) {
            addCriterion("AddressUseTypes_id =", value, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdNotEqualTo(Integer value) {
            addCriterion("AddressUseTypes_id <>", value, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdGreaterThan(Integer value) {
            addCriterion("AddressUseTypes_id >", value, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("AddressUseTypes_id >=", value, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdLessThan(Integer value) {
            addCriterion("AddressUseTypes_id <", value, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdLessThanOrEqualTo(Integer value) {
            addCriterion("AddressUseTypes_id <=", value, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdIn(List<Integer> values) {
            addCriterion("AddressUseTypes_id in", values, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdNotIn(List<Integer> values) {
            addCriterion("AddressUseTypes_id not in", values, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdBetween(Integer value1, Integer value2) {
            addCriterion("AddressUseTypes_id between", value1, value2, "addressusetypesId");
            return this;
        }

        public Criteria andAddressusetypesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("AddressUseTypes_id not between", value1, value2, "addressusetypesId");
            return this;
        }

        public Criteria andCompaniesIdIsNull() {
            addCriterion("Companies_id is null");
            return this;
        }

        public Criteria andCompaniesIdIsNotNull() {
            addCriterion("Companies_id is not null");
            return this;
        }

        public Criteria andCompaniesIdEqualTo(Integer value) {
            addCriterion("Companies_id =", value, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdNotEqualTo(Integer value) {
            addCriterion("Companies_id <>", value, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdGreaterThan(Integer value) {
            addCriterion("Companies_id >", value, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Companies_id >=", value, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdLessThan(Integer value) {
            addCriterion("Companies_id <", value, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdLessThanOrEqualTo(Integer value) {
            addCriterion("Companies_id <=", value, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdIn(List<Integer> values) {
            addCriterion("Companies_id in", values, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdNotIn(List<Integer> values) {
            addCriterion("Companies_id not in", values, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdBetween(Integer value1, Integer value2) {
            addCriterion("Companies_id between", value1, value2, "companiesId");
            return this;
        }

        public Criteria andCompaniesIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Companies_id not between", value1, value2, "companiesId");
            return this;
        }
    }
}