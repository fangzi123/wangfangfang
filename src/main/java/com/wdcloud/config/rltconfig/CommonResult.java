package com.wdcloud.config.rltconfig;

import lombok.Data;

@Data
public final class CommonResult<T> {

    private int code = 200;

    private String msg = "success";

    private T data;

    public CommonResult() {
    }

    public CommonResult(T data) {
        this.data = data;
    }

    public CommonResult(int code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonResult(int code,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}