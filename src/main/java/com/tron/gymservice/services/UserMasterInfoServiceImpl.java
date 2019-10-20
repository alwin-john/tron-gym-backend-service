package com.tron.gymservice.services;

import com.tron.gymservice.dto.UserDeleteDto;
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
import java.util.stream.Collectors;

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
    public UserMasterInfo updatePhysicalInfo(UserPhysicalInfoDto userPhysicalInfoDto) {
        String activityString = Optional.ofNullable(userPhysicalInfoDto.getActivities())
                .map(a->a.stream().collect(Collectors.joining(","))).orElse("");
        Optional<UserMasterInfo> userMasterInfo=userMasterInfoRepository
                .findById(userPhysicalInfoDto.getUserId());
        userMasterInfo.ifPresent(u -> {
            u.getUserPhysicalInfo().setHeight(userPhysicalInfoDto.getHeight());
            u.getUserPhysicalInfo().setWeight(userPhysicalInfoDto.getWeight());
            u.getUserPhysicalInfo().setBloodGroup(userPhysicalInfoDto.getBloodGroup());
            u.getUserPhysicalInfo().setActivities(activityString);
        });
        userMasterInfo.orElseThrow(MasterInfoNotFoundException::new);
        return userMasterInfoRepository.save(userMasterInfo.get());
    }

    @Override
    @Transactional
    public UserMasterInfo save(UserRegistrationDto userRegistrationDto) {
        UserMasterInfo userMasterInfo=new UserMasterInfo();
        UserPhysicalInfo userPhysicalInfo=new UserPhysicalInfo();
        userMasterInfo.setUserName(userRegistrationDto.getUserName());
        userMasterInfo.setPassword(userRegistrationDto.getPassword());
        userMasterInfo.setRoleId(1);
        userMasterInfo.setPhoneNo(userRegistrationDto.getPhoneNo());
        userMasterInfo.setEmailId(userRegistrationDto.getEmailId());
        userMasterInfo.setUserPhysicalInfo(userPhysicalInfo);
        return userMasterInfoRepository.save(userMasterInfo);
    }

    @Override
    public boolean delete(UserDeleteDto userDeleteDto) {
        Optional<UserMasterInfo> userMasterInfo=userMasterInfoRepository
                .findById(userDeleteDto.getId());
        userMasterInfo.orElseThrow(MasterInfoNotFoundException::new);
        return true;
    }

}
