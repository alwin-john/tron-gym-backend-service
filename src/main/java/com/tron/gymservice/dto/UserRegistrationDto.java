package com.tron.gymservice.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String userName;
    private  String password;
    private String phoneNo;
    private String emailId;
    private String name;
    private String bloodGroup;
    private int weight;
    private int height;
}
