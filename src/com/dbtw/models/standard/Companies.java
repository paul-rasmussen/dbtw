package com.dbtw.models.standard;

public class Companies {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column companies.id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column companies.name
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private String name;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column companies.id
     *
     * @return the value of companies.id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column companies.id
     *
     * @param id the value for companies.id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column companies.name
     *
     * @return the value of companies.name
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column companies.name
     *
     * @param name the value for companies.name
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}