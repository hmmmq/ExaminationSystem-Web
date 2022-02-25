package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: czely
 * @Date: 2021/6/5 16:35
 * @Description: 表示题目基本信息和学生答题基本信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemEditStu {
    //试题编号
    private Integer itemId;
    //学生编号
    private Integer stuId;
    //学生答案
    private String stuAnswer;
    //是否正确
    private boolean isCorrect;
    //此题学生得分
    private String stuPoint;

}
