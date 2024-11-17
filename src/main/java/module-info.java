module com.example.krest_and_null {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.krest_and_null to javafx.fxml;
    exports com.example.krest_and_null;
}