package com.example.demo.controller;


import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminService adminService;


    @GetMapping("/alldata")
    public List<Admin> getData(){
        return adminService.GetAll();
    }


}
