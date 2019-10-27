package com.tron.gymservice.controller;

import com.tron.gymservice.dto.UserDeleteDto;
import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.services.UserMasterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/api/v1/gym/")
public class AdminController {

    @Autowired
    private UserMasterInfoService userMasterInfoService;

    @GetMapping(value = "/user")
    public ResponseEntity<?> getUserMasterData() {
        return new ResponseEntity(userMasterInfoService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/user")
    public ResponseEntity<?> deleteUserMasterData(@RequestBody UserDeleteDto userDeleteDto) {
        return new ResponseEntity(userMasterInfoService.delete(userDeleteDto),HttpStatus.OK);
    }


    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUserMasterData(@RequestBody UserRegistrationDto userRegistrationDto) {
        return new ResponseEntity(userMasterInfoService
                .save(userRegistrationDto,"ADMIN"),HttpStatus.OK);
    }
}
