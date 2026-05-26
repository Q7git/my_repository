package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;

public class JwtUtils {

    private static final String SECRET = "q7-secret";

    public static String createToken(String username) {

        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 7 * 24 * 3600 * 1000))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static String verifyToken(String token) {

        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }
}