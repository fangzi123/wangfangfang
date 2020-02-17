package com.wdcloud.jwt;

import com.wdcloud.config.rltconfig.CommonResult;
import com.wdcloud.dto.AddDTO;
import com.wdcloud.model.OrgEmail;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wangff
 * @date 2020/2/13 15:36
 */
@Slf4j
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService)
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return DigestUtils.md5DigestAsHex(((String)charSequence).getBytes());
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String encodedPassword) {
                        return encodedPassword.equals(DigestUtils.md5DigestAsHex(((String)charSequence).getBytes()));
                    }
                });

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf()
                .disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html", "/static/**", "/login_p", "/favicon.ico");
    }

    @RequestMapping("/logout")
    @ResponseBody
    public CommonResult logout(HttpServletRequest request) {
        String jwt = request.getHeader("jwtToken");
        Claims claims = Jwts.parser().setSigningKey("wangff")
                .parseClaimsJws(jwt.replace("Bearer",""))
                .getBody();
//        hrService.changeSecret(claims.getSubject());
        return CommonResult.success(claims.getSubject());
    }
}
