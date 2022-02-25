package com.foodie.authservice;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.foodie.dto.UserT;
import com.foodie.pojo.Student;
import com.foodie.pojo.Teacher;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class Authservice {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private String key="";
    private  Map<String,Object> claims=new DefaultClaims();

//    前提：没有找到token,但是检查后数据库有该usert，新建一个token返回
    public String createtoken( UserT userT){
        getkey(userT);
        String  tokenredis = JwtUtils.geneJsonWebToken(userT);
        stringRedisTemplate.opsForValue().set(key, tokenredis, Duration.ofDays(7));
        return tokenredis;
    }

    public Boolean refreshtoken(String key){
     return stringRedisTemplate.expire(key, 7, TimeUnit.DAYS);
    }

    /* 前提：已知token是有的,也已经延期，要检查是否是该用户本人
    * */
    public Boolean checkToken(UserT userT,String token){
        getkey(userT);
        String tokenredis = stringRedisTemplate.opsForValue().get(key);
        if (token==tokenredis)
            return true;
        return false;
    }

    public Boolean checkTokenByKey(String key,String token){
         String tokenredis = stringRedisTemplate.opsForValue().get(key);
         if (null==tokenredis)
             return false;
         if (token.equals(tokenredis))
         return true;

        return false;
    }

    /*
     * 1.获取token,
     * 2.通过token获得对象。
     * */
    public UserT getTokenObject(String token) {
        Claims claims=JwtUtils.checkJWT(token);
        return getUserT(claims);
    }

    public String getkey(UserT userT) {
        //1.如果是老师，key=usertype+teacherid,
        //2.如果是学生，key=usertype+studentid
        if (userT.getUserType()==1)
            key=""+ userT.getUserType()+ userT.getStudent().getStuid();
        else
            key=""+ userT.getUserType()+ userT.getTeacher().getTeaid();
        return key;
    }

    private UserT getUserT(Map<String, Object> claims) {
        Object student = claims.get("student");
        Object teacher = claims.get("teacher");
        Object type = claims.get("type");
        Student student1 = new Student();
        Teacher teacher1 = new Teacher();
        Integer type1 =null;
        student1 = JSON.parseObject(JSON.toJSONString(student), new TypeReference<Student>() { });
        teacher1 = JSON.parseObject(JSON.toJSONString(teacher), new TypeReference<Teacher>() { });
        type1 = JSON.parseObject(JSON.toJSONString(type), new TypeReference<Integer>() { });
        UserT userT1=new UserT(type1,student1,teacher1);
        return userT1;
    }

    public Boolean refreshtoken(UserT userT) {
         getkey(userT);
         refreshtoken(key);
         return true;
    }
}
