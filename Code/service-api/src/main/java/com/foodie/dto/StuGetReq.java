package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用于学生请求测试详情和开始测试以及提交测试的入参
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuGetReq {
    Integer examid;
    Integer stuid;
}
