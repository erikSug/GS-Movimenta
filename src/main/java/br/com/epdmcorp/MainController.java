package br.com.epdmcorp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
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
        section.setAlignment(Pos.TOP_CENTER);

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

        //        SETUP DO GRID
        GridPane grid = new GridPane();
        grid.setHgap(9);
        grid.setVgap(9);
        grid.setAlignment(Pos.CENTER);

        for (int i = 0; i < 2; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setMaxWidth(280.0);
            col.setMinWidth(10.0);
            grid.getColumnConstraints().add(col);
        }

        for (int i = 0; i < 3; i++) {
            RowConstraints row = new RowConstraints();
            row.setMinHeight(10.0);
            row.setPrefHeight(200.0);
            grid.getRowConstraints().add(row);
        }

        String[][] aprendaConteudo = {
                {"/br/com/epdmcorp/images/card_cadeirante.jpg","Musculação para Cadeirantes","Conheça 7 exercícios para cadeirantes"},
                {"/br/com/epdmcorp/images/card_cadeirante.jpg","Musculação para Cadeirantes","Conheça 7 exercícios para cadeirantes"}
        };

        for(int i = 0; i < aprendaConteudo.length; i++){
            HBox card = new HBox(10);
            card.setAlignment(Pos.CENTER);
            card.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 30;");
            card.setPrefHeight(100);
            card.setPrefWidth(250);

            Image image = new Image(getClass().getResourceAsStream(aprendaConteudo[i][0]));
            ImageView cardImage = new ImageView(image);

            Label cardTitulo = new Label(aprendaConteudo[i][1]);
            Label cardDesc = new Label(aprendaConteudo[i][2]);

            card.getChildren().addAll(cardImage, cardTitulo, cardDesc);

            grid.add(card,i % 2,i/2);
        }

        section.getChildren().addAll(titulo,grid);
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
