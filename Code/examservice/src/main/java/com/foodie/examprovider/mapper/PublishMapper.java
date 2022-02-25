package com.foodie.examprovider.mapper;

import com.foodie.pojo.Publish;

import java.util.Date;
import java.util.List;

public interface PublishMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table publish
     *
     * @mbg.generated
     */
    int insert(Publish record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table publish
     *
     * @mbg.generated
     */
    List<Publish> selectAll();

    String selectPublishTimeByExamId(Integer examid);

    Integer[] selectBatchIdsTimeByExamId(Integer examid);



}