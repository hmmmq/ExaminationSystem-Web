package com.foodie.teacher.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodie.dto.*;
import com.foodie.service.ExamService;
import com.foodie.service.ItemService;
import com.foodie.teacher.feignapi.AuthService;
import com.foodie.teacher.feignapi.ExamProvider;
import com.foodie.teacher.feignapi.ItemProvider;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 专门返回GSON数据
 */
@RestController
public class ExamController {

    @Autowired
    private ExamProvider examProvider;

    @Autowired
    private ItemProvider itemProvider;

    @PostMapping("/exam/create")
    public ServerResponse examcreate(ExamCreate examCreate){
        if (null == examCreate) {
            return ServerResponse.createByresponseCode(ResponseCode.FailAdd);
        } else {
            ServerResponse<ExamCreate> createexam = examProvider.createexam(examCreate.getTeaId());
            return createexam;
        }
    }

    @PutMapping("/exam/save")
    public ServerResponse examsave(ExamCreate examCreate){
        if (null==examCreate)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        return examProvider.saveExam(examCreate);
    }

    @PutMapping("/exam/publish")
    public ServerResponse exampublish(@RequestBody PublishReq publishReq){
        if (null==publishReq)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        return examProvider.publishExam(publishReq);
    }


    @GetMapping("/exam/getlist/teacher")
    public ServerResponse examgetlistteacher(Integer teaid){
        if (null==teaid)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examProvider.teaSearchExamList(teaid);
    }

    @GetMapping("/exam/get/teacher")
    public ServerResponse examgetteacher(Integer examid){
        if (null==examid)
            return ServerResponse.createByresponseCode(ResponseCode.FailGet);
        return examProvider.teaSearchExam(examid);
    }

    @PutMapping("/item/edit/teacher")
    public ServerResponse updateItem(ItemExam itemExam) {
        if (null==itemExam)
            return ServerResponse.createByresponseCode(ResponseCode.FailUpdate);
        return itemProvider.updateItem(itemExam);
    }

    @PostMapping("/item/add1")
    public List<ServerResponse<ItemAdd>> addItem1(String itemList) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JavaType jt = mapper.getTypeFactory().constructParametricType(ArrayList.class, ItemAdd.class);
        List<ItemAdd> list =  (List<ItemAdd>)mapper.readValue(itemList, jt);
        List<ServerResponse<ItemAdd>> additemlist = new ArrayList<>();
		if (null == list) {
		    additemlist.add(ServerResponse.createByresponseCode(ResponseCode.FailAdd));
            return additemlist;
        }
        for(ItemAdd i:list) {
            additemlist.add(itemProvider.addItem(i));
        }
        return additemlist;
    }

    @PostMapping("/item/add2")
    public ServerResponse addItem2(ItemAdd itemAdd) {
        if (null == itemAdd) {
            return ServerResponse.createByresponseCode(ResponseCode.FailAdd);
        }
        return itemProvider.addItem(itemAdd);
    }


}

