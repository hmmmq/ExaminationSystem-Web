package com.foodie.loginprovider.service;

import com.foodie.dto.User;
import com.foodie.dto.UserT;
import com.foodie.loginprovider.mapper.StudentMapper;
import com.foodie.loginprovider.mapper.TeacherMapper;
import com.foodie.pojo.Exam;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import com.foodie.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public UserT findUser(User user) {
        //System.out.println("LoginServiceImpl" + user);
        Student student = new Student();
        Teacher teacher = new Teacher();
        student.setStuid(user.getLoginId());
        student.setPassword(user.getPassword());
        teacher.setTeaid(user.getLoginId());
        teacher.setPassword(user.getPassword());
        student = studentMapper.selectStudentByPrimaryKey(student);
        teacher = teacherMapper.selectTeacherByPrimaryKey(teacher);
        System.out.println("student: " + student);
        System.out.println("teacher: " + teacher);
        if (student == null && teacher == null) {
            return new UserT(0, null, null);
        }
        else if (student != null && teacher == null) {return new UserT(1, student, null);}
        else {return new UserT(2, null, teacher);}
    }
}
