package com.xq.mybatisplus.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @email wangiegie@gmail.com
 * @data 2017-08
 */
//@Configuration
@MapperScan("com.xq.mybatisplus.demo.mapper*")
public class MyBatisPlusConfig{

    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    /*@Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }*/
}