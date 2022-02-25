package com.foodie.teacher.feignapi;

import com.foodie.dto.UserT;
import com.foodie.dto.UserTToken;
import com.foodie.teacher.exception.AuthServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;


@FeignClient(name = "authenservice",fallback = AuthServiceFallBack.class)
@Component
public interface AuthService {
    @PostMapping("/auth/createtoken")
    public String createtoken(@NotNull @RequestBody UserT userT);
    @GetMapping("/auth/refreshtoken")
    public Boolean refreshtoken(@NotNull  @RequestParam("key") String key);
    @PostMapping("/auth/refreshtokenByUserT")
    public boolean refreshtoken(@NotNull UserT userT);
    @GetMapping("/auth/gettokenobject")
    public UserT gettokenobject(@NotNull @RequestParam("token") String token);
    @GetMapping("/auth/checktokenbykey")
    public Boolean checktokenbykey(@NotNull @RequestParam("key") String key,@NotNull @RequestParam("token")String token);
    @PostMapping("/auth/checktokenbyusert")
    public Boolean checktoken(@NotNull @RequestBody UserTToken userTToken);
    @PostMapping("/auth/getkey")
    public String getkey(@NotNull @RequestBody UserT userT);
}
