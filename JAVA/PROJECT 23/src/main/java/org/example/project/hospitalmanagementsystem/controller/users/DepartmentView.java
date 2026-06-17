package org.example.project.hospitalmanagementsystem.controller.users;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.project.hospitalmanagementsystem.controller.admin.DoctorCardController;
import org.example.project.hospitalmanagementsystem.controller.admin.DoctorDAO;
import org.example.project.hospitalmanagementsystem.model.Department;
import org.example.project.hospitalmanagementsystem.model.Doctor;

import java.util.List;  // NOT java.awt.List
import java.io.IOException;

public class DepartmentView {

    @FXML
    private VBox doctorContainer;

    @FXML
    private Label nameLabel;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Label visitsLabel;
    private Department department;

    @FXML private ListView<String> servicesListView;


    public void setDepartment(Department department) {
        this.department = department;
        servicesListView.setItems(FXCollections.observableArrayList(department.getServices()));

        loadDepartmentData(); // load UI data
    }


    private void loadDepartmentData() {
        nameLabel.setText(department.getName());
        descriptionLabel.setText(department.getDescription());
        visitsLabel.setText(String.valueOf(department.getVisits()));
        servicesListView.setItems(FXCollections.observableArrayList(department.getServices()));

        // Clear existing doctor cards
        doctorContainer.getChildren().clear();

        // Fetch doctors for this department (replace with your actual method)
        List<Doctor> doctors = DoctorDAO.getDoctorsByDepartment(department.getName());
        System.out.println("Department name passed to DAO: " + department.getName());
        System.out.println("Doctors fetched: " + doctors.size());
        for (Doctor doctor : doctors) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/DoctorCard.fxml"));
                Node card = loader.load();
                System.out.println("Doctor: " + department.getName() + ", Docs: " + department.getAssignedDoctorIds());

                DoctorCardController cardController = loader.getController();
                cardController.setDoctorData(doctor); // inject data

                doctorContainer.getChildren().add(card);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

    public void handleBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/departmentuserCard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1400,800));
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
