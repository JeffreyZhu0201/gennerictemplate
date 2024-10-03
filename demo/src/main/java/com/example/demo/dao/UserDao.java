package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserDao extends Mapper<User> {
    List<User> selectAll();

    @Select("select * from user where `userName` = #{userName}")
    User findByUsername(String userName);

    @Select("select * from user where `id` = #{id}")
    User findById(Integer id);
}
