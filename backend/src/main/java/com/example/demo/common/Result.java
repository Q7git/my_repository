package com.example.demo.common;

public class Result<T> {    //泛型降低类的藕合性，高内聚低耦合

    private Integer code;

    private String msg;

    private T data;

    public Result() {
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 成功返回
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    // 失败返回
    public static <T> Result<T> fail(String msg) {
        return new Result<>(400, msg, null);
    }

    // getter setter

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}