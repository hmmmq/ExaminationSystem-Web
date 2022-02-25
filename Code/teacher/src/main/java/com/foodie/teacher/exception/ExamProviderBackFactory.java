package com.foodie.teacher.exception;

import com.foodie.dto.*;
import com.foodie.teacher.feignapi.ExamProvider;
import com.foodie.pojo.Teacher;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExamProviderBackFactory implements FallbackFactory<ExamProvider> {
    @Override
    public ExamProvider create(Throwable throwable) {
        return new ExamProvider() {
            @Override
            public ServerResponse<Teacher> getTeacher()  {
                System.out.println("进入降级，获取错误信息"+throwable);
                return ServerResponse.createByErrorCodeMessage(500,"provider错误"+throwable+"");
            }

            @Override
            public ServerResponse<ExamCreate> createexam(Integer teaid) {
                return null;
            }

            @Override
            public ServerResponse<ExamCreate> saveExam(ExamCreate examCreate) {
                return null;
            }

            @Override
            public ServerResponse<ExamCreate> publishExam(PublishReq publishReq) {
                return null;
            }

            @Override
            public ServerResponse<List<ExamCreate>> teaSearchExamList(Integer teaId) {
                return null;
            }

            @Override
            public ServerResponse<List<ExamStu>> stuSearchExamList(Integer stuId, Integer batchId) {
                return null;
            }

            @Override
            public ServerResponse<ExamStuRes> stuSearchExam(StuGetReq stuGetReq) {
                return null;
            }

            @Override
            public ServerResponse<ExamTeaRes> teaSearchExam(Integer examId) {
                return null;
            }

            @Override
            public ServerResponse<ExamCreateStu> stuStartExam(StuGetReq stuGetReq) {
                return null;
            }

            @Override
            public ServerResponse<ExamStuRes> stuSubmitExam(StuGetReq stuGetReq) {
                return null;
            }
        };
    }
}
