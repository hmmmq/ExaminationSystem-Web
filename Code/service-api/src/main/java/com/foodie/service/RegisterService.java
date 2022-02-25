package com.foodie.service;

import com.foodie.dto.ResponseCode;
import com.foodie.dto.ServerResponse;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;

public interface RegisterService {
//    学生注册
    ServerResponse registerStudent(Student student);
//    教师注册
    ServerResponse registerTeacher(Teacher teacher);
}
