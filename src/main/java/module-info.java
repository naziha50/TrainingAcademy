module com.example.simulatingflighttrainigacademy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simulatingflighttrainigacademy to javafx.fxml;
    exports com.example.simulatingflighttrainigacademy;
}