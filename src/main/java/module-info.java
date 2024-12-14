module com.example.flighttrainingacademy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.flighttrainingacademy to javafx.fxml;
    exports com.example.flighttrainingacademy;
}