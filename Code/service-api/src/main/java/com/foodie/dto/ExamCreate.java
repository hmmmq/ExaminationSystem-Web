package com.foodie.dto;

import com.foodie.pojo.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: czely
 * @Date: 2021/6/5 16:44
 * @Description: 测试的基本信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamCreate {
    //测试编号
    private Integer examId;
    //教师编号
    private Integer teaId;
    //创建时间
    private String createTime;
    //测试标题，默认“未命名”
    private String title;
    //测试时长
    private Integer duration;
    //测试发布状态，默认false
    private boolean publishState;
}
