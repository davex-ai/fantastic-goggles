package com.example.javafx;

import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import javafx.scene.control.PasswordField;
//import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
//import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    @FXML
    private TextField nameField;

    @FXML
    private RadioButton maleRadio;

    @FXML
    private RadioButton femaleRadio;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox reading;


    @FXML
    private CheckBox Gaming;

    @FXML
    private CheckBox traveling;

    @FXML
    private CheckBox termsCheckBox;

    @FXML
    private ImageView profileImg;

    @FXML
    private ToggleGroup genderGrp;

    @FXML
    private File selectedImageFile;

    public void toggle(){
        genderGrp = new ToggleGroup();
        maleRadio.setToggleGroup(genderGrp);
        femaleRadio.setToggleGroup(genderGrp);
    }

    @FXML
    private void register(){
        String name = nameField.getText();
        String email = emailField.getText();
        String pwd = passwordField.getText();

//        maleRadio.setSelected(true);
//
//        String gender = " ";
//        if(maleRadio.isSelected()){
//            gender = "male";
//        } else if (femaleRadio.isSelected()) {
//            gender= "female";
//        }else{
//            gender=" ";
//
//        }
//scene builder for intellij
        StringBuilder hobbies = new StringBuilder();
        if (reading.isSelected()) hobbies.append("reading");
        if (Gaming.isSelected()) hobbies.append("Gaming");
        if (traveling.isSelected()) hobbies.append("travelling");

        // remove last comma and space if any hobbie is selected
        if (hobbies.length()>0){
            hobbies.setLength(hobbies.length()-2);
        }else{
            hobbies.append("None");
        }


        if(name.isEmpty() || email.isEmpty() || pwd.isEmpty()){
            showAlert("Error", "Please fill all the fields");
            return;
        }
        RadioButton selected = (RadioButton) genderGrp.getSelectedToggle();

        if (!selected.isSelected()){
            showAlert("Error", "Please select your gender");
            return;
        }
        if (!termsCheckBox.isSelected()){
            showAlert("Error", "You must accept to the terms and Condition");
            return;
        }

        showAlert("success", "Registered successfully");



    }

    @FXML
    public void clear(){
        nameField.clear();
        emailField.clear();
        passwordField.clear();
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        reading.setSelected(false);
        Gaming.setSelected(false);
        traveling.setSelected(false);
        termsCheckBox.setSelected(false);
        profileImg.setImage(null);
    }
    @FXML
    private void uploadimage() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an image file");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", ".jpg", ".png", "*.gif")
        );

        //show the file section
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            selectedImageFile = file;
            Image image = new Image(file.toURI().toString());
            profileImg.setImage(image);

        }
    }


    private void showAlert(String title, String message){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }





}