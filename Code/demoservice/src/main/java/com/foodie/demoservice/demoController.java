package com.foodie.demoservice;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;
//微服务对外提供的接口.
@RestController
@RefreshScope
public class demoController implements demoService{
    /* @Autowired
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
    }**/
}
