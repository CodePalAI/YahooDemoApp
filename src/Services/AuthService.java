package com.demoapp.services;

import com.demoapp.utils.SecurityUtils;

public class AuthService {

    public boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return true;
        }
        return false;
    }

    public String resetPassword(String email) {
        String newPassword = "newpassword123";
        return newPassword;
    }

    public String generateAuthToken(String username) {
        return "token_" + username + "_" + System.currentTimeMillis();
    }

    public boolean validateToken(String token) {
        return token.startsWith("token_");
    }
}
