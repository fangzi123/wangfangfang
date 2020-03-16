package com.wdcloud.config.rltconfig;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public final class CommonResult<T> {

    private int code = 200;

    private String msg = "success";

    private T data;

    public CommonResult() {
    }

    public CommonResult(T data) {
        this(200, "success", data);
    }
    public CommonResult(String msg) {
        this(500, msg,null);
    }
    public CommonResult(int code, String msg) {
        this(code, msg, null);
    }

    public CommonResult(Code err) {
        this(err.code, err.name);
    }

    public CommonResult(Code err, T data) {
        this(err.code, err.name, data);
    }

    public CommonResult(int code, String msg, T data) {
        this.code = code;
        this.msg = MessageUtil.getMessage(msg);
        this.data = data;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }

}