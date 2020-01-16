package com.wangff;

import com.wdcloud.model.OrgEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public OrgEmail getTestBean2(){
        return new OrgEmail();
    }
}