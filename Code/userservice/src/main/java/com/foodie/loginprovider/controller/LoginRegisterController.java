package com.foodie.loginprovider.controller;

import com.foodie.dto.ServerResponse;
import com.foodie.dto.User;
import com.foodie.dto.UserT;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import com.foodie.service.LoginService;
import com.foodie.service.RegisterService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginRegisterController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterService registerService;

    @PostMapping("/login")
    public UserT login(@RequestBody User user) {
        return loginService.findUser(user);
    }

    @PostMapping("/register/student")
    public ServerResponse registerStudent(@RequestBody Student student) {
        return registerService.registerStudent(student);
    }

    @PostMapping("/register/teacher")
    public ServerResponse registerTeacher(@RequestBody Teacher teacher) {
        return registerService.registerTeacher(teacher);
    }

}
