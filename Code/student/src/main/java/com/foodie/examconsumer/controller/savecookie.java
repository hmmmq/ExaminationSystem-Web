package com.foodie.examconsumer.controller;

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
    @ResponseBody
    @RequestMapping("/savecookie")
    String savecookie(HttpServletRequest request, HttpServletResponse servletResponse){
        String value="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmb29kaWVzcXVhZCIsInR5cGUiOjEsInN0dWRlbnQiOnsic3R1aWQiOjEsInBhc3N3b3JkIjoiMTIzIiwibmFtZSI6ImN6IiwiYWNhZGVteSI6bnVsbCwic3RhcnR5ZWFyIjoxNTM1NzYwMDAwMDAwLCJkZWdyZWUiOm51bGwsIm1ham9yIjoiY3MiLCJiYXRjaGlkIjoyfSwidGVhY2hlciI6eyJ0ZWFpZCI6bnVsbCwibmFtZSI6bnVsbCwicGFzc3dvcmQiOm51bGx9LCJpYXQiOjE2MjQxNjAzMzksImV4cCI6MTYyNDc2NTEzOX0.5F4wlSf-gLM2TSFsV7p8rhs5znZ03g6RI5CJ-CBxzwE";
        Cookie cookie = new Cookie("token", value);
        cookie.setDomain("localhost");
        cookie.setPath("/");
        try {
            URLEncoder.encode(value, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        cookie.setMaxAge(3600);
        servletResponse.addCookie(cookie);
        servletResponse.setHeader("token",value);
        return "good";
    }
    @ResponseBody
    @RequestMapping("/anotherpage")
    String anotherpage(){
        return "good";
    }
}
