package com.tom.baiwei.service;

import com.tom.baiwei.mapper.HrMapper;
import com.tom.baiwei.model.Hr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper mapper ;
    public Hr LoadUserByUsername(String username){
        return mapper.LoadUserByUsername(username) ;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = mapper.LoadUserByUsername(username);
        if(hr == null){
            throw new UsernameNotFoundException("用户不存在")  ;
        }
        return hr ;
    }
}
