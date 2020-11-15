package com.example.spring_core.repository;


import com.example.spring_core.config.StudConfigRepostory;
import com.example.spring_core.pojo.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Component("userRepository")
@Repository
public class UserRepositoryDaoImpl implements UserRepositoryDao {
    @Autowired
    private StudConfigRepostory sqlSession;
    @Override
    public MyUser getUserByName(String userName) throws IOException {
        return sqlSession.getSession().selectOne("userAuth.getByUserName",userName);
    }
}
