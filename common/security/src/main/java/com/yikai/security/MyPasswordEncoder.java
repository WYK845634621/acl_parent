package com.yikai.security;

import com.yikai.utils.util.MD5;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Tips
 * @Author yikai.wang
 * @Number K1171305
 * @Date 2020/12/2 14:48
 */
@Component
public class MyPasswordEncoder implements PasswordEncoder {

    public MyPasswordEncoder(){
        this(-1);
    }
    public MyPasswordEncoder(int len){

    }


    @Override
    public String encode(CharSequence charSequence) {
        return MD5.encrypt(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String pass) {
        return pass.equals(MD5.encrypt(charSequence.toString()));
    }
}
