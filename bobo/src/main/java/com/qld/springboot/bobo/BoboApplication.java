package com.qld.springboot.bobo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BoboApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoboApplication.class, args);
    }

}
