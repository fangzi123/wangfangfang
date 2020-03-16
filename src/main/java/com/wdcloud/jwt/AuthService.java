package com.wdcloud.jwt;

import com.wdcloud.mapper.SysUserMapper;
import com.wdcloud.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthService implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser param = new SysUser();
        param.setUsername(username);
        SysUser sysUser = sysUserMapper.selectOne(param);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不正确!");
        }
        return User.builder()
                .username(username)
                .password(sysUser.getPassword())
                .build();
    }

    public int changeSecret(String subject) {
        SysUser param =  SysUser.builder().username(subject).build();
        SysUser sysUser= sysUserMapper.selectOne(param);
        return 1;
    }
}
