package com.foodie.examprovider.mapper;

import com.foodie.dto.ExamCreate;
import com.foodie.pojo.Exam;

import java.util.List;

/**
 * @Author: czely
 * @Date: 2021/6/9 17:12
 * @Description:
 */
public interface ExamCreateMapper {
    List<ExamCreate> selectByTeaId(Integer teaid);

    int updateByPrimaryKey(ExamCreate record);

    ExamCreate selectByPrimaryKey(Integer examid);

    List<ExamCreate> selectPublishExamByBatchId(Integer batchid);

    int insert(ExamCreate record);
}
