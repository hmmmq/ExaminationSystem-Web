package com.foodie.examconsumer.feignapi;

import com.foodie.dto.*;
import com.foodie.examconsumer.exception.ExamFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "examserver", fallback = ExamFallBack.class)
@Component
public interface ExamController {

    @GetMapping("/exam/stuGetList")
    public ServerResponse<List<ExamStu>> stuSearchExamList(@RequestParam(value = "stuId", required = true) Integer stuId, @RequestParam(value = "batchId", required = true) Integer batchId);

    @PostMapping("/exam/stuGetExamDetail")
    public ServerResponse<ExamStuRes> stuSearchExam(@RequestBody StuGetReq stuGetReq);

    @PostMapping("/exam/stuStartTest")
    public ServerResponse<ExamCreateStu> stuStartExam(@RequestBody StuGetReq stuGetReq);


    @PutMapping("/exam/stuSubmitTest")
    public ServerResponse<ExamStuRes> stuSubmitExam(@RequestBody StuGetReq stuGetReq);
}
