package org.example.project.hospitalmanagementsystem.controller.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.example.project.hospitalmanagementsystem.database.DatabaseHandler;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Appointment  {


    private DatabaseHandler dbHandler = new DatabaseHandler();
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private ComboBox<String> departmentComboBox;
    @FXML private ComboBox<String> doctorComboBox;
    @FXML private DatePicker datePicker;
    @FXML private TextArea notesArea;
    @FXML private Label errorLabel;
    @FXML private ComboBox<String> timeComboBox;
    // Example department-doctor mapping
    private final Map<String, List<String>> departmentDoctors = new HashMap<>();

    @FXML
    public void initialize() {
        // Populate departments
        departmentComboBox.getItems().addAll("Cardiology", "Neurology", "Pediatrics", "Dermatology","ClinicalController", "Maternity");

        // Map doctors to departments
        departmentDoctors.put("Cardiology", List.of("Dr. Smith", "Dr. Adams", "Dr David"));
        departmentDoctors.put("Neurology", List.of("Dr. Brown", "Dr. Lena","Dr Myers", "Dr. Silas"));
        departmentDoctors.put("Pediatrics", List.of("Dr. Samantha", "Dr. Viola", "Dr.Peters", "Dr.Jesse"));
        departmentDoctors.put("Dermatology", List.of("Dr. Rose", "Dr. Marcus", "Dr.Benson"));
        departmentDoctors.put("Check- up", List.of("Dr. Alice", "Dr. Bob", "Dr. Carol"));
        departmentDoctors.put("Maternity", List.of("Dr. Stephanie", "Dr. Grace", "Dr.Maxine"));


        timeComboBox.getItems().addAll(
                "09:00 AM", "10:00 AM", "11:00 AM",
                "12:00 PM", "01:00 PM", "02:00 PM",
                "03:00 PM", "04:00 PM", "05:00 PM"
        );
        // Set default error label style
        errorLabel.setTextFill(Color.RED);
        errorLabel.setVisible(false);
    }

    @FXML
    private void handleDepartmentSelection() {
        String selectedDepartment = departmentComboBox.getValue();
        doctorComboBox.getItems().clear();

        if (selectedDepartment != null && departmentDoctors.containsKey(selectedDepartment)) {
            List<String> doctors = departmentDoctors.get(selectedDepartment);
            doctorComboBox.getItems().addAll(doctors);
            if (!doctors.isEmpty()) {
                doctorComboBox.getSelectionModel().selectFirst();
            }
        }
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        String rawTime = timeComboBox.getValue();
        String convertedTime = DatabaseHandler.convertTo24Hour(rawTime);  // static method or instance method
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String department = departmentComboBox.getValue();
        String doctor = doctorComboBox.getValue();
        String time = timeComboBox.getValue(); // Make sure you add timeComboBox to the FXML & controller
        LocalDate localDate = datePicker.getValue();
        if (localDate == null) {
            showError("Please select a date.");
            return;
        }
        Date appointmentDate = Date.valueOf(localDate);

        String notes = notesArea.getText().trim();

        // Simple validation (example)
        if (name.isEmpty() || email.isEmpty() || department == null || doctor == null || appointmentDate == null ||localDate == null || time == null) {
            errorLabel.setText("Please fill out all fields.");
            errorLabel.setVisible(true);
            return;
        }
        if (!isValidEmail(email)) {
            showError("Invalid email format.");
            return;
        }

        boolean success = dbHandler.insertAppointment(
                name,
                email,
                department,
                doctor,
                appointmentDate,
                time,
                notes
        );

        if (success) {
            errorLabel.setText("Appointment booked successfully.");
            errorLabel.setTextFill(Paint.valueOf("green"));
            errorLabel.setVisible(true);
            clearForm();
        } else {
            errorLabel.setText("Failed to book appointment. Try again.");
            errorLabel.setTextFill(Paint.valueOf("red"));
            errorLabel.setVisible(true);
        }
    }


    private void showError(String message) {
        showError(message, Color.RED);
    }

    private void showError(String message, Color color) {
        errorLabel.setTextFill(color);
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }

    private void clearForm() {
        nameField.clear();
        emailField.clear();
        departmentComboBox.getSelectionModel().clearSelection();
        doctorComboBox.getItems().clear();
        doctorComboBox.getSelectionModel().clearSelection();
        timeComboBox.getSelectionModel().clearSelection();
        datePicker.setValue(null);
        notesArea.clear();
    }
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    @FXML
    private void handleBackToHome(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/Homepage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Match login window behavior exactly
            Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
            stage.setScene(scene);
            stage.setTitle("Trumedix - Home");
            stage.setResizable(true);
            stage.setMaximized(true);
            stage.show();

            // Optional: If you're passing data (like username), do it here
            homepage controller = loader.getController();
            controller.setUsername("user@example.com"); // Replace with actual user if needed

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
