package com.tron.gymservice.repository;

import com.tron.gymservice.entity.UserMasterInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMasterInfoRepository extends JpaRepository<UserMasterInfo,Long> {
    List<UserMasterInfo> findAll();
    UserMasterInfo findByUserName(String userName);
    void delete(UserMasterInfo userMasterInfo);
    UserMasterInfo save(UserMasterInfo userMasterInfo);
}
