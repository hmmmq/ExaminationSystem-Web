package com.foodie.cookie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class savecookie {
    @RequestMapping("/savecookie")
    String savecookie(HttpServletRequest request, HttpServletResponse servletResponse){
        String value="value";
        Cookie cookie = new Cookie("name", value);
        cookie.setPath("/");
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(3600);
        servletResponse.addCookie(cookie);
        servletResponse.setHeader("name",value);
        return "example";
    }
    @ResponseBody
    @RequestMapping("/anotherpage")
    String anotherpage(){
        return "good";
    }
}
