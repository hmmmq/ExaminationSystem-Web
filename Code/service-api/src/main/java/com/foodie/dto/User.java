package com.foodie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: czely
 * @Date: 2021/6/5 16:06
 * @Description: 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //用户id
    private Integer loginId;
    //用户密码
    private String password;

}

