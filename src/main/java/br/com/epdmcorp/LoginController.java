package br.com.epdmcorp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

public class LoginController {
    @FXML
    private TextField txtUsuario;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnLogin;

    @FXML
    private void handleLogin(ActionEvent e){
        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals("teste") && senha.equals("123")){
            System.out.println("Acesso liberado");
            MainApp.showMainScene();
        } else{
            System.out.println("Login ou senha incorreta!");
        }
    }
}
