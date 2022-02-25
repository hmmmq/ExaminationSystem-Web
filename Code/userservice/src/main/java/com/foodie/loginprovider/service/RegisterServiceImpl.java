package com.foodie.loginprovider.service;

import com.foodie.dto.ServerResponse;
import com.foodie.loginprovider.mapper.StudentMapper;
import com.foodie.loginprovider.mapper.TeacherMapper;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import com.foodie.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public ServerResponse registerStudent(Student student) {
        int ires = studentMapper.insertStudent(student);
        //int id = student.getStuid();
        //System.out.println(id);
        if (ires != 0) {
            return ServerResponse.createBySuccess("register success: 影响行数" + ires, student);
        }
        else {return ServerResponse.createByErrorMessage("register fail");}
    }

    @Override
    public ServerResponse registerTeacher(Teacher teacher) {
        int ires = teacherMapper.insertTeacher(teacher);
        //int id = teacher.getTeaid();
        //System.out.println(id);
        if (ires != 0) {
            return ServerResponse.createBySuccess("register success: 影响行数" + ires, teacher);
        }
        else {return ServerResponse.createByErrorMessage("register fail");}
    }
}
