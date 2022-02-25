package com.foodie.authservice.controller;
import com.foodie.authservice.Authservice;
import com.foodie.dto.UserT;
import com.foodie.dto.UserTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
public class AuthController {
    @Autowired
    Authservice authservice;
    @PostMapping("/auth/createtoken")
    public String createtoken(@NotNull @RequestBody UserT userT){ return authservice.createtoken(userT); }
    @GetMapping("/auth/refreshtoken")
    public Boolean refreshtoken(@NotNull  @RequestParam("key") String key){ return authservice.refreshtoken(key); }
    @PostMapping("/auth/refreshtokenByUserT")
    public boolean refreshtoken(@NotNull UserT userT){ return authservice.refreshtoken(userT); }
    @GetMapping("/auth/gettokenobject")
    public UserT gettokenobject(@NotNull @RequestParam("token") String token){return  authservice.getTokenObject(token);}
    @GetMapping("/auth/checktokenbykey")
    public Boolean checktokenbykey(@NotNull @RequestParam("key") String key,@NotNull @RequestParam("token")String token){return authservice.checkTokenByKey(key,token);}
    @PostMapping("/auth/checktokenbyusert")
    public Boolean checktoken(@NotNull @RequestBody UserTToken userTToken){
        return authservice.checkToken(userTToken.getUserT(),userTToken.getToken());}
    @PostMapping("/auth/getkey")
    public String getkey(@NotNull @RequestBody UserT userT){ return authservice.getkey(userT);}



}
