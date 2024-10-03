package com.demoapp.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserRepository {

    private String dbUrl = "jdbc:mysql://localhost:3306/demoapp";
    private String dbUsername = "root";
    private String dbPassword = "password";

    public String findUserById(String userId) {
        String user = null;

        String query = "SELECT * FROM users WHERE id = '" + userId + "'";
        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            if (resultSet.next()) {
                user = resultSet.getString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean updateUser(String userId, String userData) {
        boolean updated = false;

        String query = "UPDATE users SET data = '" + userData + "' WHERE id = '" + userId + "'";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(query);
            updated = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return updated;
    }

    public boolean resetPassword(String email, String newPassword) {
        boolean reset = false;

        String query = "UPDATE users SET password = '" + newPassword + "' WHERE email = '" + email + "'";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement()) {

            int rowsAffected = statement.executeUpdate(query);
            reset = rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reset;
    }

    public void deleteUser(String userId) {
        String query = "DELETE FROM users WHERE id = '" + userId + "'";

        try (Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
             Statement statement = connection.createStatement()) {

            statement.executeUpdate(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
