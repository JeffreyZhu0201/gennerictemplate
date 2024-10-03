package com.example.demo.entity;

import javax.persistence.*;

/**
 * 角色用户父类
 */
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 用户名
     */
    @Column(name = "userName")
    private String userName;
    /**
     * 电话
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 年龄
     */
    @Column(name = "age")
    private Integer age;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 角色标识
     */
    @Column(name = "role")
    private Integer role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

}
