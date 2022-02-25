package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: czely
 * @Date: 2021/6/11 18:16
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamStu {
    private Boolean submitState;

    private ExamCreate examCreate;

    private Integer stuId;
}
