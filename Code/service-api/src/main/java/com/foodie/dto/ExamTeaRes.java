package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: czely
 * @Date: 2021/6/5 16:56
 * @Description: 描述教师发布试卷的基本情况
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamTeaRes {
    //测试的基本信息
    private ExamCreate examCreate;
    //描述一道题的基本属性(含id编号)
    private List<ItemExam> itemExams;
    //发布日期
    private String publishTime;
    //发布的班级编号数组
    private Integer[] batchids;
}
