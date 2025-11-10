module com.example.movimenta {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens br.com.epdmcorp to javafx.fxml;
    exports br.com.epdmcorp;
}