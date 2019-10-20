package com.tron.gymservice.controller;

import com.tron.gymservice.dto.UserDeleteDto;
import com.tron.gymservice.dto.UserPhysicalInfoDto;
import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.services.UserMasterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tron/api/gym/")
public class EndUserController {

    @Autowired
    private UserMasterInfoService userMasterInfoService;

    @GetMapping(value = "/user")
    public ResponseEntity<?> getUserMasterData() {
        return new ResponseEntity(userMasterInfoService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity<?> deleteUserMasterData(@RequestBody UserDeleteDto userDeleteDto) {
        return new ResponseEntity(userMasterInfoService.delete(userDeleteDto),HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUserMasterData(@RequestBody UserRegistrationDto userRegistrationDto) {
        return new ResponseEntity(userMasterInfoService.save(userRegistrationDto),HttpStatus.OK);
    }

    @PostMapping(value = "/physical-info")
    public ResponseEntity<?> updateUserPhysicalInfo(@RequestBody UserPhysicalInfoDto userPhysicalInfoDto) {
        return new ResponseEntity(userMasterInfoService.updatePhysicalInfo(userPhysicalInfoDto)
                ,HttpStatus.OK);
    }
}
