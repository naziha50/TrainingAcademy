package com.example.javafx.controllers;

import com.example.javafx.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class QuizParticipationController {

    @FXML
    private Label quizTitle;

    @FXML
    private Label quizDescription;

    @FXML
    private Label questionLabel;

    @FXML
    private TextArea questionText;

    @FXML
    private VBox optionsBox;

    @FXML
    private Button previousButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button submitButton;

    @FXML
    private Label timerLabel;

    private int currentQuestionIndex = 0;
    private final int totalQuestions = 10; // Example value

    @FXML
    public void initialize() {
        // Initialize quiz data (e.g., load from a service or database)
        quizTitle.setText("Sample Quiz");
        quizDescription.setText("This is a sample quiz description.");

        loadQuestion(currentQuestionIndex);
    }

    private void loadQuestion(int questionIndex) {
        questionLabel.setText("Question " + (questionIndex + 1) + "/" + totalQuestions);
        questionText.setText("This is the text for question " + (questionIndex + 1) + ".");

        optionsBox.getChildren().clear();
        for (int i = 1; i <= 4; i++) {
            RadioButton option = new RadioButton("Option " + i);
            optionsBox.getChildren().add(option);
        }

        // Enable/Disable navigation buttons based on current question
        previousButton.setDisable(questionIndex == 0);
        nextButton.setDisable(questionIndex == totalQuestions - 1);
    }

    @FXML
    private void handlePrevious() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion(currentQuestionIndex);
        }
    }

    @FXML
    private void handleNext() {
        if (currentQuestionIndex < totalQuestions - 1) {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        }
    }

    @FXML
    private void handleSubmit() {
        // Handle quiz submission logic
        System.out.println("Quiz Submitted!");
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
