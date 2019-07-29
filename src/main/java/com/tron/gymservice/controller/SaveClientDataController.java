package com.tron.gymservice.controller;

import com.tron.gymservice.dto.UserRegistrationDto;
import com.tron.gymservice.services.UserMasterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tron/api/gym/")
public class SaveClientDataController {

    @Autowired
    private UserMasterInfoService userMasterInfoService;

    @GetMapping(value = "/get-clientData")
    public ResponseEntity<?> getUserMasterData() {
        return new ResponseEntity(userMasterInfoService.findAll(),HttpStatus.OK);
    }

    @PostMapping(value = "/save-clientData")
    public ResponseEntity<?> saveUserMasterData(@RequestBody UserRegistrationDto userRegistrationDto) {
        return new ResponseEntity(userMasterInfoService.save(userRegistrationDto),HttpStatus.OK);
    }
}
