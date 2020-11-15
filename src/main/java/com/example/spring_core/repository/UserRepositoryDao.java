package com.example.spring_core.repository;

import com.example.spring_core.pojo.MyUser;

import java.io.IOException;

public interface UserRepositoryDao {
    public MyUser getUserByName(String userName) throws IOException;
}
