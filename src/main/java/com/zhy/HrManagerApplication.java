package com.zhy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zhy.**.mapper")
public class HrManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrManagerApplication.class, args);
    }

}
