package com.wdcloud.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用 Spring Boot 提供的注册机制
 **/
@Configuration
@Slf4j
public class SpringFilterRegistrationConfig {


    @Bean
    public FilterRegistrationBean<Filter> responseFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("responseFilter");
        registrationBean.setOrder(2);
        registrationBean.setFilter((request, response, chain) -> {
            HttpServletResponse servletResponse = (HttpServletResponse) response;
            log.info("response status {}", servletResponse.getStatus());
            chain.doFilter(request,response);
        });
        registrationBean.addUrlPatterns("/test/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<Filter> requestFilter() {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setName("requestFilter");
        registrationBean.setOrder(1);
        registrationBean.setFilter((request, response, chain) -> {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            log.info("request from {}", httpServletRequest.getRequestURI());
            chain.doFilter(request,response);
        });
        registrationBean.addUrlPatterns("/test/*");
        return registrationBean;
    }

}