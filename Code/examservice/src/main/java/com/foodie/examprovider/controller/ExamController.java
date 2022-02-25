package com.foodie.examprovider.controller;
import com.foodie.dto.*;
import com.foodie.examprovider.examproviderapi.ExamProviderAPI;
import com.foodie.pojo.Teacher;
import com.foodie.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RefreshScope
public class ExamController implements ExamProviderAPI {
    @Autowired
    private ExamService examService;

    @Value("${server.port}")
    String port;


    @GetMapping("/getTeacher")
   public ServerResponse<Teacher> getTeacher(){
        Teacher teacher=new Teacher();
        teacher.setName("provider:"+port);
        teacher.setTeaid(1001);
        return ServerResponse.createBySuccess(teacher);
   }

    @GetMapping("/exam/teaCreateExam/{teaId}")
    public ServerResponse<ExamCreate> createexam(@PathVariable("teaId") Integer teaId){
        ExamCreate examCreate=new ExamCreate();
        examCreate.setTeaId(teaId);
        System.out.println("teaId:"+teaId);
        return examService.createExam(examCreate);
    }

    @PutMapping("/exam/save")
    public ServerResponse<ExamCreate> saveExam(@RequestBody ExamCreate examCreate){
        return examService.saveExam(examCreate);
    }

    @PutMapping("/exam/publish")
    public ServerResponse<ExamCreate> publishExam(@RequestBody PublishReq publishReq) {
        return examService.publishExam(publishReq);
    }

    @GetMapping("/exam/teaGetList/{teaId}")
    public ServerResponse<List<ExamCreate>> teaSearchExamList(@PathVariable("teaId") Integer teaId) {
        return examService.teaSearchExamList(teaId);
    }

    @GetMapping("/exam/stuGetList")
    public ServerResponse<List<ExamStu>> stuSearchExamList(@RequestParam(value = "stuId",required = true) Integer stuId,@RequestParam(value = "batchId",required = true) Integer batchId) {
        return examService.stuSearchExamList(stuId,batchId);
    }

    @PostMapping("/exam/stuGetExamDetail")
    public ServerResponse<ExamStuRes> stuSearchExam(@RequestBody StuGetReq stuGetReq){
        return examService.stuSearchExam(stuGetReq);
    }

    @GetMapping("/exam/teaGetExamDetail/{examId}")
    public ServerResponse<ExamTeaRes> teaSearchExam(@PathVariable("examId") Integer examId){
        return examService.teaSearchExam(examId);
    }

    @PostMapping("/exam/stuStartTest")
    public ServerResponse<ExamCreateStu> stuStartExam(@RequestBody StuGetReq stuGetReq){
        return examService.stuStartExam(stuGetReq);
    }


    @PutMapping("/exam/stuSubmitTest")
    public ServerResponse<ExamStuRes> stuSubmitExam(@RequestBody StuGetReq stuGetReq){
        return examService.stuSubmitExam(stuGetReq);
    }



}
