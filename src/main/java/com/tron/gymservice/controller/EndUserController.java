package com.tron.gymservice.controller;

import com.tron.gymservice.dto.UserPhysicalInfoDto;
import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.services.UserMasterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/api/v1/gym/")
public class EndUserController {

    @Autowired
    private UserMasterInfoService userMasterInfoService;


    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUserMasterData(@RequestBody UserRegistrationDto userRegistrationDto) {
        return new ResponseEntity(userMasterInfoService.save(userRegistrationDto,"USER"),HttpStatus.OK);
    }

    @PostMapping(value = "/physical-info")
    public ResponseEntity<?> updateUserPhysicalInfo(@RequestBody UserPhysicalInfoDto userPhysicalInfoDto) {
        return new ResponseEntity(userMasterInfoService.updatePhysicalInfo(userPhysicalInfoDto)
                ,HttpStatus.OK);
    }
}
