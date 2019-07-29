package com.tron.gymservice.services;

import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.entity.UserMasterInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMasterInfoService{
    public List<UserMasterInfo> findAll();
    public UserMasterInfo save(UserRegistrationDto userRegistrationDto);
}
