package com.example.demo.dao;

import com.example.demo.entity.Admin;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface AdminDao extends Mapper<Admin> {
    List<Admin> selectAll();

    @Select("select * from admin where `userName` = #{userName}")
    Admin findByUsername(String userName);

    @Select("select * from admin where `id` = #{id}")
    Admin findById(Integer id);
}
