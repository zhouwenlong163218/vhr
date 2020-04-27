package com.example.vhr.service;

import com.example.vhr.mapper.HrMapper;
import com.example.vhr.model.Hr;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HrService implements UserDetailsService {
    @Resource
    private HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(username);
        if(hr == null){
            throw  new UsernameNotFoundException("用户不存在");
        }
      return hr;
    }
}
