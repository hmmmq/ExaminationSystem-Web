package com.foodie.pojo;

import java.util.Date;

public class Publish {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.examid
     *
     * @mbg.generated
     */
    private Integer examid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.batchid
     *
     * @mbg.generated
     */
    private Integer batchid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column publish.publishtime
     *
     * @mbg.generated
     */
    private Date publishtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.examid
     *
     * @return the value of publish.examid
     *
     * @mbg.generated
     */
    public Integer getExamid() {
        return examid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.examid
     *
     * @param examid the value for publish.examid
     *
     * @mbg.generated
     */
    public void setExamid(Integer examid) {
        this.examid = examid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.batchid
     *
     * @return the value of publish.batchid
     *
     * @mbg.generated
     */
    public Integer getBatchid() {
        return batchid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.batchid
     *
     * @param batchid the value for publish.batchid
     *
     * @mbg.generated
     */
    public void setBatchid(Integer batchid) {
        this.batchid = batchid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column publish.publishtime
     *
     * @return the value of publish.publishtime
     *
     * @mbg.generated
     */
    public Date getPublishtime() {
        return publishtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column publish.publishtime
     *
     * @param publishtime the value for publish.publishtime
     *
     * @mbg.generated
     */
    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}