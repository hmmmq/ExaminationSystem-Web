package com.foodie.examconsumer.controller;

import com.foodie.dto.*;
import com.foodie.examconsumer.feignapi.ExamController;
import com.foodie.examconsumer.feignapi.ItemProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 专门返回GSON数据
 */
@RestController
public class StudentExamController {

    @Autowired
    private ExamController examController;
	@Autowired
    private ItemProvider itemProvider;

    @GetMapping("/exam/getlist/student")
    public ServerResponse examgetliststudent(@RequestParam(value = "stuId", required = true) Integer stuId, @RequestParam(value = "batchId", required = true) Integer batchId) {
        return examController.stuSearchExamList(stuId, batchId);
    }

    @PostMapping("/exam/get/student")
    public ServerResponse examgetstudent(@RequestBody StuGetReq stuGetReq) {
        return examController.stuSearchExam(stuGetReq);
    }

    @PostMapping("/exam/starttest")
    public ServerResponse examstarttest(@RequestBody StuGetReq stuGetReq) {
        return examController.stuStartExam(stuGetReq);
    }

    @PutMapping("/exam/submit")
    public ServerResponse examsubmit(@RequestBody StuGetReq stuGetReq) {
        return examController.stuSubmitExam(stuGetReq);
    }

    @PutMapping("/item/edit/student")
    public ServerResponse<ItemEditStu> chooseItem(ItemEditStu itemEditStu) {
        if (null == itemEditStu)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        if (Integer.parseInt(itemEditStu.getStuPoint()) > 0) itemEditStu.setCorrect(true);
        return itemProvider.chooseItem(itemEditStu);
    }

}

