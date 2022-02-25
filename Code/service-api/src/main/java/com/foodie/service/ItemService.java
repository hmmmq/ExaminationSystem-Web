package com.foodie.service;

import com.foodie.dto.*;


public interface ItemService {
//    教师增加试题选项
ServerResponse addItem(ItemAdd itemAdd);
//    教师更新试题选项
ServerResponse updateItem(ItemExam itemExam);
//    教师删除试题选项
ServerResponse deleteItem(ItemDelete itemDelete);
//    学生选择选项
ServerResponse chooseItem(ItemEditStu itemEditStu);
}
