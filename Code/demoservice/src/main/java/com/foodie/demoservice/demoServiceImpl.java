package com.foodie.demoservice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class demoServiceImpl implements demoService{

    /*
    *  @Autowired
    ItemMapper itemMapper;
    @Autowired
    ChoiceMapper choiceMapper;
    * */

    /*
    *    @Override
    *    @Transactional
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
    * */
}
