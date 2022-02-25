package com.foodie.examconsumer.exception;

import com.foodie.dto.*;
import com.foodie.examconsumer.feignapi.ExamController;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ExamFallBack implements ExamController {

    @Override
    public ServerResponse<List<ExamStu>> stuSearchExamList(Integer stuId, Integer batchId) {
        return null;
    }

    @Override
    public ServerResponse<ExamStuRes> stuSearchExam(StuGetReq stuGetReq) {
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

}
