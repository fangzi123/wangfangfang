package com.wdcloud.controller;

import com.wdcloud.mapper.OrgEmailMapper;
import com.wdcloud.model.OrgEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangff
 * @date 2019/12/25 15:04
 */
@RestController
public class TestController {
    @Autowired
    OrgEmailMapper orgEmailMapper;
    @GetMapping("/wangfangfang")
    public OrgEmail get() {
        OrgEmail orgEmail = new OrgEmail();
        orgEmail.setId(1L);
        OrgEmail rlt=orgEmailMapper.selectOne(orgEmail);
        return rlt;
    }
}
