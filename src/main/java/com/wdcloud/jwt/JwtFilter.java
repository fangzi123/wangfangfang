package com.wdcloud.jwt;

import com.alibaba.fastjson.JSON;
import com.wdcloud.config.context.DynamicApplicationContext;
import com.wdcloud.config.rltconfig.CommonResult;
import com.wdcloud.jwt.cache.CacheService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            HttpServletRequest req = (HttpServletRequest) servletRequest;
            String jwt = req.getHeader("jwtToken");
            Claims claims = Jwts.parser().setSigningKey("wdcms")
                    .parseClaimsJws(jwt.replace("Bearer",""))
                    .getBody();
            //黑名单校验
            CacheService cacheService = DynamicApplicationContext.getBean(CacheService.class);
            if (cacheService.getFromCommonCache(jwt) != null) {
                servletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = servletResponse.getWriter();
                out.write(JSON.toJSONString(new CommonResult("JwtFilter verify error")));
                out.flush();
                out.close();
                return;
            }
            String username = claims.getSubject();//获取当前登录用户名
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,null,authorities);
            SecurityContextHolder.getContext().setAuthentication(token);
            filterChain.doFilter(req,servletResponse);
        } catch (Exception e) {
            servletResponse.setContentType("application/json;charset=utf-8");
            PrintWriter out = servletResponse.getWriter();
            out.write(JSON.toJSONString(new CommonResult("JwtFilter verify error")));
            out.flush();
            out.close();
            e.printStackTrace();
        }
    }

}