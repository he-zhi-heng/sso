package com.he.pojo.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginUserVO implements Serializable{
    String username;
    String password;
}
