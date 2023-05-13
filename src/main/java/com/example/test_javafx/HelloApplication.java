package com.example.test_javafx;

import com.example.test_javafx.controller.AccueilController;
import com.example.test_javafx.view.Accueil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Créer la vue
        Accueil view = new Accueil();

        // Créer le contrôleur et lier la vue
        AccueilController controller = new AccueilController(view);

        // Afficher la vue
        Scene scene = new Scene(view, 640, 480);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HPAH");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}