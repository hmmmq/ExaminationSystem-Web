package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamStuRes {
    int totoalmark;//总分
    List<ItemExamStu> itemExamStus;//每道题的答题情况
}
