package com.example.test_javafx.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Jeu extends VBox {

    private Label titreLabel;
    private ChoiceBox<String> choixBox1;
    private ChoiceBox<String> choixBox2;
    private Button attaquerBtn;
    private Button potionBtn;
    private Button fuirBtn;
    private Button voirInfosBtn;
    private Button continuerBtn;

    public Jeu() {
        // Créer les éléments de la vue
        titreLabel = new Label("Bienvenue à Poudlard !");
        titreLabel.setWrapText(true);

        choixBox1 = new ChoiceBox<>();
        choixBox2 = new ChoiceBox<>();

        attaquerBtn = new Button("Attaquer");
        potionBtn = new Button("Prendre une potion");
        fuirBtn = new Button("Fuir");
        voirInfosBtn = new Button("Voir infos");
        continuerBtn = new Button("Continuer");

        // Ajouter les éléments à la vue
        HBox boutonsHBox = new HBox(10, attaquerBtn, potionBtn, fuirBtn, voirInfosBtn, continuerBtn);
        boutonsHBox.setAlignment(Pos.CENTER);

        HBox choixBoxHBox = new HBox(10, new Label("Sorts :"), choixBox1, new Label("Potions :"), choixBox2);
        choixBoxHBox.setAlignment(Pos.CENTER);

        StackPane stackPane = new StackPane(choixBoxHBox);
        stackPane.setAlignment(Pos.CENTER);

        this.getChildren().addAll(titreLabel, stackPane, boutonsHBox);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));
        this.setSpacing(20);
    }

    public Label getTitreLabel() {
        return titreLabel;
    }

    public ChoiceBox<String> getChoixBox1() {
        return choixBox1;
    }

    public ChoiceBox<String> getChoixBox2() {
        return choixBox2;
    }

    public Button getAttaquerBtn() {
        return attaquerBtn;
    }

    public Button getPotionBtn() {
        return potionBtn;
    }

    public Button getFuirBtn() {
        return fuirBtn;
    }

    public Button getVoirInfosBtn() {
        return voirInfosBtn;
    }

    public Button getContinuerBtn() {
        return continuerBtn;
    }

    public void setTitreLabel(Label titreLabel) {
        this.titreLabel = titreLabel;
    }

    public void setChoixBox1(ChoiceBox<String> choixBox1) {
        this.choixBox1 = choixBox1;
    }

    public void setChoixBox2(ChoiceBox<String> choixBox2) {
        this.choixBox2 = choixBox2;
    }

    public void setAttaquerBtn(Button attaquerBtn) {
        this.attaquerBtn = attaquerBtn;
    }

    public void setPotionBtn(Button potionBtn) {
        this.potionBtn = potionBtn;
    }

    public void setFuirBtn(Button fuirBtn) {
        this.fuirBtn = fuirBtn;
    }

    public void setVoirInfosBtn(Button voirInfosBtn) {
        this.voirInfosBtn = voirInfosBtn;
    }

    public void setContinuerBtn(Button continuerBtn) {
        this.continuerBtn = continuerBtn;
    }
}
