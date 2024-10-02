package com.example.demo.exception;

import com.example.demo.common.ResultCode;

public class CustomException extends RuntimeException {
    private String code;
    private String msg;

    public CustomException(ResultCode resultCode) {  //这个方法的参数就是刚刚我们创建的ResultCode类
        this.code = resultCode.code;
        this.msg = resultCode.msg;
    }

    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
