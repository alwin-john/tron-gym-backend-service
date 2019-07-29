package com.tron.gymservice.repository;

import com.tron.gymservice.entity.UserMasterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMasterInfoRepository extends JpaRepository<UserMasterInfo,Long> {
    @Override
    List<UserMasterInfo> findAll();
    UserMasterInfo findByUserName(String userName);
    UserMasterInfo save(UserMasterInfo userMasterInfo);
}
