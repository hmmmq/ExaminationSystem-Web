package com.foodie.loginconsumer.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.foodie.dto.ServerResponse;
import com.foodie.loginconsumer.feignclient.UserService;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;

@RestController
public class RegisterController {

    @Autowired
    UserService userService;

    JSONObject jsonObject=new JSONObject();


    //打开选择注册页面，可以通过点击登录页面register跳转到这
    @RequestMapping("/register")
    public ModelAndView toRegister() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    //选择学生注册或老师注册，传入相应的对象到注册页面thymeleaf
    @RequestMapping("/toRegisterStudent")
    public ModelAndView toRegisterStudent(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("student", new Student());
        modelAndView.setViewName("registerstudents");
        return modelAndView;
    }

    @RequestMapping("/toRegisterTeacher")
    public ModelAndView toRegisterTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("teacher", new Teacher());
        modelAndView.setViewName("registerteacher");
        return modelAndView;
    }


    //实现注册
    @PostMapping("/registerStudent")
    public ModelAndView registerStudent(@NotNull Student student){
        ModelAndView modelAndView = new ModelAndView();
        ServerResponse serverResponse=new ServerResponse();
        do {
            serverResponse  = userService.registerStudent(student);
        }while (null==serverResponse);

        LinkedHashMap<String,Object> stumap = (LinkedHashMap<String, Object>) serverResponse.getData();
        student= JSON.parseObject(JSON.toJSONString(stumap), new TypeReference<Student>(){} );
        if (serverResponse.isSuccess()) {
            modelAndView.addObject("name", student.getName());
            modelAndView.addObject("id",student.getStuid());
            modelAndView.setViewName("registersuccess");
        }
        else {
            System.out.println("register fail");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

    @PostMapping("/registerTeacher")
    public ModelAndView registerTeacher(Teacher teacher) {
        ModelAndView modelAndView = new ModelAndView();
        ServerResponse serverResponse=new ServerResponse();
        do { serverResponse = userService.registerTeacher(teacher);
        }while (null==serverResponse);
        LinkedHashMap<String,Object> teamap = (LinkedHashMap<String, Object>) serverResponse.getData();
        teacher= JSON.parseObject(JSON.toJSONString(teamap), new TypeReference<Teacher>(){} );
        if (serverResponse.isSuccess()) {
            modelAndView.addObject("name", teacher.getName());
            modelAndView.addObject("id", teacher.getTeaid());
            modelAndView.setViewName("registersuccess");
        }
        else {
            System.out.println("register fail");
            modelAndView.setViewName("register");
        }
        return modelAndView;
    }

}
