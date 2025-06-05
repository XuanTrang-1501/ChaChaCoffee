package com.springboot.dev_spring_boot_demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.dev_spring_boot_demo.Repository.UserRepository;
import com.springboot.dev_spring_boot_demo.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}