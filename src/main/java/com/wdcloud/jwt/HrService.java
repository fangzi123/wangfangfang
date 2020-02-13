package com.wdcloud.jwt;

import com.wdcloud.mapper.WdUserMapper;
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
    WdUserMapper wdUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WdUser param = new WdUser();
        param.setUsername(username);
        WdUser wdUser = wdUserMapper.selectOne(param);
        if (wdUser == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return User.builder().username(username).password(wdUser.getPassword()).build();
    }
}
