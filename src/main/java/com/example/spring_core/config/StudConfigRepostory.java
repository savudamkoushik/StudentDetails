package com.example.spring_core.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class StudConfigRepostory {
    @Bean
    public SqlSession getSession() throws IOException {
        return new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsReader("sqlmapconfig.xml"))
                .openSession();
    }
}
