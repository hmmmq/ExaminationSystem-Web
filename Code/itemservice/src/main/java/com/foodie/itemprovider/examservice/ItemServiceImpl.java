package com.foodie.itemprovider.examservice;

import com.foodie.dto.*;
import com.foodie.itemprovider.mapper.ChoiceMapper;
import com.foodie.itemprovider.mapper.ExamMapper;
import com.foodie.itemprovider.mapper.ItemMapper;
import com.foodie.pojo.Choice;
import com.foodie.pojo.Item;
import com.foodie.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @Author: fuke
 * @Date: 2021/6/9
 */
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    ChoiceMapper choiceMapper;
    @Override
    public ServerResponse addItem(ItemAdd itemAdd) {
        try{
            Item item=new Item();
            item.setItemid(null);
            item.setExamid(Integer.parseInt(itemAdd.getExamId()));
            item.setType(itemAdd.getType());
            item.setContent(itemAdd.getContent());
            item.setA(itemAdd.getA());
            item.setB(itemAdd.getB());
            item.setC(itemAdd.getC());
            item.setD(itemAdd.getD());
            item.setRightanswer(itemAdd.getRightAnswer());
            item.setPoint(itemAdd.getPoint());
            int id=itemMapper.insert(item);
            if(id !=0) return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyAdd, itemAdd);
            else     return ServerResponse.createByresponseCodeData(ResponseCode.FailAdd, itemAdd);
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByresponseCodeData(ResponseCode.FailAdd, itemAdd);
        }
    }

    @Override
    public ServerResponse updateItem(ItemExam itemExam) {
        try{
            Item item=new Item();
            item.setItemid(itemExam.getItemId());
            item.setExamid(itemExam.getExamId());
            item.setType(itemExam.getType());
            item.setContent(itemExam.getContent());
            item.setA(itemExam.getA());
            item.setB(itemExam.getB());
            item.setC(itemExam.getC());
            item.setD(itemExam.getD());
            item.setRightanswer(itemExam.getRightAnswer());
            item.setPoint(itemExam.getPoint());
            int id=itemMapper.updateByPrimaryKey(item);
            if(id !=0) return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyUpdate, itemExam);
            else     return ServerResponse.createByresponseCodeData(ResponseCode.FailUpdate, itemExam);
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByresponseCodeData(ResponseCode.FailAdd, itemExam);
        }

    }

    @Override
    public ServerResponse deleteItem(ItemDelete itemDelete) {
        try{
            int id=itemMapper.deleteByPrimaryKey(itemDelete.getItemId());
            if(id !=0) return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyUpdate, itemDelete);
            else     return ServerResponse.createByresponseCodeData(ResponseCode.FailUpdate, itemDelete);
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByresponseCodeData(ResponseCode.FailAdd, itemDelete);
        }
    }

    @Override
    public ServerResponse chooseItem(ItemEditStu itemEditStu) {
        try{
            Choice choice=new Choice();
            choice.setItemid(itemEditStu.getItemId());
            choice.setStuid(itemEditStu.getStuId());
            choice.setStuanswer(itemEditStu.getStuAnswer());
            choice.setIscorrect(itemEditStu.isCorrect());
            choice.setStupoint(itemEditStu.getStuPoint());
            int id=choiceMapper.update(choice);
            if(id !=0) return ServerResponse.createByresponseCodeData(ResponseCode.SuccessfullyUpdate, itemEditStu);
            else     return ServerResponse.createByresponseCodeData(ResponseCode.FailUpdate, itemEditStu);
        }catch (Exception e) {
            e.printStackTrace();
            return ServerResponse.createByresponseCodeData(ResponseCode.FailAdd, itemEditStu);
        }
    }
}
