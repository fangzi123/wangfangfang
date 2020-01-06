package com.wdcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdcloud.mapper.OrgEmailMapper;
import com.wdcloud.mapper.WdUserMapper;
import com.wdcloud.model.OrgEmail;
import com.wdcloud.model.WdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    @Autowired
    MessageSource messageSource;

    @GetMapping("/wangfangfang")
    public OrgEmail get() {
        OrgEmail orgEmail = new OrgEmail();
        orgEmail.setId(1L);
        OrgEmail rlt=orgEmailMapper.selectOne(orgEmail);
        return rlt;
    }

    @GetMapping("/get")
    public Object list() {
       PageHelper.startPage(1,10);
       List<WdUser> wdUsers = wdUserMapper.selectAll();
       PageInfo pageInfo = new PageInfo(wdUsers);
       return pageInfo;
    }

    @GetMapping("/lang")
    public String lang() {
        String sign=messageSource.getMessage("login.sign",null, LocaleContextHolder.getLocale());
        String ok=messageSource.getMessage("login.ok",null, LocaleContextHolder.getLocale());
        JSONObject json = new JSONObject();
        json.put("sign",sign);
        json.put("ok",ok);
        return json.toJSONString();
    }
}
