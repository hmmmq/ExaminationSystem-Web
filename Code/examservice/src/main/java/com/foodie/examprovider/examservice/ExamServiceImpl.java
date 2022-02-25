package com.foodie.examprovider.examservice;

import com.foodie.dto.*;
import com.foodie.examprovider.mapper.*;
import com.foodie.pojo.*;
import com.foodie.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    ExamMapper examMapper;

    @Autowired
    ExamCreateMapper examCreateMapper;

    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ChoiceMapper choiceMapper;

    @Autowired
    PublishMapper publishMapper;

    @Autowired
    TestMapper testMapper;


    @Override
    public ServerResponse<ExamCreate> createExam(ExamCreate examCreate) {
        try {
            //mapper的insert操作
            Exam exam = new Exam();
            exam.setTeaid(examCreate.getTeaId());
            exam.setTitle("new test");
            exam.setDuration(90);
            examMapper.insert(exam);
            exam = examMapper.selectByPrimaryKey(exam.getExamid());
            examCreate.setDuration(exam.getDuration());
            examCreate.setTitle(exam.getTitle());
            examCreate.setExamId(exam.getExamid());
            examCreate.setPublishState(exam.getPublishstate());
            examCreate.setCreateTime(String.valueOf(exam.getCreatetime()));
            return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyAdd, examCreate);
        } catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByresponseCodeData(ResponseCode.FailAdd, examCreate);
        }

    }

    @Override
    public ServerResponse<ExamCreate> saveExam(ExamCreate examCreate) {
        if (examCreate == null || examCreate.getExamId() == null)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailUpdate, null);
        examCreateMapper.updateByPrimaryKey(examCreate);
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyUpdate, null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse<ExamCreate> publishExam(PublishReq publishReq) {
        if (publishReq.getBatchids() == null || publishReq.getBatchids().length == 0)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailPublish, null);
        try {
            ExamCreate examCreate = examCreateMapper.selectByPrimaryKey(publishReq.getExamId());
            examCreate.setPublishState(true);
            examCreateMapper.updateByPrimaryKey(examCreate);
            Integer[] batchids = publishReq.getBatchids();
            for (int i = 0; i < batchids.length; i++) {
                Publish publish = new Publish();
                publish.setExamid(publishReq.getExamId());
                publish.setBatchid(batchids[i]);
                publishMapper.insert(publish);
            }
        } catch (Exception e) {
            return ServerResponse.createByresponseCodeData(ResponseCode.FailUpdate, null);
        }
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullPublish, null);
    }

    @Override
    public ServerResponse<List<ExamCreate>> teaSearchExamList(Integer teaId) {
        if (teaId == null)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet, null);
        List<ExamCreate> examCreateList = examCreateMapper.selectByTeaId(teaId);
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyGet, examCreateList);
    }

    @Override
    public ServerResponse<List<ExamStu>> stuSearchExamList(Integer stuId,Integer batchId) {
        if (batchId == null || stuId == null)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet, null);
        List<ExamStu> examStuList = new ArrayList();
        List<ExamCreate> examCreateList = examCreateMapper.selectPublishExamByBatchId(batchId);
        StuGetReq stuGetReq = new StuGetReq();
        for (ExamCreate examCreate : examCreateList) {
            ExamStu examStu = new ExamStu();
            stuGetReq.setStuid(stuId);
            stuGetReq.setExamid(examCreate.getExamId());
            Test test = testMapper.selectByStuIdAndExamId(stuGetReq);
            if(test!=null){examStu.setStuId(stuId);
                examStu.setSubmitState(test.getSubmitstate());
                examStu.setExamCreate(examCreate);
                examStuList.add(examStu);}

        }
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyGet,examStuList);
    }

    @Override
    public ServerResponse<ExamStuRes> stuSearchExam(StuGetReq stuGetReq) {
        if (stuGetReq == null || stuGetReq.getStuid() == null || stuGetReq.getExamid() == null)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet, null);
        ExamStuRes examStuRes = new ExamStuRes();
        List<ItemExamStu> itemExamStuList = new ArrayList<>();
        List<Item> itemList = itemMapper.selectByExamId(stuGetReq.getExamid());
        try {
            for (Item item : itemList) {
                ItemExamStu itemExamStu = new ItemExamStu();
                ItemExam itemExam = new ItemExam();
                ItemEditStu itemEditStu = new ItemEditStu();
                itemExam.setItemId(item.getItemid());
                itemExam.setExamId(item.getExamid());
                itemExam.setType(item.getType());
                itemExam.setContent(item.getContent());
                itemExam.setA(item.getA());
                itemExam.setB(item.getB());
                itemExam.setC(item.getC());
                itemExam.setD(item.getD());
                itemExam.setRightAnswer(item.getRightanswer());
                itemExam.setPoint(item.getPoint());
                Choice choice = choiceMapper.selectByStuIdAndExamIdAndItemId(stuGetReq.getStuid(),stuGetReq.getExamid(),item.getItemid());
                itemEditStu.setItemId(choice.getItemid());
                itemEditStu.setStuId(choice.getStuid());
                itemEditStu.setStuAnswer(choice.getStuanswer());
                itemEditStu.setCorrect(choice.getIscorrect());
                itemEditStu.setStuPoint(choice.getStupoint());
                itemExamStu.setItemExam(itemExam);
                itemExamStu.setItemEditStu(itemEditStu);
                itemExamStuList.add(itemExamStu);
            }
        } catch (Exception e) {
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet,examStuRes);
        }
        Test test = testMapper.selectByStuIdAndExamId(stuGetReq);
        examStuRes.setTotoalmark(test.getTotalmark());
        examStuRes.setItemExamStus(itemExamStuList);
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyGet,examStuRes);
    }
    @Override
    public ServerResponse<ExamTeaRes> teaSearchExam(Integer examId) {
        if (examId == null) {
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet, null);
        }
        ExamTeaRes examTeaRes = new ExamTeaRes();
        String publishTime = publishMapper.selectPublishTimeByExamId(examId);
        Integer[] batchids = publishMapper.selectBatchIdsTimeByExamId(examId);
        List<Item> itemList = itemMapper.selectByExamId(examId);
        List<ItemExam> itemExamList = new ArrayList<>();
        for (Item item : itemList) {
            ItemExam itemExam = new ItemExam();
            itemExam.setItemId(item.getItemid());
            itemExam.setExamId(item.getExamid());
            itemExam.setType(item.getType());
            itemExam.setContent(item.getContent());
            itemExam.setA(item.getA());
            itemExam.setB(item.getB());
            itemExam.setC(item.getC());
            itemExam.setD(item.getD());
            itemExam.setRightAnswer(item.getRightanswer());
            itemExam.setPoint(item.getPoint());
            itemExamList.add(itemExam);
        }
        ExamCreate examCreate = examCreateMapper.selectByPrimaryKey(examId);
        examTeaRes.setExamCreate(examCreate);
        examTeaRes.setItemExams(itemExamList);
        examTeaRes.setPublishTime(publishTime);
        examTeaRes.setBatchids(batchids);
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyGet,examTeaRes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse<ExamCreateStu> stuStartExam(StuGetReq stuGetReq) {
        if (stuGetReq == null || stuGetReq.getStuid() == null || stuGetReq.getExamid() == null)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet, null);
        ExamCreateStu examCreateStu = new ExamCreateStu();
        examCreateStu.setSubmitstate(false);
        List<ItemExamStu> itemExamStuList = new ArrayList<>();
        List<Item> itemList = itemMapper.selectByExamId(stuGetReq.getExamid());
        for (Item item : itemList) {
            ItemExamStu itemExamStu = new ItemExamStu();
            ItemExam itemExam = new ItemExam();
            itemExam.setItemId(item.getItemid());
            itemExam.setExamId(item.getExamid());
            itemExam.setType(item.getType());
            itemExam.setContent(item.getContent());
            itemExam.setA(item.getA());
            itemExam.setB(item.getB());
            itemExam.setC(item.getC());
            itemExam.setD(item.getD());
            itemExam.setRightAnswer(item.getRightanswer());
            itemExam.setPoint(item.getPoint());
            Choice choice = new Choice();
            choice.setStuid(stuGetReq.getStuid());
            choice.setExamid(stuGetReq.getExamid());
            choice.setItemid(item.getItemid());
            if(choiceMapper.selectByStuIdAndExamIdAndItemId(choice.getStuid(),choice.getExamid(),choice.getItemid())==null)
            choiceMapper.insert(choice);
            ItemEditStu itemEditStu = new ItemEditStu();
            choice = choiceMapper.selectByStuIdAndExamIdAndItemId(stuGetReq.getStuid(),stuGetReq.getExamid(),item.getItemid());
            itemEditStu.setStuId(choice.getStuid());
            itemEditStu.setItemId(choice.getItemid());
            itemEditStu.setStuAnswer(choice.getStuanswer());
            itemEditStu.setCorrect(choice.getIscorrect());
            itemEditStu.setStuPoint(choice.getStupoint());
            itemExamStu.setItemExam(itemExam);
            itemExamStu.setItemEditStu(itemEditStu);
            itemExamStuList.add(itemExamStu);
        }
        examCreateStu.setItemExamStus(itemExamStuList);
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyGet, examCreateStu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ServerResponse<ExamStuRes> stuSubmitExam(StuGetReq stuGetReq) {
        if (stuGetReq == null || stuGetReq.getStuid() == null || stuGetReq.getExamid() == null)
            return ServerResponse.createByresponseCodeData(ResponseCode.FailGet, null);
        ExamStuRes examStuRes = new ExamStuRes();
        Test test = testMapper.selectByStuIdAndExamId(stuGetReq);
        test.setSubmitstate(true);
        testMapper.update(test);
        return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyGet,examStuRes);
    }


}
