package com.wdcloud.jwt;

import com.wdcloud.mapper.SysUserMapper;
import com.wdcloud.mapper.WdUserMapper;
import com.wdcloud.model.SysUser;
import com.wdcloud.model.WdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sang on 2017/12/28.
 */
@Service
@Transactional
public class HrService implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser param = new SysUser();
        param.setUsername(username);
        SysUser sysUser = sysUserMapper.selectOne(param);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return User.builder().username(username).password(sysUser.getPassword()).build();
    }

    public int changeSecret(String subject) {
        SysUser param =  SysUser.builder().username(subject).build();
        SysUser sysUser= sysUserMapper.selectOne(param);
        return 1;
    }
}
