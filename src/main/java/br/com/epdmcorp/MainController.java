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

    private VBox homeSection;
    private VBox exercicioSection;
    private VBox aprendaSection;

    private VBox mainSectionConfig(){
        int width = 949;
        int height = 720;
        VBox section = new VBox();
        section.setPrefWidth(width);
        section.setPrefHeight(height);
        section.setAlignment(Pos.TOP_CENTER);
        section.setSpacing(10);
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

    private VBox criarHome() {
        VBox section = mainSectionConfig();
        Label title = tituloConfig("Seu Progresso");

        ImageView face = new ImageView();
        face.setFitWidth(139);
        face.setFitHeight(129);
        face.setPreserveRatio(true);
        // REMOVER DEPOIS
        Image image = new Image(getClass().getResourceAsStream("/br/com/epdmcorp/images/bom.png"));
        face.setImage(image);

        Label faceText = new Label("Excelente proporção! Seu corpo agradece esse cuidado.");
        faceText.setPrefHeight(82);
        faceText.setPrefWidth(230);
        faceText.setTextFill(Color.web("#ff6b35"));
        faceText.prefHeight(82);
        faceText.prefWidth(230);
        faceText.setWrapText(true);
        faceText.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));
        //
        HBox pontoSection = new HBox();
        pontoSection.setAlignment(Pos.CENTER);
        pontoSection.setPadding(new Insets(10));
        pontoSection.setPrefWidth(945);
        pontoSection.setPrefHeight(296);
        pontoSection.setSpacing(100);

        VBox exercicioTrabalhoSection = new VBox();
        exercicioTrabalhoSection.setPrefHeight(295);
        exercicioTrabalhoSection.setPrefWidth(228);

        Label labelExercicio = new Label("Sua pontuação");
        labelExercicio.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));
        labelExercicio.setTextFill(Color.web("#ff6b35"));

        Label numExercicio = new Label("0 pontos");
        numExercicio.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));

        Label labelTrabalho = new Label("Horas Trabalhadas");
        labelTrabalho.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));
        labelTrabalho.setTextFill(Color.web("#ff6b35"));

        Label numTrabalho = new Label("20 Horas");
        numTrabalho.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));

        exercicioTrabalhoSection.getChildren().addAll(labelExercicio, numExercicio, labelTrabalho, numTrabalho);

        VBox equipeSection = new VBox();
        equipeSection.setPrefHeight(295);
        equipeSection.setPrefWidth(228);

        Label labelEquipe = new Label("Meta da equipe");
        labelEquipe.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));
        labelEquipe.setTextFill(Color.web("#ff6b35"));

        Label numEquipe = new Label("0/200");
        numEquipe.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 18));

        equipeSection.getChildren().addAll(labelEquipe, numEquipe);

        pontoSection.getChildren().addAll(exercicioTrabalhoSection, equipeSection);

        section.getChildren().addAll(title,face,faceText, pontoSection);
        return section;
    }
    private VBox criarExercicio(){
        VBox section = mainSectionConfig();
        Label titulo = tituloConfig("Exercícios");

        HBox cardSection = new HBox();
        cardSection.setAlignment(Pos.CENTER);
        cardSection.setPrefWidth(945);
        cardSection.setPrefHeight(519);
        cardSection.setSpacing(100);

        String[][][] exercicioConteudo = {
                {
                        {"/br/com/epdmcorp/images/exercicio_leve.jpg", "Exercícios Leves"},
                        {"5 Pontos pela finalização", "Caminhada (30 Minutos)", "Natação (45 Minutos)", "Musculação Leve (20 Minutos)"}
                },
                {
                        {"/br/com/epdmcorp/images/exercicio_pesado.jpg", "Exercícios Pesados"},
                        {"9 Pontos pela finalização", "Corrida (20 Minutos)", "HIIT (30 Minutos)", "Musculação Pesada (Até o limite)"}
                }
        };

        for(int i = 0; i <exercicioConteudo.length; i++){
            VBox cardLayout = new VBox();
            cardLayout.setStyle("-fx-border-color: black; -fx-border-width: 1; -fx-border-radius: 30;");
            cardLayout.setAlignment(Pos.TOP_CENTER);
            cardLayout.setSpacing(10);
            cardLayout.setPrefWidth(279);
            cardLayout.setPrefHeight(578);
            cardLayout.setPadding(new Insets(10));

            Image image = new Image(getClass().getResourceAsStream(exercicioConteudo[i][0][0]));
            ImageView cardImage = new ImageView(image);
            cardImage.setFitHeight(150);
            cardImage.setFitWidth(200);

            Label cardTitulo = new Label(exercicioConteudo[i][0][1]);
            cardTitulo.setPrefWidth(209);
            cardTitulo.setPrefHeight(55);
            cardTitulo.setFont(Font.font("JetBrains Mono", FontWeight.SEMI_BOLD, 25));

            cardLayout.getChildren().addAll(cardImage, cardTitulo);

            for(int j = 0; j < exercicioConteudo[i][1].length;j++){
                Label conteudoLabel = new Label(exercicioConteudo[i][1][j]);
                conteudoLabel.setFont(Font.font("JetBrains Mono", FontWeight.NORMAL, 14));
                conteudoLabel.setWrapText(true);
                conteudoLabel.setPrefHeight(49);
                conteudoLabel.setPrefWidth(176);
                cardLayout.getChildren().add(conteudoLabel);
            }

            Button btnFinalizar = new Button("Finalizar");
            btnFinalizar.setTextFill(Color.web("#ffffff"));
            btnFinalizar.setStyle("-fx-background-color:  #ff6b35;");
            cardLayout.getChildren().add(btnFinalizar);

            cardSection.getChildren().addAll(cardLayout);
        }

        section.getChildren().addAll(titulo,cardSection);
        return section;
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
        homeSection = criarHome();
        exercicioSection = criarExercicio();
        aprendaSection = criarAprenda();
    }

    @FXML
    private void mostrarHome(){
        mainArea.getChildren().setAll(homeSection);
    }
    @FXML
    private void mostrarExercicio(){
        mainArea.getChildren().setAll(exercicioSection);
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
        try {
            criarConteudo();
            mostrarHome();
        } catch (Exception e) {
            e.printStackTrace();
            Label errorLabel = new Label("Erro ao carregar a interface: " + e.getMessage());
            mainArea.getChildren().setAll(errorLabel);
        }
    }
}
