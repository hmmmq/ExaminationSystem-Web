package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemExamStu {
    ItemExam itemExam;//原试题选项
    ItemEditStu itemEditStu;//学生答题情况
}
