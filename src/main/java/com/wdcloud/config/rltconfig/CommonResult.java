package com.wdcloud.config.rltconfig;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.util.StringUtils;

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

    public String toJSONString() {
       return JSON.toJSONString(this);
    }

    public static CommonResult error(String msg) {
        if (StringUtils.isEmpty(msg)) {
            return new CommonResult(500, "common.error");
        }
        return new CommonResult(500, msg);
    }

    public static CommonResult success(Object data) {
            return new CommonResult(data);
    }

}