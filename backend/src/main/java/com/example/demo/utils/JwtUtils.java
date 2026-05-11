package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtils {

    // 密钥（后面可以放配置文件）
    private static final String SECRET = "q7-secret";

    // 生成 token
    public static String createToken(String username) {

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 7 * 24 * 3600 * 1000))
                .sign(Algorithm.HMAC256(SECRET));
    }

    // 验证 token
    public static String verifyToken(String token) {

        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}