package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminService {

    public List<Admin> GetAll();

    public Admin findById(Integer id);

    public Admin adminLogin(Admin admin);

    public Admin adminRegister(Admin admin);

}
