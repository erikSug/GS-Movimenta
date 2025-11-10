module com.example.movimenta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.movimenta to javafx.fxml;
    exports com.example.movimenta;
}