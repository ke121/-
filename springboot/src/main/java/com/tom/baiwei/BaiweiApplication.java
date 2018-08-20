package com.tom.baiwei;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tom.baiwei.mapper")
public class BaiweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiweiApplication.class, args);
    }
}
