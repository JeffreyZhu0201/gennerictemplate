package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> GetAll();

    public User userRegister(User user);

    public User userLogin(User user);
}