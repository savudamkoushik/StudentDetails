package com.example.spring_core.service;


import com.example.spring_core.pojo.MyUser;
import com.example.spring_core.repository.UserRepositoryDao;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MyUserService {
    @Autowired
    @Qualifier("userRepository")
    private UserRepositoryDao userRepositoryDao;
    public MyUser getUserByName(String name) throws IOException {
        return userRepositoryDao.getUserByName(name);
    }
}
