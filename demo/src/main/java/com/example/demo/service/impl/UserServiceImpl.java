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

    public List<User> GetAll(){
        return userDao.selectAll();
    }

    public Result userRegister(User user){
        String userName = user.getUserName();

        User dbUser = userDao.findByUsername(userName);

        try{
            if(ObjectUtil.isNotEmpty(dbUser)){
                throw new CustomException(ResultCode.USER_EXIST_ERROR);
            }
        } catch (CustomException e) {
            return Result.error("用户已存在!");
        }
        userDao.insertSelective(user);
        return Result.success("200","added the user success",user);

    }

}
