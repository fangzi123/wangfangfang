package com.wdcloud.jwt;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wdcloud.dto.AddDTO;
import com.wdcloud.event.PublishEventService;
import com.wdcloud.event.UserBean;
import com.wdcloud.mapper.OrgEmailMapper;
import com.wdcloud.mapper.WdUserMapper;
import com.wdcloud.model.OrgEmail;
import com.wdcloud.model.WdUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author wangff
 * @date 2019/12/25 15:04
 */
@Slf4j
@RestController
public class LogoutController {

    @Autowired
    HrService hrService;

    @PostMapping("/logout2")
    public Object logout2(HttpServletRequest request) {
        String jwt = request.getHeader("jwtToken");
        Claims claims = Jwts.parser().setSigningKey("wangff")
                .parseClaimsJws(jwt.replace("Bearer",""))
                .getBody();
        hrService.changeSecret(claims.getSubject());
        log.info("================>{}",claims.getSubject());
        return "admin";
    }

}
