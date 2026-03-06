package org.example.project.hospitalmanagementsystem.controller.users;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class Complaint {
    @FXML
    private BorderPane homeRoot;


    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private ComboBox<String> categoryBox;
    @FXML private TextArea complaintField;
    @FXML private RadioButton patientRadio, relativeRadio, employeeRadio, partnerRadio;
    @FXML private Hyperlink adminContactLink;
    @FXML private Accordion problemAccordion;

    private ToggleGroup submitterGroup = new ToggleGroup();
    private final String ADMIN_CONTACT = "+2349164794335"; // Update this number!
    private final Map<String, String[]> solutions = new HashMap<>();

    public void initialize() {
        // Add radio buttons to toggle group
        patientRadio.setToggleGroup(submitterGroup);
        relativeRadio.setToggleGroup(submitterGroup);
        employeeRadio.setToggleGroup(submitterGroup);
        partnerRadio.setToggleGroup(submitterGroup);

        // Set emergency contact link
        adminContactLink.setText(ADMIN_CONTACT);

        // Define common problems and solutions
        solutions.put("Service Issue", new String[]{
                "Check if the service is available online.",
                "Try booking an appointment instead of waiting in line.",
                "Speak to a department supervisor for immediate resolution."
        });
        solutions.put("Billing Problem", new String[]{
                "Verify your statement through the hospital portal.",
                "Call the billing department at ext. 101.",
                "Request a detailed breakdown of your charges."
        });
        solutions.put("Staff Complaint", new String[]{
                "Report behavior to HR at hr@hospital.com.",
                "Fill out an official feedback form at reception.",
                "Request a direct discussion with the management team."
        });
        solutions.put("Other", new String[]{
                "Visit reception for immediate guidance.",
                "Email complaints@hospital.com for support.",
                "Speak to the hospital director for urgent concerns."
        });

        // Populate Accordion with common problems
        populateAccordion();
    }

    private void populateAccordion() {
        problemAccordion.getPanes().clear();
        for (Map.Entry<String, String[]> entry : solutions.entrySet()) {
            TitledPane pane = new TitledPane(entry.getKey(), new Label(String.join("\n", entry.getValue())));
            problemAccordion.getPanes().add(pane);
        }
    }

    @FXML
    private void handleEmergencyCall() {
        try {
            Desktop.getDesktop().browse(new URI("tel:" + ADMIN_CONTACT));
        } catch (Exception e) {
            showAlert("Error", "Could not open dialer.");
        }
    }

    @FXML
    private void handleSubmit() {
        String name = nameField.getText();
        String email = emailField.getText();
        String category = categoryBox.getValue();
        String complaint = complaintField.getText();
        RadioButton selectedSubmitter = (RadioButton) submitterGroup.getSelectedToggle();
        String submitterType = selectedSubmitter == null ? "Not Specified" : selectedSubmitter.getText();

        if (name.isEmpty() || email.isEmpty() || category == null || complaint.isEmpty()) {
            showAlert("Error", "All fields must be filled!");
            return;
        }

        String submissionDetails = String.format(
                "Complaint submitted successfully!\n\nName: %s\nEmail: %s\nSubmitter: %s\nCategory: %s\nComplaint: %s\n\nFor urgent help, call: %s",
                name, email, submitterType, category, complaint, ADMIN_CONTACT);

        showAlert("Success", submissionDetails);
    }

    @FXML
    private void handleClear() {
        nameField.clear();
        emailField.clear();
        categoryBox.setValue(null);
        complaintField.clear();
        submitterGroup.selectToggle(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
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