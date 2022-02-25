package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * ExamCreateStu 一个DTO,用于学生开始测试，返回一张空白的学生试卷
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamCreateStu {
    boolean submitstate;//提交状态
    List<ItemExamStu> itemExamStus;//学生答题情况
}
