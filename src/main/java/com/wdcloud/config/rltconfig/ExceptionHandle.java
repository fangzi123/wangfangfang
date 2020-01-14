package com.wdcloud.config.rltconfig;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    // 用来捕获和处理参数校验异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e){
        return new CommonResult(500,e.getBindingResult().getFieldError().getDefaultMessage());
    }


    @ExceptionHandler(Exception.class)
    public CommonResult exceptionHandler(Exception e){

        return new CommonResult(500,e.getMessage());
    }
}