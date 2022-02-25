package com.foodie.loginprovider.mapper;

import com.foodie.pojo.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    Teacher selectTeacherByPrimaryKey(Teacher teacher);

    int insertTeacher(Teacher record);
}