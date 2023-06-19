package com.he.pojo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginUserDTO implements Serializable{
    String username;
    String password;
}
