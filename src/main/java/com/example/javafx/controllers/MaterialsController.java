package com.example.javafx.controllers;

import com.example.javafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.io.IOException;

public class MaterialsController {

    @FXML
    private void handleUpload(ActionEvent event) {

    }

    @FXML
    private void goBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/sessionDetails.fxml")); // Update path to your dashboard.fxml
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);

            // Get the current stage from the event
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setTitle("Instructor Panel | Session Details");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
