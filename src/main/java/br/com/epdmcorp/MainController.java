package br.com.epdmcorp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnSair;

    @FXML
    private VBox mainArea;

    private VBox aprendaSection;

    private VBox mainSectionConfig(){
        int width = 949;
        int height = 720;
        VBox section = new VBox();
        section.setPrefWidth(width);
        section.setPrefHeight(height);
        section.setAlignment(Pos.CENTER);

        return section;
    }

    private Label tituloConfig(String titulo){
        int tamanho = 71;
        String font = "JetBrains Mono";
        String cor = "#ff6b35";

        Label label = new Label(titulo);
        label.setFont(Font.font(font, FontWeight.NORMAL, tamanho));
        label.setTextFill(Color.web(cor));
        return label;
    }

    private VBox criarAprenda(){
        VBox section = mainSectionConfig();

        Label titulo = tituloConfig("Aprenda");

        section.getChildren().addAll(titulo);
        return section;
    }

    private void criarConteudo(){
        aprendaSection = criarAprenda();
    }

    @FXML
    private void mostrarAprenda(){
        mainArea.getChildren().setAll(aprendaSection);
    }

    @FXML
    private void logout(ActionEvent e){
        MainApp.showLoginScene();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criarConteudo();
        mostrarAprenda();
    }
}
