package org.example.project.hospitalmanagementsystem.controller.hospital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Pediatric {

    @FXML
    private FlowPane doctorPane;

    @FXML
    private Button bookButton;

    @FXML
    public void initialize() {
        addDoctorCard("Dr. Viola Davis, M.D.", "Pediatrician", "12 years experience");
        addDoctorCard("Dr. Peters James, M.D.", "Child Specialist", "18 years experience");
        addDoctorCard("Dr. Samantha Macaulay, M.D.", "Pediatrician", "6 years experience");
        addDoctorCard("Dr. Jesse Micheal, M.D.", "Child Specialist", "22 years experience");


        bookButton.setOnMouseClicked(this::handleBookAppointment);
    }

    private void addDoctorCard(String name, String specialty, String experience) {
        VBox card = new VBox(5);
        card.getStyleClass().add("doctor-card");

        Label nameLabel = new Label(name);
        nameLabel.getStyleClass().add("doctor-name");

        Label specialtyLabel = new Label(specialty);
        specialtyLabel.getStyleClass().add("doctor-specialty");

        Label experienceLabel = new Label(experience);
        experienceLabel.getStyleClass().add("doctor-experience");

        card.getChildren().addAll(nameLabel, specialtyLabel, experienceLabel);

        doctorPane.getChildren().add(card);
    }
    @FXML
    private void handleBookAppointment(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/appointment.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1400,800));
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/user/departmentuserCard.fxml"));
            Stage stage = (Stage) bookButton.getScene().getWindow();
            stage.setScene(new Scene(root,1400,800));
            stage.setTitle("Departments");
            stage.setMaximized(true); // <-- This forces fullscreen behavior
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
