package com.example.xiaochun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.xiaochun.mapper") //扫描mapper包,实现mapper依赖注入
@SpringBootApplication
public class XiaochunApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaochunApplication.class, args);
    }

}
