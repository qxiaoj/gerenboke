package com.qj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qj.mapper")
public class GerenbokeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GerenbokeApplication.class, args);
    }

}
