package com.example.cgtable.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterBean {
    @Bean
    public PaginationInterceptor paginationInnerInterceptor(){
        return new PaginationInterceptor();
    }

}
