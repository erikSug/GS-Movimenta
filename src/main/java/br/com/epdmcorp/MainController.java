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
import javafx.scene.text.TextAlignment;

import java.awt.*;
import java.net.URI;
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

    private void abrirLink(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)) {
                    desktop.browse(new URI(url));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erro ao abrir o link: " + url);
        }
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
            col.setMaxWidth(300.0);
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
                {"/br/com/epdmcorp/images/card_cadeirante.jpg","Musculação para Cadeirantes","Conheça 7 exercícios para cadeirantes.","https://freedom.ind.br/musculacao-para-cadeirantes/"},
                {"/br/com/epdmcorp/images/card_ferias.jpg","Treino de Férias","5 exercícios para fazer com os amigos.","https://www.smartfit.com.br/news/fitness/treino-de-ferias-exercicios-rapidos/"},
                {"/br/com/epdmcorp/images/card_trabalho.jpg","Trabalho e exercício", "4 razões para se exercitar antes do expediente.", "https://forbes.com.br/carreira/2024/11/4-razoes-para-se-exercitar-antes-do-fim-do-expediente/"}
        };

        for(int i = 0; i < aprendaConteudo.length; i++){
            HBox card = new HBox(10);
            card.setPadding(new Insets(10));
            card.setAlignment(Pos.CENTER);
            card.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 30;");
            card.setPrefHeight(100);
            card.setPrefWidth(270);

            Image image = new Image(getClass().getResourceAsStream(aprendaConteudo[i][0]));
            ImageView cardImage = new ImageView(image);
            cardImage.setFitHeight(84);
            cardImage.setFitWidth(110);

            VBox cardConteudo = new VBox();
            cardConteudo.setAlignment(Pos.TOP_CENTER);
            cardConteudo.setPadding(new Insets(10));

            Label cardTitulo = new Label(aprendaConteudo[i][1]);
            cardTitulo.setFont(Font.font("JetBrains Mono", FontWeight.SEMI_BOLD, 12));
            cardTitulo.setWrapText(true);
            cardTitulo.setPrefHeight(42);
            cardTitulo.setPrefWidth(155);
            cardTitulo.setTextAlignment(TextAlignment.CENTER);

            Label cardDesc = new Label(aprendaConteudo[i][2]);
            cardDesc.setPrefHeight(60);
            cardDesc.setPrefWidth(140);
            cardDesc.setWrapText(true);

            Button saibaMais = new Button("Saiba Mais!");
            saibaMais.setTextFill(Color.web("#ffffff"));
            saibaMais.setStyle("-fx-background-color:  #ff6b35;");
            final String linkUrl = aprendaConteudo[i][3];
            saibaMais.setOnAction(event -> abrirLink(linkUrl));

            cardConteudo.getChildren().addAll(cardTitulo, cardDesc, saibaMais);
            card.getChildren().addAll(cardImage,cardConteudo);

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
