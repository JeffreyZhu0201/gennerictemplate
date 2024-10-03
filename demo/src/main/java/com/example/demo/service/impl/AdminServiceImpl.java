package com.example.demo.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.example.demo.common.Result;
import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import com.example.demo.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;

    @Override
    public List<Admin> GetAll() {
        return adminDao.selectAll();
    }

    @Override
    public Admin adminLogin(Admin admin) {
        Admin dbAdmin = adminDao.findByUsername(admin.getUserName());
        if (ObjectUtil.isNotEmpty(dbAdmin) && dbAdmin.getPassword().equals(admin.getPassword())) {
            return admin;
        }
        return null;
    }

    @Override
    public Admin adminRegister(Admin admin) {
        Admin dbAdmin = adminDao.findByUsername(admin.getUserName());
        if (ObjectUtil.isEmpty(dbAdmin)) {
            adminDao.insertSelective(admin);
            return admin;
        } else {
            return null;
        }
    }
}
