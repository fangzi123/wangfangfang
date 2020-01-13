package com.wdcloud.config.rltconfig;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ApiErrorController implements ErrorController {

    private static final String PATH = "/error";


    @RequestMapping(value = PATH)
    public Object error(HttpServletRequest request, HttpServletResponse response) {
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String exception_type = (String) request.getAttribute("javax.servlet.error.exception_type");
        String  message = (String) request.getAttribute("javax.servlet.error.message");
        String  exception = (String) request.getAttribute("javax.servlet.error.exception");
        String  request_uri = (String) request.getAttribute("javax.servlet.error.request_uri");
        String  servlet_name = (String) request.getAttribute("javax.servlet.error.servlet_name");
        JSONObject json = new JSONObject();
        json.put("statusCode",statusCode);
        json.put("exception_type",exception_type);
        json.put("message",message);
        json.put("exception",exception);
        json.put("request_uri",request_uri);
        json.put("servlet_name",servlet_name);
        return new CommonResult(500,"Bad Request",json);

    }
    @Override
    public String getErrorPath() {
        return PATH;
    }

}
