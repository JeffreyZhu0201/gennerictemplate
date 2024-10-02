package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    public List<Admin> GetAll();

}
