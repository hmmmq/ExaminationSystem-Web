package com.foodie.teacher.controller;

import com.foodie.dto.UserT;
import com.foodie.pojo.Teacher;
import com.foodie.teacher.config.CookieUtils;
import com.foodie.teacher.feignapi.AuthService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    UserT userT = new UserT();
    Teacher teacher = new Teacher();
    {
        teacher.setName("Delucia");
        teacher.setTeaid(1001);
        teacher.setPassword("Delucia123");
        userT.setUserType(2);
        userT.setStudent(null);
        userT.setTeacher(teacher);
    }

    @GetMapping("/setCookies")
    public String setCookies(HttpServletResponse response){
        String token = authService.createtoken(userT);
        CookieUtils cookieUtils = new CookieUtils();
        cookieUtils.setCookie(response,"token", token, 6000);
        return "cookie添加成功";
    }

    //从cookie中得到teacher
    @GetMapping("getObject")
    public Teacher getObject(HttpServletRequest request) {
        CookieUtils cookieUtils = new CookieUtils();
        Cookie cookie = cookieUtils.getCookieByName(request, "token");
        UserT userT = authService.gettokenobject(cookie.getValue());
        System.out.println(userT.toString());
        return userT.getTeacher();
    }

}
