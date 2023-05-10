package com.he.ssogateway.config;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 * @author heomoren
 */
public class MyMD5PasswordEncoder implements PasswordEncoder {
    /**
     * 加密
     * @param rawPassword  明文字符串
     * @return
     */
    @Override
    public String encode(CharSequence rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            return toHexString(digest.digest(rawPassword.toString().getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 密码校验
     * @param rawPassword 明文，页面收集密码
     * @param encodedPassword 密文 ，数据库中存放密码
     * @return
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(encode(rawPassword));
    }

    /**
     * @param tmp 转16进制字节数组
     * @return 饭回16进制字符串
     */
    private String toHexString(byte [] tmp){
        StringBuilder builder = new StringBuilder();
        for (byte b :tmp){
            String s = Integer.toHexString(b & 0xFF);
            if (s.length()==1){
                builder.append("0");
            }
            builder.append(s);
        }
        return builder.toString();
    }
}
