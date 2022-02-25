package com.foodie.loginconsumer.feignclient;

import com.foodie.dto.ServerResponse;
import com.foodie.dto.User;
import com.foodie.dto.UserT;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name = "userservice",fallback = UserServiceFallBack.class)
public interface UserService {
    @PostMapping("/login")
    UserT login(@RequestBody User user);  //get:@RequestParam Integer loginId, @RequestParam String password
    @PostMapping("/register/student")
    ServerResponse registerStudent(@RequestBody Student student);

    @PostMapping("/register/teacher")
    ServerResponse registerTeacher(@RequestBody Teacher teacher);
}
