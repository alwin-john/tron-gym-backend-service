package com.tron.gymservice.services;

import com.tron.gymservice.dto.UserDeleteDto;
import com.tron.gymservice.dto.UserPhysicalInfoDto;
import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.entity.UserMasterInfo;
import com.tron.gymservice.entity.UserPhysicalInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserMasterInfoService {
    public List<UserMasterInfo> findAll();

    public UserMasterInfo updatePhysicalInfo(UserPhysicalInfoDto userPhysicalInfoDto);

    public UserMasterInfo save(UserRegistrationDto userRegistrationDto, String role);

    public boolean delete(UserDeleteDto userDeleteDto);
}
