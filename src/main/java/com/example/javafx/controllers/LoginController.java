package com.example.javafx.controllers;

import com.example.javafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLogin(ActionEvent event) {

        String username = usernameField.getText();
        String password = passwordField.getText();

        if ("naziha".equals(username) && "password123".equals(password)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/dashboard.fxml")); // Update path to your dashboard.fxml
                Scene scene = new Scene(fxmlLoader.load(), 800, 600);

                // Get the current stage from the event
                Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                stage.setTitle("Instructor Dashboard");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                errorLabel.setText("Error loading dashboard.");
            }
        } else {
            errorLabel.setText("Invalid credentials.");
        }

    }
}
