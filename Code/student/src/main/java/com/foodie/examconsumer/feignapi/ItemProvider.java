package com.foodie.examconsumer.feignapi;

import com.foodie.dto.*;
import com.foodie.examconsumer.exception.ItemProviderBackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "itemserver", fallbackFactory = ItemProviderBackFactory.class)
public interface ItemProvider {
    @PutMapping("/item/edit/student")
    ServerResponse<ItemEditStu> chooseItem(@RequestBody ItemEditStu itemEditStu);
}
