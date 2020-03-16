package com.wdcloud.jwt;

import com.wdcloud.jwt.cache.CacheService;
import com.wdcloud.jwt.cache.CacheServiceImpl;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangff
 * @date 2019/12/25 15:04
 */
@Slf4j
@RestController
public class LogoutController {

    @Autowired
    AuthService authService;
    @Autowired
    CacheService cacheService;

    /**
     * 退出登录，token加入黑名单
     * @param request
     * @return
     */
    @PostMapping("/logout2")
    public Object logout2(HttpServletRequest request) {
        String jwt = request.getHeader("jwtToken");
        Claims claims = Jwts.parser().setSigningKey("wdcms")
                .parseClaimsJws(jwt.replace("Bearer",""))
                .getBody();
        cacheService.setCommonCache(jwt,claims.getSubject());
        return "ok";
    }

}
