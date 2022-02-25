package com.foodie.teacher.controller;
import com.foodie.dto.*;
import com.foodie.pojo.Teacher;
import com.foodie.teacher.feignapi.AuthService;
import com.foodie.teacher.feignapi.ExamProvider;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 专门用来跳转页面，返回modelandview的。
 */
@Controller
public class PageController {

    @Autowired
    ExamController examController;

    @Autowired
    AuthController authController;

    @GetMapping("/getteacher")
    public ModelAndView getteacher(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        //从cookie获得teacher
        Teacher teacher = authController.getObject(request);

        ServerResponse examgetlistteacher = examController.examgetlistteacher(teacher.getTeaid());
        ArrayList<ExamCreate> examCreates = (ArrayList<ExamCreate>) examgetlistteacher.getData();

        modelAndView.setViewName("teacher");
        modelAndView.addObject("teacher", teacher);
        modelAndView.addObject("examcreatelist", examCreates);
        return modelAndView;
    }

    @GetMapping("/getteacherpaperdetailpub")
    public ModelAndView getteacherpaperdetailpub(@RequestParam(value = "examid") int examid){
        ModelAndView modelAndView = new ModelAndView();

        //从前端获得examid
        ServerResponse examgetteacher = examController.examgetteacher(examid);
        ExamTeaRes examTeaRes = (ExamTeaRes) examgetteacher.getData();

        modelAndView.setViewName("teacherpaperdetailpub");
        modelAndView.addObject("examteares",examTeaRes);
        return modelAndView;
    }


    @GetMapping("/getteacherpaperdetailunpub")
    public ModelAndView getteacherpaperdetailunpub(@RequestParam(value = "examid") int examid){
        ModelAndView modelAndView = new ModelAndView();

        //从前端获得examid
        ServerResponse examgetteacher = examController.examgetteacher(examid);
        ExamTeaRes examTeaRes = (ExamTeaRes) examgetteacher.getData();

        modelAndView.setViewName("teacherpaperdetailunpub");
        modelAndView.addObject("examteares",examTeaRes);
        return modelAndView;
    }

    @GetMapping("/getcreatepaper")
    public ModelAndView getcreatepaper(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView();

        //从cookie获得teacher
        Teacher teacher = authController.getObject(request);
        ExamCreate examCreate=new ExamCreate();
        examCreate.setTeaId(teacher.getTeaid());
        ServerResponse examcreate = examController.examcreate(examCreate);
        examCreate = (ExamCreate) examcreate.getData();

        modelAndView.setViewName("createpaper");
        modelAndView.addObject("examcreate",examCreate);
        return modelAndView;
    }

}
