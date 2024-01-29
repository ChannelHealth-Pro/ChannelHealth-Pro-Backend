package com.ChannelHealthPro.ChannelHealthPro.controller;


import com.ChannelHealthPro.ChannelHealthPro.dto.request.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @PostMapping("/login")
    public String Login(){
        return "login";
    }

    @PostMapping("/register")
    public String Register(@RequestBody UserDto userDto){
        System.out.println(userDto.getName()+userDto.getEmail()+userDto.getPhoneNumber()+userDto.getPassword());
        return "Register";
    }
}
