package org.example.project.hospitalmanagementsystem.database;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import org.example.project.hospitalmanagementsystem.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DatabaseHandler {
    @FXML private ComboBox<String> timeComboBox;


    public boolean insertUser(String role, String email, String password, boolean rememberMe) {
        String query = "INSERT INTO users (role, email, password, remember_me) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, role);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setBoolean(4, rememberMe);

            int result = stmt.executeUpdate();
            return result > 0;  // Returns true if the insertion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Returns false if there's an error
        }
    }

    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Assuming User is a class with a constructor that accepts these fields
                return new User(
                        rs.getInt("id"),
                        rs.getString("role"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getBoolean("remember_me")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;  // Return null if no user is found
    }

    public boolean updateUser(int id, String password, String role) {
        String query = "UPDATE users SET password = ?, role = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, password);
            stmt.setString(2, role);
            stmt.setInt(3, id);

            int result = stmt.executeUpdate();
            return result > 0;  // Returns true if the update was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Returns false if there's an error
        }
    }

    public boolean deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            int result = stmt.executeUpdate();
            return result > 0;  // Returns true if the deletion was successful

        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Returns false if there's an error
        }
    }
 // Make sure this is imported at the top

    public boolean insertAppointment(String name, String email, String department, String doctor, Date date, String time, String symptoms) {
        String rawTime = timeComboBox.getValue();  // example: "11:00 AM"
        String timeForDb = convertTo24Hour(rawTime);

        String query = "INSERT INTO appointments (full_name, email, department, doctor, appointment_date, appointment_time, symptoms) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, department);
            stmt.setString(4, doctor);
            stmt.setDate(5, date);
            stmt.setString(6, timeForDb);
            stmt.setString(7, symptoms);

            int result = stmt.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String convertTo24Hour(String time12h) {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("h:mm a");
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime time = LocalTime.parse(time12h.toUpperCase(), inputFormatter);
            return time.format(outputFormatter); // returns "11:00:00"
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null; // or handle error
        }
    }


}
