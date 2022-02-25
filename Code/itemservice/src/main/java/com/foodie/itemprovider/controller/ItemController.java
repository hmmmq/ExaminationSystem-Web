package com.foodie.itemprovider.controller;

import com.foodie.dto.*;
import com.foodie.itemprovider.examproviderapi.ItemProviderAPI;
import com.foodie.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
/**
 * @Author: fuke
 * @Date: 2021/6/9
 */
@RestController
@RefreshScope
public class ItemController implements ItemProviderAPI {

    @Autowired
    private ItemService itemService;

    @Value("${server.port}")
    String port;

    @PostMapping("/item/add")
    public ServerResponse<ItemAdd> addItem( @RequestBody ItemAdd item) {
        return itemService.addItem(item);
    }

    @Override
    @PutMapping("/item/edit/teacher")
    public ServerResponse<ItemExam> updateItem(@RequestBody ItemExam itemExam) {
        return itemService.updateItem(itemExam);
    }

    @Override
    @DeleteMapping("/item/delete")
    public ServerResponse<ItemDelete> deleteItem(@RequestBody ItemDelete itemDelete) {
        return itemService.deleteItem(itemDelete);
    }


    @Override
    @PutMapping("/item/edit/student")
    public ServerResponse<ItemEditStu> chooseItem(@RequestBody ItemEditStu itemEditStu) {
        return itemService.chooseItem(itemEditStu);
    }
}
