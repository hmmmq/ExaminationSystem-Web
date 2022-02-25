package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

/**
 * @Author: czely
 * @Date: 2021/6/5 16:52
 * @Description: 描述发布测试需要的属性
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishReq {
    //测试编号
    private Integer examId;
    //一组要发布的班级号
    private Integer[] batchids;

}
