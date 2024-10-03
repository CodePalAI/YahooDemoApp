package com.demoapp.utils;

import java.util.Base64;

public class SecurityUtils {

    private static final String SECRET_KEY = "defaultSecretKey";

    public static String generateToken(String username) {
        String token = username + ":" + SECRET_KEY;
        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    public static boolean validateToken(String token, String username) {
        String generatedToken = generateToken(username);

        return generatedToken.equals(token);
    }

    public static String hashPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static boolean verifyPassword(String password, String hashedPassword) {
        String encodedPassword = hashPassword(password);

        return encodedPassword.equals(hashedPassword);
    }
}
