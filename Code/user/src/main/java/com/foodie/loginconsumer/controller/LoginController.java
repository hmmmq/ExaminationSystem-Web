package com.foodie.loginconsumer.controller;
import com.foodie.dto.User;
import com.foodie.dto.UserT;
import com.foodie.loginconsumer.feignclient.AuthService;
import com.foodie.loginconsumer.feignclient.UserService;
import com.foodie.loginconsumer.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    UserService userservice;
    @Autowired
    AuthService authService;
    CookieUtils cookieUtils = new CookieUtils();
    String createtoken;
    int userType;
    UserT userT;
    ModelAndView modelAndView = new ModelAndView();

    @RequestMapping("/unauthorized")
    public  String tounauthorized(){
        return "unauthorized";
    }

    //打开登录页面
    @RequestMapping("/index")
    public String toLogin(HttpServletRequest httpServletRequest) {
        return check(httpServletRequest);
    }
    //检查cookie里的key和token
    private String check(HttpServletRequest httpServletRequest) {
        Cookie cookie = cookieUtils.getCookieByName(httpServletRequest, "key");
        if (null==cookie)
            return "index";
        String key=cookie.getValue();
        if (StringUtils.isEmpty(key))
            return "index";
        if (key.charAt(0)=='1')
            return "redirect:http://localhost/student/getpaperground";
        else
            return "redirect:http://localhost/teacher/getteacher";
    }
    //用户登录，保存token至redis,存Key与token到cookie,responseheader.
    @PostMapping("/login")
    public String login(@NotNull User user, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest){
        check(httpServletRequest);
        do {
            userT = userservice.login(user);
        }while (null==userT);
        userType = userT.getUserType();
        if (userType == 0) {
        } else {
            String key;
            do {
                key = authService.getkey(userT);
                createtoken = authService.createtoken(userT);
                cookieUtils.setCookie(httpServletResponse, "token", createtoken, 3600);
                cookieUtils.setCookie(httpServletResponse, "key", key, 3600);
              }while (StringUtils.isEmpty(createtoken)||StringUtils.isEmpty(key));

            modelAndView.addObject("userT", userT);
            if (userType == 1)
                return "redirect:http://localhost/student/getpaperground";
            else if (userType == 2)
                return "redirect:http://localhost/teacher/getteacher";
        }
        return "redirect:http://localhost/userclient/index";
    }


}
