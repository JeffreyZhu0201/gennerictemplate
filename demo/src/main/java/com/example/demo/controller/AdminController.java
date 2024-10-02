package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.entity.Admin;
import com.example.demo.exception.CustomException;
import com.example.demo.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;


    @GetMapping("/alldata")
    public Result getData() {
        List<Admin> admins = adminService.GetAll();
        if (admins.isEmpty()) {
            return Result.error("403", "Selected success but no admin", admins);
        } else {
            try {
                if (admins.size() < 5) {
                    throw new CustomException(ResultCode.DATA_LESS);
                }
                return Result.success("400", "Selected success", admins);
            }catch (Exception e){
                return Result.error("403", "Selected success but 5 admin", admins);
            }
        }
    }
}
