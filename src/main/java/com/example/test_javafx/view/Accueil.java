package com.example.test_javafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Accueil extends VBox {

    private Button jouerBtn;
    private Button quitterBtn;

    public Accueil() {
        // Créer le texte d'accueil
        Label label = new Label("Bienvenue cher aventurier !");

        // Créer les boutons
        jouerBtn = new Button("Jouer");
        quitterBtn = new Button("Quitter");

        // Créer un espaceur pour centrer les boutons horizontalement
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        // Créer une boîte horizontale pour les boutons et l'espaceur
        HBox buttonBox = new HBox(jouerBtn, spacer, quitterBtn);

        // Créer une boîte verticale pour le texte et les boutons
        this.getChildren().addAll(label, buttonBox);

        // Aligner le texte et les boutons au centre
        this.setAlignment(Pos.CENTER);

        // Ajouter une marge autour des boutons
        setMargin(buttonBox, new Insets(20));

        // Rendre la vue responsive
        this.setFillWidth(true);
    }

    public Button getJouerBtn() {
        return jouerBtn;
    }

    public Button getQuitterBtn() {
        return quitterBtn;
    }
}
