package com.dbtw.models.standard;

import java.util.Date;

public class Workperformed {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column workperformed.id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer id;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column workperformed.assignment_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer assignmentId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column workperformed.started
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Date started;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column workperformed.stopped
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Date stopped;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column workperformed.Assignments_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer assignmentsId;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database column workperformed.WorkTypes_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    private Integer worktypesId;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column workperformed.id
     *
     * @return the value of workperformed.id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column workperformed.id
     *
     * @param id the value for workperformed.id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column workperformed.assignment_id
     *
     * @return the value of workperformed.assignment_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getAssignmentId() {
        return assignmentId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column workperformed.assignment_id
     *
     * @param assignmentId the value for workperformed.assignment_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column workperformed.started
     *
     * @return the value of workperformed.started
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Date getStarted() {
        return started;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column workperformed.started
     *
     * @param started the value for workperformed.started
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setStarted(Date started) {
        this.started = started;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column workperformed.stopped
     *
     * @return the value of workperformed.stopped
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Date getStopped() {
        return stopped;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column workperformed.stopped
     *
     * @param stopped the value for workperformed.stopped
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setStopped(Date stopped) {
        this.stopped = stopped;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column workperformed.Assignments_id
     *
     * @return the value of workperformed.Assignments_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getAssignmentsId() {
        return assignmentsId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column workperformed.Assignments_id
     *
     * @param assignmentsId the value for workperformed.Assignments_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setAssignmentsId(Integer assignmentsId) {
        this.assignmentsId = assignmentsId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method returns the value of the database column workperformed.WorkTypes_id
     *
     * @return the value of workperformed.WorkTypes_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public Integer getWorktypesId() {
        return worktypesId;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method sets the value of the database column workperformed.WorkTypes_id
     *
     * @param worktypesId the value for workperformed.WorkTypes_id
     *
     * @ibatorgenerated Thu May 27 15:19:22 MDT 2010
     */
    public void setWorktypesId(Integer worktypesId) {
        this.worktypesId = worktypesId;
    }
}