package com.demoapp.services;

import com.demoapp.repositories.UserRepository;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public String findUserById(String userId) {
        return userRepository.findUserById(userId);
    }

    public boolean updateUser(String userId, String userData) {
        return userRepository.updateUser(userId, userData);
    }

    public String resetPassword(String email) {
        String newPassword = userRepository.resetPassword(email, "newPassword123");

        return newPassword;
    }

    public boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("password");
    }
}
