package com.ChannelHealthPro.ChannelHealthPro.dto.request;

import lombok.Data;

@Data
public class UserDto {
    String name;
    String email;
    Long phoneNumber;
    String password;
}
