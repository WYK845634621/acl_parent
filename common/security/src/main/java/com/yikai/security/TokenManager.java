package com.yikai.security;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Number K1171305
 * @Date 2020/12/2 14:52
 */
@Component
public class TokenManager {

    //token有效时长
    private long expiredTime = 24*60*60*1000;

    //编码密匙
    private String signKey = "123456";

    //使用jwt生成token
    public String generate(String username){
        String token = Jwts.builder().setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiredTime))
                .signWith(SignatureAlgorithm.HS512, signKey).compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    //根据token获取username
    public String getUsername(String token){
        String username = Jwts.parser().setSigningKey(signKey).parseClaimsJws(token).getBody().getSubject();
        return username;
    }

    //实际上不传就行  这里的删除只是意思一下
    public void deleteToken(String token){

    }


}
