package org.example.project.hospitalmanagementsystem.controller.users;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class homepage {

    @FXML
    private Label usernameLabel;

    @FXML
    private Label greetingLabel;

    @FXML
    private Label reminder;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label tipLabel;

    @FXML
    private ListView<String> appointmentsList;

    @FXML
    private MenuButton menuButton;

    private final File tipFile = new File("last_tip.txt");
    private final List<String> tips = List.of(
            "Drink 8 glasses of water a day!",
            "Exercise for at least 30 mins!",
            "Mental health matters — take breaks.",
            "Don’t skip breakfast!",
            "Get 7-8 hours of sleep."
    );


        @FXML
        public void initialize() {
            // Example: add a few fake notifications
            welcomeLabel.setText("Welcome to Trumedix");
            dateLabel.setText("Today is: " + LocalDate.now().toString());
            greetingLabel.setText("How are you today?");
            tipLabel.setText("Drink at least 8 glasses of water today and take regular breaks if you're working!");
            reminder.setText("Your payment plan will be finished next month");

            appointmentsList.getItems().addAll(
                    "10:00 AM - Dr. Smith (Cardiology)",
                    "2:30 PM - Dr. Lee (Dermatology)"
            );
            menuButton.getItems().clear();
            menuButton.getItems().addAll(

                    new MenuItem("Your appointment is confirmed."),
                    new MenuItem("New message from Dr. Clinton."),
                    new MenuItem("Lab results uploaded."),
                    new MenuItem("Your blood test is ready."),
                    new MenuItem("Message from Dr. Patel.")
            );
            loadTipOfTheDay();
        }

    private void loadTipOfTheDay() {
        String tip = tips.get(0);
        LocalDate today = LocalDate.now();

        try {
            if (tipFile.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(tipFile));
                String dateStr = reader.readLine();
                String lastTip = reader.readLine();
                reader.close();

                if (LocalDate.parse(dateStr).equals(today)) {
                    tip = lastTip;
                } else {
                    tip = getRandomTip();
                    saveTip(today.toString(), tip);
                }
            } else {
                tip = getRandomTip();
                saveTip(today.toString(), tip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        tipLabel.setText("Tip of the Day: " + tip);
    }

    private void saveTip(String date, String tip) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(tipFile));
        writer.write(date + "\n" + tip);
        writer.close();
    }

    private String getRandomTip() {
        return tips.get(new Random().nextInt(tips.size()));
    }

        @FXML
        private void handleComplaintForm(MouseEvent event) {
            System.out.println("Redirect to complaint form...");
            // TODO: Load complaint form FXML
              try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/complaint.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(new Scene(root, 1400,800));
                    stage.setMaximized(true);
                } catch (IOException e) {
                    e.printStackTrace();
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
    public void setUsername(String fullname) {
        usernameLabel.setText(fullname);
    }

    @FXML
    private void handleDepartmentPage(MouseEvent event)throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user/departmentuserCard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1400, 800));
            stage.setMaximized(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


