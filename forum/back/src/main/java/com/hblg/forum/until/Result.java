package com.hblg.forum.until;

public class Result {
    int code;
    Object data;
    public Result(){
        this.code=0;
    }
    public Result(int code){
        this.code=code;
    }
    public Result(Object data){
        this.code=0;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
