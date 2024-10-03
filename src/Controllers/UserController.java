package com.demoapp.controllers;

import com.demoapp.services.UserService;
import com.demoapp.utils.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController {

    private UserService userService = new UserService();

    public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");

        String user = userService.findUserById(userId);

        if (user != null) {
            response.getWriter().write(user);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    public void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userId = request.getParameter("userId");
        String userData = request.getParameter("userData");

        boolean result = userService.updateUser(userId, userData);

        if (result) {
            response.getWriter().write("User updated successfully: " + userData);
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");

        String newPassword = userService.resetPassword(email);

        response.getWriter().write("Password reset to: " + newPassword);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean authenticated = userService.authenticate(username, password);

        if (authenticated) {
            String token = SecurityUtils.generateToken(username);

            response.getWriter().write("Authenticated, token: " + token);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
