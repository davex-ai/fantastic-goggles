package org.example.project.hospitalmanagementsystem.controller.hospital;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.project.hospitalmanagementsystem.model.Department;
import org.example.project.hospitalmanagementsystem.model.DepartmentModel;

import java.io.IOException;
import java.util.List;


public class DepartmentController {

    @FXML private TilePane departmentTilePane;
    @FXML private Label mostVisitedLabel;
    @FXML private Label availableSlotsLabel;
    @FXML private Button bookButton;

    private List<Department> departments;
    private final DepartmentService departmentService = new DepartmentService();

    @FXML
    public void initialize() {
        System.out.println("TilePane: " + departmentTilePane);
        departments = departmentService.getAllDepartments();
        System.out.println("Departments found: " + departments.size());
        loadDepartmentStats();
        for (Department dept : departments) {
            VBox card = createDepartmentCard(new DepartmentModel(dept));
            departmentTilePane.getChildren().add(card);
        }
    }

    private VBox createDepartmentCard(DepartmentModel model) {
        VBox card = new VBox(10);
        card.getStyleClass().add("department-card");

        ImageView imageView = new ImageView();
        imageView.imageProperty().bind(model.imageProperty());
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);

        Label title = new Label();
        title.textProperty().bind(model.nameProperty());
        title.getStyleClass().add("department-title");

        Label hours = new Label();
        hours.textProperty().bind(model.operatingHoursProperty());
        hours.getStyleClass().add("department-hours");

        card.getChildren().addAll(imageView, title, hours);
        card.setOnMouseClicked(e -> handleDepartmentClick(model.getName(), e));

        return card;
    }



    private void handleDepartmentClick(String name, MouseEvent e) {
        String path = "/fxml/" + name.toLowerCase() + ".fxml";
        loadDepartmentFXML(e, path, name + " Department");
    }

    private void loadDepartmentFXML(MouseEvent event, String fxmlPath, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1400, 800);
            scene.getStylesheets().add(getClass().getResource("/css/departments.css").toExternalForm());

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setMaximized(true);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadDepartmentStats() {
        // Reuse service here (e.g., departmentService.getStats())
        // Or move this logic into the service if it grows.
        mostVisitedLabel.setText("Cardiology, Neurology"); // Temp
        availableSlotsLabel.setText("12 7 9"); // Temp
    }
    @FXML
    public void addDepartmentCard(DepartmentModel model) {
        VBox card = createDepartmentCard(model);
        departmentTilePane.getChildren().add(card);
    }
    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/user/Homepage.fxml"));
            Stage stage = (Stage) bookButton.getScene().getWindow();
            stage.setScene(new Scene(root,1400,800));
            stage.setTitle("Home page");
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleAppointments(MouseEvent event) {
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
}
