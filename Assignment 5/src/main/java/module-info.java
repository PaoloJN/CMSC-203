module com.example.assignment5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment5 to javafx.fxml;
    exports com.example.assignment5;
}