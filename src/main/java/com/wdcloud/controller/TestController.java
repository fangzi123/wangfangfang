package com.wdcloud.controller;

import com.wdcloud.Application;
import com.wdcloud.mapper.OrgEmailMapper;
import com.wdcloud.mapper.WdUserMapper;
import com.wdcloud.model.OrgEmail;
import com.wdcloud.model.WdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangff
 * @date 2019/12/25 15:04
 */
@RestController
public class TestController {
    @Autowired
    OrgEmailMapper orgEmailMapper;
    @Autowired
    WdUserMapper wdUserMapper;
    @GetMapping("/wangfangfang")
    public OrgEmail get() {
        OrgEmail orgEmail = new OrgEmail();
        orgEmail.setId(1L);
        OrgEmail rlt=orgEmailMapper.selectOne(orgEmail);
        return rlt;
    }

    @GetMapping("/get")
    public List list() {
       List<WdUser> wdUsers = wdUserMapper.selectAll();
       return wdUsers;
    }
}
