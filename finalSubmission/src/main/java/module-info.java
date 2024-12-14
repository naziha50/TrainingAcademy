module com.example.finalsubmission {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens com.example.finalsubmission to javafx.fxml;
    exports com.example.finalsubmission;
}