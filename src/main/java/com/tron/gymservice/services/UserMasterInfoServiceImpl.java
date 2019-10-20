package com.tron.gymservice.services;

import com.tron.gymservice.dto.UserPhysicalInfoDto;
import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.entity.UserMasterInfo;
import com.tron.gymservice.entity.UserPhysicalInfo;
import com.tron.gymservice.exceptions.MasterInfoNotFoundException;
import com.tron.gymservice.repository.UserMasterInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserMasterInfoServiceImpl implements UserMasterInfoService {

    @Autowired
    private UserMasterInfoRepository userMasterInfoRepository;

    @Override
    public List<UserMasterInfo> findAll() {
        return userMasterInfoRepository.findAll();
    }

    @Override
    public UserMasterInfo updatePhysicalInfo(long masterId,UserPhysicalInfoDto userPhysicalInfoDto) {
        String activityString = Optional.ofNullable(userPhysicalInfoDto.getActivities())
                .map(a->a.stream().reduce("",(p,e)->p+","+e)).orElse("");
        Optional<UserMasterInfo> userMasterInfo=userMasterInfoRepository.findById(masterId);
        userMasterInfo.ifPresent(u -> {
            u.getUserPhysicalInfo().setActivities(activityString);
        });
        userMasterInfo.orElseThrow(MasterInfoNotFoundException::new);
        return userMasterInfoRepository.save(userMasterInfo.get());
    }

    @Override
    @Transactional
    public UserMasterInfo save(UserRegistrationDto userRegistrationDto) {
        UserMasterInfo userMasterInfo=new UserMasterInfo();
        UserPhysicalInfo userPhysicalInfo =new UserPhysicalInfo();
       // userPhysicalInfo.setName(userRegistrationDto.getName());
        userPhysicalInfo.setBloodGroup(userRegistrationDto.getBloodGroup());
        userPhysicalInfo.setHeight(userRegistrationDto.getHeight());
        userPhysicalInfo.setWeight(userRegistrationDto.getWeight());
        //
        userMasterInfo.setUserName(userRegistrationDto.getUserName());
        userMasterInfo.setPassword(userRegistrationDto.getPassword());
        userMasterInfo.setRoleId(1);
        userMasterInfo.setPhoneNo(userRegistrationDto.getPhoneNo());
        userMasterInfo.setEmailId(userRegistrationDto.getEmailId());
        return userMasterInfoRepository.save(userMasterInfo);
    }

}
