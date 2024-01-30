package com.ChannelHealthPro.ChannelHealthPro.service.impl;

import com.ChannelHealthPro.ChannelHealthPro.Enum.UserRole;
import com.ChannelHealthPro.ChannelHealthPro.dto.request.UserDto;
import com.ChannelHealthPro.ChannelHealthPro.entity.User;
import com.ChannelHealthPro.ChannelHealthPro.repo.UserRepository;
import com.ChannelHealthPro.ChannelHealthPro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(UserDto user) {
        // Check if the user with the given email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User with this email already exists");
        }

        User newUser=new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhoneNumber(user.getPhoneNumber());

        // Set role to CUSTOMER for registration
        newUser.setRole(UserRole.CUSTOMER);

        // Encrypt the password before saving
        newUser.setPassword(user.getPassword());

        // Save the user
        return userRepository.save(newUser);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null && verifyPassword(password, user.getPassword())) {
            return user;
        }

        return null;
    }
    private boolean verifyPassword(String inputPassword, String storedPassword) {
        return inputPassword.equals(storedPassword);
    }
}
