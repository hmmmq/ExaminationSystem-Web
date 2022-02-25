package com.foodie.service;

import com.foodie.dto.User;
import com.foodie.dto.UserT;

public interface LoginService {
//   统一认证登录
     UserT findUser(User user);
}
