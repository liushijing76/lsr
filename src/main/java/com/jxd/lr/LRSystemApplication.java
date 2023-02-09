package com.jxd.lr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jxd.lr.dao")
public class LRSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LRSystemApplication.class, args);
    }

}
