package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: czely
 * @Date: 2021/6/5 16:19
 * @Description: 描述一道题(除去id)的基本属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemAdd {
    //0单选，1多选
    private Integer type;
    //试卷编号
    private String examId;
    //内容
    private String content;
    //A选项
    private String a;
    //B选项
    private String b;
    //C选项
    private String c;
    //D选项
    private String d;
    //正确答案
    private String rightAnswer;
    //分值
    private Integer point;

}


