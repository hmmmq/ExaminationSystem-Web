package com.foodie.service;
import com.foodie.dto.*;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ExamService {
//  教师创建测试
ServerResponse<ExamCreate> createExam(ExamCreate examCreate);
//  教师保存测试
ServerResponse<ExamCreate> saveExam(ExamCreate examCreate);
//  教师发布测试
ServerResponse<ExamCreate> publishExam(PublishReq publishReq);
//  教师查看测试列表
ServerResponse<List<ExamCreate>> teaSearchExamList(Integer teaId);
//  学生查看测试列表
ServerResponse<List<ExamStu>>stuSearchExamList(Integer stuId,Integer batchId);
//  学生查看测试详情
ServerResponse<ExamStuRes> stuSearchExam(StuGetReq stuGetReq);
//  教师查看测试详情
ServerResponse<ExamTeaRes> teaSearchExam(Integer examId);
//  学生开始测试
ServerResponse<ExamCreateStu> stuStartExam(StuGetReq stuGetReq);
//  学生提交测试
ServerResponse<ExamStuRes>  stuSubmitExam(StuGetReq stuGetReq);
}
