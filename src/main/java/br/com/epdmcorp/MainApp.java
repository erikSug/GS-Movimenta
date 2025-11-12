package br.com.epdmcorp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApp extends Application {
    private static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        showLoginScene();
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/br/com/epdmcorp/login.fxml"));
//        Parent root = loader.load();
//
//        Scene scene = new Scene(root);
//
//        stage.setTitle("Movimenta");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void showLoginScene(){
        loadScene("/br/com/epdmcorp/login.fxml", "Movimenta - Login");
    }
    public static void showMainScene(){
        loadScene("/br/com/epdmcorp/main.fxml", "Movimenta - Main");
    }

    private static void loadScene(String fxmlPath, String title) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(
                    MainApp.class.getResource(fxmlPath)
            ));

            Scene scene = new Scene(root);
            primaryStage.setTitle(title);
            primaryStage.setScene(scene);
            primaryStage.setMinWidth(1280);
            primaryStage.setMinHeight(720);
            primaryStage.show();

        } catch (IOException e) {
            System.err.println("Error loading scene: " + fxmlPath);
        }
    }
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}