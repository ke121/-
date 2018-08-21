package com.tom.baiwei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.tom.baiwei.mapper")
//@EnableCaching
public class BaiweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiweiApplication.class, args);
    }
}
