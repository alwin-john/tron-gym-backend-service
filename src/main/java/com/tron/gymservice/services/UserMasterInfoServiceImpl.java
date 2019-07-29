package com.tron.gymservice.services;

import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.entity.ClientEntity;
import com.tron.gymservice.entity.UserMasterInfo;
import com.tron.gymservice.repository.UserMasterInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserMasterInfoServiceImpl implements UserMasterInfoService {

    @Autowired
    private UserMasterInfoRepository userMasterInfoRepository;

    @Override
    public List<UserMasterInfo> findAll() {
        return userMasterInfoRepository.findAll();
    }

    @Override
    @Transactional
    public UserMasterInfo save(UserRegistrationDto userRegistrationDto) {
        UserMasterInfo userMasterInfo=new UserMasterInfo();
        ClientEntity clientEntity=new ClientEntity();
        clientEntity.setName(userRegistrationDto.getName());
        clientEntity.setBloodGroup(userRegistrationDto.getBloodGroup());
        clientEntity.setHeight(userRegistrationDto.getHeight());
        clientEntity.setWeight(userRegistrationDto.getWeight());
        userMasterInfo.setClientInfo(clientEntity);
        //
        userMasterInfo.setUserName(userRegistrationDto.getUserName());
        userMasterInfo.setPassword(userRegistrationDto.getPassword());
        userMasterInfo.setRoleId(1);
        userMasterInfo.setPhoneNo(userRegistrationDto.getPhoneNo());
        userMasterInfo.setEmailId(userRegistrationDto.getEmailId());
        return userMasterInfoRepository.save(userMasterInfo);
    }

}
