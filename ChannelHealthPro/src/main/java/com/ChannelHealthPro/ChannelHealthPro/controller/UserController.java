package com.ChannelHealthPro.ChannelHealthPro.controller;


import com.ChannelHealthPro.ChannelHealthPro.dto.request.LoginRequestDto;
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
    public ResponseEntity<User> loginUser(@RequestBody LoginRequestDto loginRequest) {
        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (user != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
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
