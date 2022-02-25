package com.foodie.loginprovider.mapper;

import com.foodie.pojo.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    Student selectStudentByPrimaryKey(Student student);

    int insertStudent(Student record);
}
