package com.example.demo.config;

import com.example.demo.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new JwtInterceptor())

                // 拦截所有请求
                .addPathPatterns("/**")

                // 放行登录注册
                .excludePathPatterns(
                        "/user/login",
                        "/user/register"
                );
    }
}