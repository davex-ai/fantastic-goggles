package org.example.project.hospitalmanagementsystem.controller.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BaseAdminController {

    protected void goBackToAdminPage(Node sourceNode) {
            try {
                Parent adminRoot = FXMLLoader.load(getClass().getResource("/fxml/admin/adminpage.fxml"));
                Stage stage = (Stage) sourceNode.getScene().getWindow();
                stage.getScene().setRoot(adminRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    protected  void  patients (Node sourceNode){
        try {
            AnchorPane adminRoot = FXMLLoader.load(getClass().getResource("/fxml/admin/adminpage.fxml"));
            Scene scene = sourceNode.getScene();
            scene.setRoot(adminRoot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void closePopupWindow(Node sourceNode) {
        Stage stage = (Stage) sourceNode.getScene().getWindow();
        stage.close(); // Useful for Doctor Form modals
    }
}

