package com.foodie.teacher.feignapi;

import com.foodie.dto.*;
import com.foodie.teacher.exception.ItemProviderBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name="itemserver",fallbackFactory = ItemProviderBackFactory.class)
public interface ItemProvider {
    @PostMapping("/item/add")
    ServerResponse<ItemAdd> addItem(@RequestBody ItemAdd item) ;
    @PutMapping("/item/edit/teacher")
    ServerResponse<ItemExam> updateItem(@RequestBody ItemExam itemExam) ;
    @DeleteMapping("/item/delete")
    ServerResponse<ItemDelete> deleteItem(@RequestBody ItemDelete itemDelete) ;
    @PutMapping("/item/edit/student")
    ServerResponse<ItemEditStu> chooseItem(@RequestBody ItemEditStu itemEditStu) ;

}
