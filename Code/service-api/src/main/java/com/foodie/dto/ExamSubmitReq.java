package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: czely
 * @Date: 2021/6/5 17:02
 * @Description: 学生提交测试
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamSubmitReq {
    //提交状态
    private boolean submitState;
    //学生id
    private Integer stuId;
    //测试id
    private Integer examId;
    //总分（隐藏）
    private String totalmark;

}
