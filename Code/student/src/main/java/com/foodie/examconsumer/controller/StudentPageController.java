package com.foodie.examconsumer.controller;

import com.foodie.dto.*;
import com.foodie.examconsumer.config.CookieUtils;
import com.foodie.examconsumer.feignapi.AuthService;
import com.foodie.examconsumer.feignapi.ExamController;
import com.foodie.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * 专门用来跳转页面，返回modelandview的。
 */
@Controller
public class StudentPageController {

    @Autowired
    AuthService authService;

    @Autowired
    ExamController examController;

    private Student getStudent(HttpServletRequest request) {
        CookieUtils cookieUtils = new CookieUtils();
        Cookie cookie = cookieUtils.getCookieByName(request, "token");
        String token_val = cookie.getValue();
        UserT userT = authService.gettokenobject(token_val);
        Student student = null;
        if (userT != null) {
            student = userT.getStudent();
        }
        return student;
    }

    //学生主页和已考考试列表
    @GetMapping("/getstudent")
    public ModelAndView getstudent(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student");
        ArrayList<ExamStu> examStus = null;
        Student student = getStudent(request);
        System.out.println("************" + student.getStuid() + "************" + student.getBatchid());
        if (student != null) {
            ServerResponse stuGetExamList = new ServerResponse();
            do {
                stuGetExamList = examController.stuSearchExamList(student.getStuid(), student.getBatchid());
            } while (null == stuGetExamList);
            try {
                System.out.println("************" + stuGetExamList + "********************");
                examStus = (ArrayList<ExamStu>) stuGetExamList.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelAndView.addObject("student", student);
        modelAndView.addObject("examstus", examStus);
        return modelAndView;
    }

    //学生查看待考考试列表
    @GetMapping("/getpaperground")
    public ModelAndView getpaperground(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paperground");
        ArrayList<ExamStu> examStus = new ArrayList<>();
        Student student = getStudent(request);
        System.out.println("************" + student.getStuid() + "************" + student.getBatchid());
        if (student != null) {
            ServerResponse stuGetExamList = new ServerResponse();
            do {
                stuGetExamList = examController.stuSearchExamList(student.getStuid(), student.getBatchid());
            } while (null == stuGetExamList);
            try {
                System.out.println("************" + stuGetExamList + "********************");
                examStus = (ArrayList<ExamStu>) stuGetExamList.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelAndView.addObject("examstus", examStus);
        return modelAndView;
    }

    //学生开始考试页面
    @PostMapping("/getpaper")
    ModelAndView getpaper(HttpServletRequest request, ExamCreate examCreate) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paper");
        ExamCreateStu examCreateStu = null;
        Student student = getStudent(request);
        if (student != null) {
            StuGetReq stuGetReq = new StuGetReq();
            stuGetReq.setStuid(student.getStuid());
            stuGetReq.setExamid(examCreate.getExamId());
            ServerResponse<ExamCreateStu> examCreateStuServerResponse = new ServerResponse<>();
            do {
                examCreateStuServerResponse = examController.stuStartExam(stuGetReq);
            } while (null == examCreateStuServerResponse);
            try {
                examCreateStu = examCreateStuServerResponse.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null == examCreateStu) {
            modelAndView.addObject("examcreatestu", null);
        } else {
            modelAndView.addObject("examcreatestu", examCreateStu);
            modelAndView.addObject("stuid",student.getStuid());
        }
        modelAndView.addObject("examcreate", examCreate);
        return modelAndView;
    }

    //学生查看考试详情
    @PostMapping("/getpaperdetails")
    ModelAndView getpaperdetails(HttpServletRequest request, ExamCreate examCreate) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("paperdetails");
        ExamStuRes examStuRes = null;
        Student student = getStudent(request);
        System.out.println("*************" + student.getStuid() + "*************");
        if (student != null) {
            StuGetReq stuGetReq = new StuGetReq();
            stuGetReq.setStuid(student.getStuid());
            stuGetReq.setExamid(examCreate.getExamId());
            ServerResponse<ExamStuRes> examStuResServerResponse = new ServerResponse<>();
            do {
                examStuResServerResponse = examController.stuSearchExam(stuGetReq);
            } while (null == examStuResServerResponse);
            try {
                examStuRes = examStuResServerResponse.getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (null == examStuRes) {
            modelAndView.addObject("examstures", null);
        } else {
            modelAndView.addObject("examstures", examStuRes);
            modelAndView.addObject("examname", examCreate.getTitle());
        }
        return modelAndView;
    }

}
