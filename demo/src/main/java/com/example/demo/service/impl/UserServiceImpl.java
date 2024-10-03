package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.dao.UserDao;
import com.example.demo.exception.CustomException;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;

import java.util.List;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> GetAll() {
        return userDao.selectAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User userRegister(User user) {
        String userName = user.getUserName();

        User dbUser = userDao.findByUsername(userName);

        try {
            if (ObjectUtil.isNotEmpty(dbUser)) {
                throw new CustomException(ResultCode.USER_EXIST_ERROR);
            }
        } catch (CustomException e) {
            return null;
        }
        userDao.insertSelective(user);
        return user;
    }

    @Override
    public User userLogin(User user) {
        User dbUser = userDao.findByUsername(user.getUserName());
        if (ObjectUtil.isNotEmpty(dbUser) && dbUser.getPassword().equals(user.getPassword())) {
            return user;
        }
        return null;
    }
}
