package com.foodie.loginconsumer.feignclient;

import com.foodie.dto.ServerResponse;
import com.foodie.dto.User;
import com.foodie.dto.UserT;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallBack implements UserService{

    @Override
    public UserT login(User user) {
        return null;
    }

    @Override
    public ServerResponse registerStudent(Student student) {
        return null;
    }

    @Override
    public ServerResponse registerTeacher(Teacher teacher) {
        return null;
    }
}
