package com.foodie.teacher.feignapi;

import com.foodie.teacher.exception.ExamProviderBackFactory;
import com.foodie.pojo.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.foodie.dto.*;

import java.util.List;


@FeignClient(name="examserver",fallbackFactory = ExamProviderBackFactory.class)
public interface ExamProvider  {

    @GetMapping("/getTeacher")
    ServerResponse<Teacher> getTeacher();

    @GetMapping("/exam/teaCreateExam/{teaId}")
    ServerResponse<ExamCreate> createexam(@PathVariable("teaId") Integer teaId);

    @PutMapping("/exam/save")
    ServerResponse<ExamCreate> saveExam(@RequestBody ExamCreate examCreate);

    @PutMapping("/exam/publish")
    ServerResponse<ExamCreate> publishExam(@RequestBody PublishReq publishReq);

    @GetMapping("/exam/teaGetList/{teaId}")
    ServerResponse<List<ExamCreate>> teaSearchExamList(@PathVariable("teaId") Integer teaId);

    @GetMapping("/exam/stuGetList")
    ServerResponse<List<ExamStu>> stuSearchExamList(@RequestParam(value = "stuId",required = true) Integer stuId,@RequestParam(value = "batchId",required = true) Integer batchId);

    @PostMapping("/exam/stuGetExamDetail")
    ServerResponse<ExamStuRes> stuSearchExam(@RequestBody StuGetReq stuGetReq);

    @GetMapping("/exam/teaGetExamDetail/{examId}")
    ServerResponse<ExamTeaRes> teaSearchExam(@PathVariable("examId") Integer examId);

    @PostMapping("/exam/stuStartTest")
    ServerResponse<ExamCreateStu> stuStartExam(@RequestBody StuGetReq stuGetReq);


    @PutMapping("/exam/stuSubmitTest")
    ServerResponse<ExamStuRes> stuSubmitExam(@RequestBody StuGetReq stuGetReq);
}
