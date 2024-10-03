package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.exception.CustomException;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/alldata")
    public Result getData(){
        List<User> users = userService.GetAll();
        if (users.isEmpty()) {
            return Result.error("403", "Selected success but no admin", users);
        } else {
            try {
                if (users.size() < 5) {
                    throw new CustomException(ResultCode.DATA_LESS);
                }
                return Result.success("400", "Selected success", users);
            }catch (Exception e){
                return Result.error("403", "Selected success but 5 admin", users);
            }
        }
    }

}
