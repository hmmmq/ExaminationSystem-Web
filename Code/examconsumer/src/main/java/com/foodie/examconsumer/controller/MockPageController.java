package com.foodie.examconsumer.controller;

import com.foodie.dto.*;
import com.foodie.pojo.Exam;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.sql.Date;
import java.util.ArrayList;

/**
 * 专门用来跳转页面，返回modelandview的。
 */
@Controller
public class MockPageController {
    private Teacher teacher=new Teacher();
    private Student student=new Student();
    private ArrayList<ExamCreate> examCreates =new ArrayList<>();
    private ArrayList<ItemExam> itemExams=new ArrayList<>();
    private ArrayList<ItemExam> itemExams2=new ArrayList<>();
    private ArrayList<ItemExamStu> itemExamStus=new ArrayList<>();
    private ArrayList<ItemExamStu> itemExamStus2=new ArrayList<>();
    private Integer examid=5;
    private Integer examid2=25;
    private Integer totoalmark=90;
    private ExamCreate examCreate=new ExamCreate();
    private ExamCreate examCreate2=new ExamCreate();
    private String publishtime="2021-6-20";
    private Integer[] batchids={1,2,3,4,5};
    private ExamTeaRes examTeaRes=new ExamTeaRes();
    private StuGetReq stuReq=new StuGetReq();
    private Integer stuid=2;
    private ExamCreateStu examCreateStu=new ExamCreateStu();
    private ExamStuRes examStuRes=new ExamStuRes();
    private ArrayList<ExamStu> examStus=new ArrayList<>();



    {
        //模拟学生查看未做的试题
        //发布测试1，学生没有写
        for (int i=20;i<30;i++){
            ExamStu examStu=new ExamStu();
            ExamCreate examCreate=new ExamCreate();
            examCreate.setCreateTime("2021-5-08");
            examCreate.setPublishState(true);
            examCreate.setTeaId(1001);
            examCreate.setExamId(i);
            examCreate.setDuration(i+60);
            examCreate.setTitle("test-title"+i);
            examStu.setExamCreate(examCreate);
            examStu.setStuId(stuid);
            examStu.setSubmitState(false);
            examStus.add(examStu);

        }
        //发布测试2，学生写了
        for (int i=30;i<40;i++){
            ExamStu examStu=new ExamStu();
            ExamCreate examCreate=new ExamCreate();
            examCreate.setCreateTime("2021-5-08");
            examCreate.setPublishState(true);
            examCreate.setTeaId(1001);
            examCreate.setExamId(i);
            examCreate.setDuration(i+60);
            examCreate.setTitle("test-title"+i);
            examStu.setExamCreate(examCreate);
            examStu.setStuId(stuid);
            examStu.setSubmitState(true);
            examStus.add(examStu);
        }



        //模拟数据集

        teacher.setName("Delucia");
        teacher.setTeaid(1001);
        student.setName("mary");
        student.setStuid(1);
        student.setAcademy("计算机");
        student.setBatchid(1);
        student.setDegree("本科生");
        student.setMajor("软件工程");
        student.setStartyear(Date.valueOf("2018-9-1"));


        //模拟测试列表，发布，未发布
        for (int i=0;i<10;i++){
            ExamCreate examCreate=new ExamCreate();
            examCreate.setCreateTime("2021-6-09");
            examCreate.setPublishState(false);
            examCreate.setTeaId(1001);
            examCreate.setExamId(i);
            examCreate.setDuration(i+60);
            examCreate.setTitle("test-title"+i);
            examCreates.add(examCreate);
        }
        for (int i=20;i<30;i++){
            ExamCreate examCreate=new ExamCreate();
            examCreate.setCreateTime("2021-5-08");
            examCreate.setPublishState(true);
            examCreate.setTeaId(1001);
            examCreate.setExamId(i);
            examCreate.setDuration(i+60);
            examCreate.setTitle("test-title"+i);
            examCreates.add(examCreate);
        }


//        模拟examid测试详情, 模拟examid试卷的试题，以及学生的答案
        examCreate.setCreateTime("2021-6-11");
        examCreate.setTitle("linux基础");
        examCreate.setExamId(examid);
        examCreate.setDuration(90);
        examCreate.setTeaId(1001);
        examCreate.setPublishState(false);
        examCreate.setTitle("test-title"+examid);
        //学生做完了
        for (int i=0;i<5;i++){
//            学生的答案
            ItemExamStu itemExamStu=new ItemExamStu();
            ItemEditStu itemEditStu=new ItemEditStu();
//            试题
           ItemExam itemExam=new ItemExam();
           itemExam.setExamId(examid);
           itemExam.setPoint(3);
           itemExam.setType(1);
           itemExam.setRightAnswer("a");
           itemExam.setContent("nasoinqwofnewiofe");
           itemExam.setA("aksodnid");
           itemExam.setB("oasjdiojad");
           itemExam.setC("asdnofnio");
           itemExam.setD("aosidoefie");
//            学生的答案
           itemEditStu.setItemId(i);
            itemEditStu.setStuId(stuid);
            itemEditStu.setStuAnswer("b");
            itemEditStu.setCorrect(false);
            itemEditStu.setStuPoint("0");

            itemExamStu.setItemEditStu(itemEditStu);
            itemExamStu.setItemExam(itemExam);
//            添加到数组里
            itemExamStus.add(itemExamStu);

            itemExams.add(itemExam);
        }
        for (int i=0;i<5;i++){
            ItemExamStu itemExamStu=new ItemExamStu();
            ItemEditStu itemEditStu=new ItemEditStu();
            ItemExam itemExam=new ItemExam();
            itemExam.setExamId(examid);
            itemExam.setPoint(5);
            itemExam.setType(2);
            itemExam.setRightAnswer("acd");
            itemExam.setContent("nasoinqwofnewiofe");
            itemExam.setA("aksodnid");
            itemExam.setB("oasjdiojad");
            itemExam.setC("asdnofnio");
            itemExam.setD("aosidoefie");
            itemEditStu.setItemId(i);
            itemEditStu.setStuId(stuid);
            itemEditStu.setStuAnswer("acd");
            itemEditStu.setCorrect(false);
            itemEditStu.setStuPoint("0");

            itemExamStu.setItemEditStu(itemEditStu);
            itemExamStu.setItemExam(itemExam);

            itemExamStus.add(itemExamStu);
            itemExams.add(itemExam);
        }

//       模拟examid2测试详情,模拟exami2试卷的试题，学生点击开始考试出的空白卷。
        examCreate2=new ExamCreate();
        examCreate2.setCreateTime("2021-6-11");
        examCreate2.setTitle("操作系统");
        examCreate2.setExamId(examid2);
        examCreate2.setDuration(60);
        examCreate2.setTeaId(1001);
        examCreate2.setPublishState(true);
        examCreate2.setTitle("test-title"+examid2);
        for (int i=0;i<5;i++){
            ItemExamStu itemExamStu=new ItemExamStu();
            ItemEditStu itemEditStu=new ItemEditStu();

            ItemExam itemExam=new ItemExam();
            itemExam.setExamId(examid2);
            itemExam.setPoint(3);
            itemExam.setType(1);
            itemExam.setRightAnswer("a");
            itemExam.setContent("ksncownqwnfoenmsamc");
            itemExam.setA("aksodnid");
            itemExam.setB("oasjdiojad");
            itemExam.setC("asdnofnio");
            itemExam.setD("aosidoefie");
            //  学生的答案
            itemEditStu.setItemId(i);
            itemEditStu.setStuId(stuid);
            itemExamStu.setItemEditStu(itemEditStu);
            itemEditStu.setStuAnswer("a");
            itemEditStu.setCorrect(true);
            itemEditStu.setStuPoint("7");

            itemExamStu.setItemExam(itemExam);
//            添加到数组里
            itemExamStus2.add(itemExamStu);
            itemExams2.add(itemExam);
        }
        for (int i=0;i<5;i++){
            ItemExamStu itemExamStu=new ItemExamStu();
            ItemEditStu itemEditStu=new ItemEditStu();

            ItemExam itemExam=new ItemExam();
            itemExam.setExamId(examid2);
            itemExam.setPoint(5);
            itemExam.setType(2);
            itemExam.setRightAnswer("acd");
            itemExam.setContent("ksncownqwnfoenmsamc");
            itemExam.setA("aksodnid");
            itemExam.setB("oasjdiojad");
            itemExam.setC("asdnofnio");
            itemExam.setD("aosidoefie");
            //  学生的答案
            itemEditStu.setItemId(i);
            itemEditStu.setStuId(stuid);
            itemExamStu.setItemEditStu(itemEditStu);
            itemEditStu.setStuAnswer("b");
            itemEditStu.setCorrect(false);
            itemEditStu.setStuPoint("4");
            itemExamStu.setItemExam(itemExam);
//            添加到数组里
            itemExamStus2.add(itemExamStu);
            itemExams2.add(itemExam);
        }


        examTeaRes.setBatchids(batchids);
        examTeaRes.setExamCreate(examCreate);
        examTeaRes.setItemExams(itemExams);
        examTeaRes.setPublishTime(publishtime);

        stuReq.setExamid(examid);
        stuReq.setStuid(stuid);

        examCreateStu.setItemExamStus(itemExamStus2);
        examCreateStu.setSubmitstate(false);

        examStuRes.setItemExamStus(itemExamStus);
        examStuRes.setTotoalmark(totoalmark);


    }

    @GetMapping("/mock/getteacher")
    ModelAndView mockgetteacher(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("teacher");
        /*
        * 模拟数据,teacher这个数据可以从redis里查。需要某个key值，跟session一样。
        * 也可以通过ModelAndView获取。
        * 还可以通过session获取。
        * 最笨的方法就是mysql通过传过来的id再查一遍。完全不可以这样。这样会设计到传参
        * */
        /*
         * 模拟数据.
         * examcontroller里的方法也可以调用。
         */

//        ServerResponse examgetlistteacher = examController.examgetlistteacher(teacher.getTeaid());

//        ArrayList<ExamCreate> data = (ArrayList<ExamCreate>) examgetlistteacher.getData();

        /**
         * 加数据
         */
        modelAndView.addObject("teacher",teacher);
        modelAndView.addObject("examcreatelist", examCreates);
        return modelAndView;


    }

    @GetMapping("/mock/getteacherpaperdetailpub")
    ModelAndView mockgetteacherpaperdetailpub(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("teacherpaperdetailpub");
        /*
         * examid需要前端给
         * */
//        ServerResponse examgetteacher = examController.examgetteacher(examid);
//        ExamTeaRes examTeaRes = (ExamTeaRes) examgetteacher.getData();

        modelAndView.addObject("examteares",examTeaRes);
        return modelAndView;
    }


    @GetMapping("/mock/getteacherpaperdetailunpub")
    ModelAndView mockgetteacherpaperdetailunpub(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("teacherpaperdetailunpub");
        /*
         * examid需要前端给
         * */
//        ServerResponse examgetteacher = examController.examgetteacher(examid);
//        ExamTeaRes examTeaRes = (ExamTeaRes) examgetteacher.getData();

        modelAndView.addObject("examteares",examTeaRes);
        return modelAndView;
    }

    @GetMapping("/mock/getstudent")
    ModelAndView mockgetstudent(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("student");
        /*
        * student 从redis取
        *  examstus  需要batchid,stuid
        * */
        //        ServerResponse examgetliststudent = examController.examgetliststudent(student.getBatchid(), student.getStuid());
//        ArrayList<ExamStu> examStus = (ArrayList<ExamStu>) examgetliststudent.getData();

        modelAndView.addObject("student",student);
        modelAndView.addObject("examstus",examStus);
        return modelAndView;



    }

    @GetMapping("/mock/getpaperground")
    ModelAndView mockgetpaperground(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("paperground");
        /*
        examstus
        需要batchid,stuid
        * */
//        ServerResponse examgetliststudent = examController.examgetliststudent(student.getBatchid(), student.getStuid());
//        ArrayList<ExamStu> examStus = (ArrayList<ExamStu>) examgetliststudent.getData();

        modelAndView.addObject("examstus",examStus);
        return modelAndView;
    }

    @GetMapping("/mock/getpaper")
    ModelAndView mockgetpaper(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("paper");

        /**
         * stuReq需要前端给
         * examCreate 根据examid查
         * examCreateStu 根据examid,stuid查
         */

        modelAndView.addObject("examcreatestu",examCreateStu);
        modelAndView.addObject("examcreate",examCreate);

        return modelAndView;
    }

    @GetMapping("/mock/getpaperdetails")
    ModelAndView mockgetpaperdetails(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("paperdetails");
//        stuReq前端传参
//        examCreate从session中取
//        ServerResponse examgetstudent = examController.examgetstudent(stuReq);
//        ExamStuRes examStuRes= (ExamStuRes) examgetstudent.getData();

        if (null==(Integer)examStuRes.getTotoalmark()){
            modelAndView.addObject("examstures",null);
        }else{
            modelAndView.addObject("examstures",examStuRes);
            modelAndView.addObject("examname",examCreate.getTitle());
        }



        return modelAndView;
    }

    @GetMapping("/mock/getcreatepaper")
    ModelAndView mockgetcreatepaper(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("createpaper");
        /*
        * 参数需要teaid或者teacher
        * */
        ExamCreate examCreate=new ExamCreate();
        examCreate.setTeaId(teacher.getTeaid());
        examCreate.setExamId(1);
        examCreate.setCreateTime("2021-6-10");
//        examCreate.setPublishState(false);
//        ServerResponse examcreate = examController.examcreate(examCreate);
//        examCreate   = (ExamCreate) examcreate.getData();
        modelAndView.addObject("examcreate",examCreate);
        return modelAndView;

    }






}
