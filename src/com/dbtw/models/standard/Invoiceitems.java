package com.dbtw.models.standard;

public class Invoiceitems {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column invoiceitems.table_name
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private String tableName;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column invoiceitems.table_key
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer tableKey;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column invoiceitems.Invoices_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer invoicesId;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column invoiceitems.table_name
     *
     * @return the value of invoiceitems.table_name
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column invoiceitems.table_name
     *
     * @param tableName the value for invoiceitems.table_name
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column invoiceitems.table_key
     *
     * @return the value of invoiceitems.table_key
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getTableKey() {
        return tableKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column invoiceitems.table_key
     *
     * @param tableKey the value for invoiceitems.table_key
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setTableKey(Integer tableKey) {
        this.tableKey = tableKey;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column invoiceitems.Invoices_id
     *
     * @return the value of invoiceitems.Invoices_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getInvoicesId() {
        return invoicesId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column invoiceitems.Invoices_id
     *
     * @param invoicesId the value for invoiceitems.Invoices_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setInvoicesId(Integer invoicesId) {
        this.invoicesId = invoicesId;
    }
}