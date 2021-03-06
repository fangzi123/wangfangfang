package com.wdcloud.jwt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wdcloud.config.rltconfig.CommonResult;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个是用户登录的过滤器，
 * 在用户的登录的过滤器中校验用户是否登录成功，
 * 如果登录成功，则生成一个token返回给客户端，
 * 登录失败则给前端一个登录失败的提示。
 * @author wangff
 * @date 2020/2/13 14:48
 */
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    protected JwtLoginFilter(String defaultFilterProcessesUrl, AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(defaultFilterProcessesUrl));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse resp) throws AuthenticationException, IOException, ServletException {
        User user = new ObjectMapper().readValue(req.getInputStream(), User.class);
        return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse resp, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authResult.getAuthorities();
        StringBuffer sb = new StringBuffer();
        for (GrantedAuthority authority : authorities) {
            sb.append(authority.getAuthority()).append(",");
        }
        String jwt = Jwts.builder()
                .claim("sysUser",authResult.getPrincipal())
                .claim("authorities", sb)     //配置用户角色
                .setSubject(authResult.getName())
                .setExpiration(new Date(System.currentTimeMillis()+12*30*24*60*60*1000))
                .signWith(SignatureAlgorithm.HS512,"wangff")
                .compact();

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        Map hasMap = new HashMap(4);
        hasMap.put("jwtToken", jwt);
        out.write(new CommonResult(hasMap).toJSONString());
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e) throws IOException, ServletException {
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String respBean = null;
        if (e instanceof BadCredentialsException ||
                e instanceof UsernameNotFoundException) {
            respBean = "账户名或者密码输入错误!";
        } else if (e instanceof LockedException) {
            respBean ="账户被锁定，请联系管理员!";
        } else if (e instanceof CredentialsExpiredException) {
            respBean = "密码过期，请联系管理员!";
        } else if (e instanceof AccountExpiredException) {
            respBean = "账户过期，请联系管理员!";
        } else if (e instanceof DisabledException) {
            respBean = "账户被禁用，请联系管理员!";
        } else {
            respBean = "登录失败!";
        }
        resp.setStatus(401);
        out.write(new CommonResult(500,respBean).toJSONString());
        out.flush();
        out.close();
    }
}
