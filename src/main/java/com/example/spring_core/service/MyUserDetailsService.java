package com.example.spring_core.service;

import com.example.spring_core.pojo.MyUser;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MyUserDetailsService implements UserDetailsService {
    Logger logger= LoggerFactory.getLogger("MYUserDetailsService.class");
    @Autowired
    MyUserService myUserService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @SneakyThrows
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUser user=myUserService.getUserByName(s);
        logger.info("<--------user details----------------->!!!!!!!!!!!"+user.getName()+" "+user.getPassword());
        Optional.ofNullable(user).orElseThrow(()->new UsernameNotFoundException(s));
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("admin"));
        roles.add(new SimpleGrantedAuthority("manager"));
        List<GrantedAuthority> authorities=new ArrayList<GrantedAuthority>(roles);
//        return new User("foo","foo",new ArrayList<>());
        return buildUserForAuthentication(user,authorities);
    }

    private UserDetails buildUserForAuthentication(MyUser user, List<GrantedAuthority> authorities) {
        return new User(user.getName(),bCryptPasswordEncoder.encode(user.getPassword()),authorities);
    }
}
