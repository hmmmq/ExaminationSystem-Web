package com.foodie.authservice;

import com.foodie.dto.UserT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * jwt工具类
 */
public class JwtUtils {

    public static final String SUBJECT = "foodiesquad";

    public static final long EXPIRE = 1000*60*60*24*7;  //过期时间，毫秒，一周
    //秘钥
    public static final  String APPSECRET = "fkjansdieno!";

    /**
     * 生成jwt
     * @param usert
     * @return
     */
    public static String geneJsonWebToken(UserT usert){

        if(usert == null ||(usert.getStudent()==null&&usert.getTeacher()==null)){
            return null;
        }
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("type",usert.getUserType())
                .claim("student",usert.getStudent())
                .claim("teacher",usert.getTeacher())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
        return token;
    }


    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJWT(String token ){

        try{
            final Claims claims =  Jwts.parser().setSigningKey(APPSECRET).
                    parseClaimsJws(token).getBody();
            return  claims;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }



}