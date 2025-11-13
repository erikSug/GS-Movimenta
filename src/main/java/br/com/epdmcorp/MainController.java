package br.com.epdmcorp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
public class MainController {
    @FXML
    private Button btnSair;

    @FXML
    private void logout(ActionEvent e){
        MainApp.showLoginScene();
    }
}
