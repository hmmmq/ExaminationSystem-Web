package com.foodie.itemprovider.examproviderapi;

import com.foodie.dto.*;
import com.foodie.pojo.Teacher;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: fuke
 * @Date: 2021/6/9
 */
public interface ItemProviderAPI {
    @PostMapping("/item/add")
    public ServerResponse<ItemAdd> addItem(@RequestBody ItemAdd item) ;
    @PutMapping("/item/edit/teacher")
    public ServerResponse<ItemExam> updateItem(@RequestBody ItemExam itemExam) ;
    @DeleteMapping("/item/delete")
    public ServerResponse<ItemDelete> deleteItem(@RequestBody ItemDelete itemDelete) ;
    @PutMapping("/item/edit/student")
    public ServerResponse<ItemEditStu> chooseItem(@RequestBody ItemEditStu itemEditStu) ;
}
