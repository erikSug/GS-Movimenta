module com.example.movimenta {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;


    opens br.com.epdmcorp to javafx.fxml;
    exports br.com.epdmcorp;
}