package com.wdcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdcloud.config.context.DynamicApplicationContext;
import com.wdcloud.mapper.OrgEmailMapper;
import com.wdcloud.mapper.WdUserMapper;
import com.wdcloud.model.OrgEmail;
import com.wdcloud.model.WdUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wangff
 * @date 2019/12/25 15:04
 */
@Slf4j
@RestController
public class TestController {
    @Autowired
    OrgEmailMapper orgEmailMapper;
    @Autowired
    WdUserMapper wdUserMapper;
    @Autowired
    MessageSource messageSource;

    /**
     * @api {post} /app/edit 应用添加/编辑
     * @apiDescription 应用添加
     * @apiName appAdd
     * @apiGroup App
     * @apiParam {Number} [id] 应用ID
     * @apiParam {String} name 应用名称
     * @apiParam {String} nameCn 应用中文名称
     * @apiParam {String} description 应用说明
     * @apiExample {json} 请求示例:
     * {
     *      "id":13,
     *      "name":"app2",
     *      "nameCn":"应用2",
     *      "description":"应用2应用2应用2应用2应用22应用22"
     * }
     * @apiSuccess {Number} code 响应码，200为处理成功，其他处理失败
     * @apiSuccess {String} msg
     * @apiSuccess {Number} data 新增应用ID
     * @apiSuccessExample {json} 响应示例：
     * {
     *      "code": 200,
     *      "msg": "success",
     *      "data": 13
     * }
     */
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
    public Object lang() {
        String sign=messageSource.getMessage("login.sign",null, LocaleContextHolder.getLocale());
        String ok=messageSource.getMessage("login.ok",null, LocaleContextHolder.getLocale());
        JSONObject json = new JSONObject();
        json.put("sign",sign);
        json.put("ok",ok);
        return json;
    }

    @GetMapping("/test")
    public Object test() {
        return 1;
    }
}
