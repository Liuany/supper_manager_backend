package com.example.xiaochun;

import com.example.xiaochun.jwt.JwtAuthenticationFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@MapperScan("com.example.xiaochun.mapper") //扫描mapper包,实现mapper依赖注入
@SpringBootApplication
public class XiaochunApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XiaochunApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean jwtFilter () {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtAuthenticationFilter filter = new JwtAuthenticationFilter();
        registrationBean.setFilter(filter);
        return  registrationBean;
    }

    @Override
    protected SpringApplicationBuilder configure (SpringApplicationBuilder builder) {
        return builder.sources(XiaochunApplication.class);
    }
}
