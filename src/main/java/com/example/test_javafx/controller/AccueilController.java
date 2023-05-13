package com.example.test_javafx.controller;

import com.example.test_javafx.view.Accueil;
import com.example.test_javafx.view.Jeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccueilController {

    private Accueil view;

    public AccueilController(Accueil view) {
        this.view = view;

        // Ajouter des gestionnaires d'événements pour les boutons
        view.getJouerBtn().setOnAction(e -> handleJouerBtn(e));
        view.getQuitterBtn().setOnAction(e -> handleQuitterBtn(e));
    }

    public void handleJouerBtn(ActionEvent event) {
        // Effacer tout le contenu de la vue
        view.getChildren().clear();

        // Créer une nouvelle instance de la vue "NouvelleVue"
        Jeu nouvelleVue = new Jeu();

        // Créer le contrôleur et lier la vue
        JeuController controller = new JeuController(nouvelleVue);

        // Ajouter la nouvelle vue à la scène
        Scene scene = new Scene(nouvelleVue, 640, 480);

        // Obtenir la fenêtre actuelle et définir la nouvelle scène
        Stage stage = (Stage) view.getScene().getWindow();
        stage.setScene(scene);
    }

    public void handleQuitterBtn(ActionEvent event) {
        // Quitter l'application
        System.exit(0);
    }
}