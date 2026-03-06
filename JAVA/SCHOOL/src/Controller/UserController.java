package Controller;

import Model.Database;
import Model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    // Create User
    public static boolean addUser(String name, String email) {
        try (Connection conn = Database.getConnection()) {
            if (conn == null) throw new SQLException("Database connection failed.");

            String sql = "INSERT INTO student (name, email) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, name);
            stmt.setString(2, email);

            int affectedRows = stmt.executeUpdate();

            // Get generated ID
            if (affectedRows > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int generatedId = generatedKeys.getInt(1);
                    System.out.println("User added with ID: " + generatedId);
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    // Read Users
    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = Database.getConnection()) {
            if (conn == null) throw new SQLException("Database connection failed.");
            String sql = "SELECT * FROM student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Update User
    public static boolean updateUser(int id, String name, String email) {
        try (Connection conn = Database.getConnection()) {
            if (conn == null) throw new SQLException("Database connection failed.");
            String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete User
    public static boolean deleteUser(int id) {
        try (Connection conn = Database.getConnection()) {
            if (conn == null) throw new SQLException("Database connection failed.");
            String sql = "DELETE FROM users WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}