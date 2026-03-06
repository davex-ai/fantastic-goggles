package org.example.project.hospitalmanagementsystem.controller.users;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.example.project.hospitalmanagementsystem.controller.hospital.DepartmentService;
import org.example.project.hospitalmanagementsystem.model.Department;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.List;
import java.util.Arrays;
public class DepartmentUser implements Initializable{

        @FXML
        private TilePane departmentTilePane;
        @FXML
        private Label mostVisitedLabel;
        @FXML
        private Label availableSlotsLabel;

        private DepartmentService departmentService = new DepartmentService();

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            loadDepartmentCards();

            // Optional: update stats dynamically
            mostVisitedLabel.setText("Cardiology, Pediatrics");
            availableSlotsLabel.setText("23 slots available today");
        }

    private void loadDepartmentCards() {
        List<Department> departments = departmentService.getAllDepartments();
        departmentTilePane.getChildren().clear();

        for (Department dept : departments) {
            VBox card = createDepartmentCard(dept);
            departmentTilePane.getChildren().add(card);
        }
    }

    private VBox createDepartmentCard(Department department) {
        VBox card = new VBox();
        card.setPadding(new Insets(15));
        card.setSpacing(10);
        card.setPrefSize(280, 150);
        card.getStyleClass().add("department-card");

        Label title = new Label(department.getName());
        title.setFont(new Font("Arial", 20));
        title.setTextFill(Color.web("#1e1e1e"));

        Label desc = new Label("Specialists available. Book now.");
        desc.setWrapText(true);
        desc.setFont(new Font("Arial", 14));
        desc.setTextFill(Color.GRAY);

        card.getChildren().addAll(title, desc);

        // Hover effect
        card.setOnMouseEntered(e -> {
            card.setStyle("-fx-background-color: #e6f2ff; -fx-border-color: #3399ff; -fx-border-width: 1; -fx-border-radius: 10;");
            card.setCursor(Cursor.HAND);
        });

        card.setOnMouseExited(e -> {
            card.setStyle(null);
            card.getStyleClass().add("department-card");
        });

        // 🔁 On click: Load dynamic department view
        card.setOnMouseClicked(e -> openDepartmentView(department));

        return card;
    }

    private void openDepartmentView(Department department) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/DepartmentView.fxml"));
            Parent root = loader.load();

            DepartmentView controller = loader.getController();
            controller.setDepartment(department); // 👈 inject the selected department

            Stage stage = (Stage) departmentTilePane.getScene().getWindow();
            stage.setScene(new Scene(root, 1400, 800));
            stage.setTitle(department.getName() + " Department");
            stage.setMaximized(true); // Optional, match layout size


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        @FXML
        private void handleAppointments(MouseEvent event) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/user/appointment.fxml"));
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void handleBack(MouseEvent mouseEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/user/Homepage.fxml"));
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root,1400,800));
            stage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


