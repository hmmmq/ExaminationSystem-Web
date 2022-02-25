package com.foodie.examconsumer.controller;
import com.foodie.dto.*;
import com.foodie.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 专门返回GSON数据
 */
@RestController
public class MockExamController {

    private ExamService examService;

    @PostMapping("/mock/exam/create")
    public ServerResponse examcreate(ExamCreate examCreate){
        if (null == examCreate) {
            return ServerResponse.createByresponseCode(ResponseCode.FailAdd);
        } else {
            ServerResponse<ExamCreate> createexam = examService.createExam(examCreate);
            return createexam;
        }
    }

    @PutMapping("/mock/exam/save")
    public ServerResponse examsave(ExamCreate examCreate){
        if (null==examCreate)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        return ServerResponse.createByresponseCode(ResponseCode.SuccessfullyUpdate);

    }

    @PutMapping("/mock/exam/publish")
    public ServerResponse exampublish(@RequestBody PublishReq publishReq){
        if (null==publishReq)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        return ServerResponse.createByresponseCode(ResponseCode.SuccessfullyUpdate);
    }

    @GetMapping("/mock/exam/getlist/teacher")
    public ServerResponse examgetlistteacher(Integer teaid){
        if (null==teaid)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examService.teaSearchExamList(teaid);

    }

    @GetMapping("/mock/exam/getlist/student")
    public ServerResponse examgetliststudent(Integer stuId,Integer batchId){
        if (null==batchId)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examService.stuSearchExamList(stuId,batchId);

    }

    @PostMapping("/mock/exam/get/student")
    public ServerResponse examgetstudent(StuGetReq stuGetReq){
        if (null==stuGetReq)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examService.stuSearchExam(stuGetReq);
    }

    @GetMapping("/mock/exam/get/teacher")
    public ServerResponse examgetteacher(Integer examid){
        if (null==examid)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examService.teaSearchExam(examid);
    }

    @PostMapping("/mock/exam/starttest")
    public ServerResponse examstarttest(StuGetReq stuGetReq){
        if (null==stuGetReq)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examService.stuStartExam(stuGetReq);
    }

    @PutMapping("/mock/exam/submit")
    public ServerResponse examsubmit(StuGetReq stuGetReq){
        if (null==stuGetReq)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        return examService.stuSubmitExam(stuGetReq);
    }



}

