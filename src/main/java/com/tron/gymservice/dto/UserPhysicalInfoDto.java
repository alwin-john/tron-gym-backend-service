package com.tron.gymservice.dto;

import com.tron.gymservice.entity.QandA;
import com.tron.gymservice.entity.UserMedicInfo;
import lombok.Data;

import java.util.List;

@Data
public class UserPhysicalInfoDto {
    private long userId;
    private String bloodGroup;
    private int weight;
    private int height;
    private int fitnessPoint;
    private List<String> activities;
    private List<String> exerciseList;
    private UserMedicInfo userMedicInfo;
}
