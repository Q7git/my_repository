package com.example.demo.interceptor;

import com.example.demo.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {

            response.setStatus(401);

            response.getWriter().write("未登录");

            return false;
        }

        try {

            JwtUtils.verifyToken(token);

            return true;

        } catch (Exception e) {

            response.setStatus(401);

            response.getWriter().write("token无效");

            return false;
        }
    }
}