package com.wdcloud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdcloud.config.rltconfig.BaseException;
import com.wdcloud.dto.AddDTO;
import com.wdcloud.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wangff
 * @date 2019/12/25 15:04
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    SysUserMapper sysUserMapper;
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
    @PostMapping("/post")
    public Object get(@Valid @RequestBody AddDTO addDTO) {
        return null;
    }

    @GetMapping("/get")
    public Object list(@Valid AddDTO addDTO) {
       PageHelper.startPage(1,10);
       List list = sysUserMapper.selectAll();
       PageInfo pageInfo = new PageInfo(list);
        if (pageInfo != null) {
            throw new BaseException("login.sign");
        }
       return pageInfo;
    }


}
