package br.com.epdmcorp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Erro no login");
            alert.setContentText("Usuário ou senha incorretos!");
            alert.showAndWait();
        }
    }
}
