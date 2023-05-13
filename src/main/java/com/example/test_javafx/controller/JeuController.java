package com.example.test_javafx.controller;

import com.example.test_javafx.characters.Wizard;
import com.example.test_javafx.ressources.Levels;
import com.example.test_javafx.spells.Spell;
import com.example.test_javafx.view.Jeu;
import com.example.test_javafx.wizarding.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Random;

public class JeuController {

    private Jeu view;

    // Player, pet, house, wand, and SortingHat objects for game setup
    private Wizard player;
    private Pet pet = Pet.values()[new Random().nextInt(Pet.values().length)];
    private SortingHat hat = new SortingHat();
    private House house = hat.getRandomHouse();
    private Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new Random().nextInt(10, 16));

    // Game state variables
    private boolean isRunning = false;
    private boolean hasChosenAction = false;
    private int level = 1;
    private Levels currentLevel;

    // Battle state variable
    private boolean inBattle = false;

    // instanciate an arraylist of forbidden spells with one called Avada Kedavra
    private ArrayList<Spell> forbiddenSpells = new ArrayList<>();


    private String[] startTexts = {"You have been accepted to Hogwarts, congratulations !", "The sorting hat will decide your fate !\nThe sorting hat decided, and it was not easy, but your home is now " + this.house.getHouse(), "your pet is a " + pet.getName(), "\nWe will now provide you with a wand that will best suit you!\nA wand of type " + wand.getCore().getName() + " and of " + wand.getSize() + "cm has chosen you !"};
    private int counter = 0;

    public JeuController(Jeu view) {
        this.view = view;

        forbiddenSpells.add(Spell.builder().name("Avada Kedavra").damage(80).build());
        view.getAttaquerBtn().setDisable(true);
        view.getPotionBtn().setDisable(true);
        view.getFuirBtn().setDisable(true);
        view.getVoirInfosBtn().setDisable(true);

        String name = "Wizard";

        player = Wizard.builder().name(name).health(150 + house.getHealthEfficacity()).shield(20).attackPower(15 + house.getSpellEfficacity()).pet(pet).wand(wand).house(house).precision(50 + house.getPrecisionEfficacity()).build();
        player.setKnownSpells((Spell) Spell.builder().name("Wingardium Leviosa").damage(10).build());

        // Populate the choice boxes
        view.getChoixBox1().getItems().addAll("Sort 1", "Sort 2", "Sort 3");
        view.getChoixBox2().getItems().addAll("Potion 1", "Potion 2", "Potion 3");

        // Changer le texte du bouton attaquer à chaque clic
        view.getContinuerBtn().setOnAction(event -> handleContinuerButton(event));
        //view.getAttaquerBtn().setOnAction(event -> handleAttaquerButton(event));
        //view.getPotionBtn().setOnAction(event -> handlePotionButton(event));
        //view.getFuirBtn().setOnAction(event -> handleFuirButton(event));
        view.getVoirInfosBtn().setOnAction(event -> handleVoirInfosButton(event));
    }

    public void handleContinuerButton(ActionEvent e) {
        if (!isRunning) {
            // afficher chaque string du tableau startTexts à chaque clic
            if (counter < startTexts.length) {
                view.getTitreLabel().setText(startTexts[counter]);
                counter++;
            } else {
                view.getTitreLabel().setText("You are now ready to play !");
                view.getAttaquerBtn().setDisable(false);
                view.getPotionBtn().setDisable(false);
                view.getFuirBtn().setDisable(false);
                view.getVoirInfosBtn().setDisable(false);

                isRunning = true;
            }
        } else {
            if(view.getTitreLabel().getText().equals("Choose your action : \n 1. Continue your journey (continuer) \n 2. Wizard Information (see info)")) {
                hasChosenAction = true;
                counter = 0;
                view.getContinuerBtn().setOnAction(event -> handleContinuerGameButton(event));
            } else {
                hasChosenAction = false;
                view.getTitreLabel().setText("Choose your action : \n 1. Continue your journey (continuer) \n 2. Wizard Information (see info)");
            }
        }
    }

    private void handleContinuerGameButton(ActionEvent event) {
        //we will check the actual level and if the boss is dead, we will go to the next level
        checkLevel();
        //at each click, we will print the text of the level
        if (counter < currentLevel.getText().length) {
            view.getTitreLabel().setText(currentLevel.getText()[counter]);
            counter++;
        } else {
            continueJourney();
        }
    }


    public void handleVoirInfosButton(ActionEvent e) {
        if (isRunning) {
            view.getTitreLabel().setText(player.getName() + " stats =>\tHP: " + player.getHealth() + "/" + player.getMaxHealth() + "\tAttack: " + player.getAttackPower() + "\tShield: " + player.getShield() + "\n" + "You have " + player.getPotions().size() + " potion(s) in your inventory");
        }
    }

    public void checkLevel() {

        // Get all the informations from the enum Levels that corresponds to the current level
        currentLevel = Levels.values()[level - 1];

        // Go to next level if the boss of the currentLevel is dead
        if (currentLevel.getBoss().getHealth() <= 0) {
            // Get the spellLearnt at the end of the level
            Spell spellLearnt = currentLevel.getSpellLearnt();
            // If the spellLearnt is not null, we will add it to the list of known spells of the player
            if (spellLearnt != null) {
                player.setKnownSpells(spellLearnt);
                view.getTitreLabel().setText("You learnt a new spell : " + spellLearnt.getName());
                view.getContinuerBtn().setOnAction(event -> handleContinuerButton(event));
            }

            level++;
            currentLevel = Levels.values()[level - 1];
            // If the current level is the last level, start the final battle
            if (level == Levels.values().length) {
                //finalBattle();
                view.getTitreLabel().setText("You have reached the final level !");
            }
        }
    }

    public void continueJourney() {


        // if there is en enemy in the level, we will fight against it before we fight against the boss
        if (currentLevel.getEnemy() != null) {
            inBattle = true;
            //battle(currentLevel.getEnemy(), false);
            System.out.println("You are in a battle against an enemy");
        }

        inBattle = true;
        //battle(currentLevel.getBoss(), false);
        System.out.println("You are in a battle against the boss of the level");
        currentLevel.getBoss().setHealth(0);
        inBattle = false;

        view.getTitreLabel().setText("You have defeated the boss of the level !");

        view.getContinuerBtn().setOnAction(event -> handleContinuerButton(event));

    }
}