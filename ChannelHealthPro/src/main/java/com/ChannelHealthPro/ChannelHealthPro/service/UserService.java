package com.ChannelHealthPro.ChannelHealthPro.service;

import com.ChannelHealthPro.ChannelHealthPro.dto.request.UserDto;
import com.ChannelHealthPro.ChannelHealthPro.entity.User;

public interface UserService {

    User registerUser(UserDto user);
}
