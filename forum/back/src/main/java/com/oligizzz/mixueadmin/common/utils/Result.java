package com.oligizzz.mixueadmin.common.utils;


public class Result {
    int code;
    Object data;
    public Result(int code) {
        this.code = code;
    }
    public Result(Object data){
        this.data=data;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }

}
