package com.ChannelHealthPro.ChannelHealthPro.controller;


import com.ChannelHealthPro.ChannelHealthPro.dto.request.UserDto;
import com.ChannelHealthPro.ChannelHealthPro.entity.User;
import com.ChannelHealthPro.ChannelHealthPro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String Login(){
        return "login";
    }




    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
