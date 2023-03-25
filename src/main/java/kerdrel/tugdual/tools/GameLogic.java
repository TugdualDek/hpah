package kerdrel.tugdual.tools;

import kerdrel.tugdual.characters.Boss;
import kerdrel.tugdual.characters.Wizard;
import kerdrel.tugdual.wizarding.*;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {

    SafeScanner scanner = new SafeScanner();
    Console console = new Console();

    private Wizard player;
    private Pet pet;
    private SortingHat hat = new SortingHat();
    private House house = new House(hat.getRandomHouse());
    private Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new  Random().nextInt(10, 16));

    private boolean isRunning;
    private int level = 1;
    private Levels currentLevel;

    public void startGame(){
        boolean nameSet = false;
        String name;
        console.clearConsole();
        console.printSeparator(40);
        console.printSeparator(30);
        console.log("Harry Potter At Home");
        console.log("Made during ISEP A1 year !");
        console.printSeparator(30);
        console.printSeparator(40);
        scanner.anythingToContinue();

        do{
            console.clearConsole();
            console.printHeading("What's your name ?");
            name = scanner.nextStringSafe();


            console.clearConsole();
            console.printHeading("Your name is " + name + ".\n Is that corect ?");
            console.log("(1) Yes !\n(2) No, I want to change my name !");
            int input = scanner.nextIntInRange(1, 2);

            if(input == 1){
                nameSet = true;
            }
        }while(!nameSet);

        console.log("Le choipeau magique va décider de votre sort !");

        console.log("Le choipeau magique a decidé, et ce n'était pas facile, mais votre maison est desormais " + house.getHouse());

        scanner.anythingToContinue();

        console.clearConsole();

        console.log("Vous allez maintenant pouvoir selectionner votre animal de compagnie qui vous accompagnera durant tout le jeu :");
        console.printSeparator(30);
        console.log("(1) - Hibou\n(2) - Rat\n(3) - Chat\n(4) - Crapaud");

        int selection = scanner.nextIntInRange(1, 4);

        switch (selection) {
            case 1 -> pet = Pet.OWL;
            case 2 -> pet = Pet.RAT;
            case 3 -> pet = Pet.CAT;
            case 4 -> pet = Pet.TOAD;
            default -> {
                System.out.println("Vous n'avez pas selectionné un bon animal, nous allons le faire pour vous !");
                pet = Pet.values()[new Random().nextInt(Pet.values().length)];
            }
        }
        console.log("Très bon choix, votre animal de compagnie est donc un " + pet.getName());

        console.log("Nous allons maintenant vous fournir une baguette qui vous correspondra au mieux !");



        console.log("Une baguette de type " + wand.getCore().getName() + " et de " + wand.getSize() + "cm vous a choisie !");

        player = Wizard.builder().name(name).health(100).shield(100).attackPower(10).pet(pet).wand(wand).house(house).build();

        isRunning = true;

        gameLoop();
    }

    public void checkLevel(){

        //get all the informations from the enum Levels that corresponds to the current level

        currentLevel = Levels.values()[level - 1];

        // go to next level if the boss of the currentLevel is dead
        if(currentLevel.getBoss().getHealth() <= 0){
            level++;
        }


    }

    public void continueJourney(){

        checkLevel();
        for(String text : currentLevel.getText()){
            console.clearConsole();
            console.log(text);
            scanner.anythingToContinue();
        }
        battle(currentLevel.getBoss());

        scanner.anythingToContinue();

    }

    private void battle(Boss boss) {
        while(true){

            console.clearConsole();
            console.printHeading(boss.getName() + "\nHP: " + boss.getHealth() + "/" + boss.getMaxHealth());
            console.printHeading(player.getName() + "\nHP: " + player.getHealth() + "/" + player.getMaxHealth());
            System.out.println("Choose an action :");
            console.printSeparator(20);
            System.out.println("(1) Attack\n(2) Potion\n(3) Run");

            int input = scanner.nextIntInRange(1, 3);

            if (input == 1) {

                int damages = player.attack() - boss.defend();
                int damagesTook = boss.attack() - player.defend();

                if(damagesTook < 0){
                    damages -= damagesTook/2;
                    damagesTook = 0;
                }

                if(damages < 0){
                    damages = 0;
                }

                player.setHealth(player.getHealth() - damagesTook);
                boss.setHealth(boss.getHealth() - damages);

                console.clearConsole();
                console.printHeading("Battle");
                System.out.println("You dealt " + damages + " damages to the " + boss.getName() + " !");
                console.printSeparator(20);
                System.out.println("The " + boss.getName() + " dealt " + damagesTook + " damages to you !");
                scanner.anythingToContinue();

                if(player.getHealth() <= 0){
                    playerDied();
                    break;
                } else if(boss.getHealth() <= 0){
                    console.clearConsole();
                    console.printHeading("You killed the " + boss.getName() + " !");

                    //random drops, such as potions for example

                    scanner.anythingToContinue();
                    break;
                }

            } else if (input == 2) {

                /*clearConsole();
                if(player.pots > 0 && player.hp < player.maxHp){
                    printHeading("Do you want to drink a potion? (" + player.pots + " left).");
                    System.out.println("(1) Yes\n(2) No, maybe later");
                    input = readInt("-> ", 2);
                    if(input == 1){
                        //player actually took it
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank a magic potion. It restored your health back to " + player.maxHp);
                        anythingToContinue();
                    }
                }else{
                    //player CANNOT take a potion
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }*/

            } else if (input == 3) {

                console.clearConsole();

                    if (Math.random()*10 + 1 <= 3.5) {
                        console.printHeading("You ran away from the " + boss.getName() + " !");
                        scanner.anythingToContinue();
                        break;
                    } else {
                        System.out.println("You couldn't run away !");
                        scanner.anythingToContinue();

                        int damagesTook = boss.attack() - player.defend();
                        System.out.println("In your hurry, the " + boss.getName() + " dealt " + damagesTook + " damages to you !");
                        player.setHealth(player.getHealth() - damagesTook);
                        scanner.anythingToContinue();

                        if(player.getHealth() <= 0){
                            playerDied();
                            break;
                        }
                    }


            }
        }
    }

    public void printMenu(){
        console.clearConsole();
        console.printHeading("Choisir une action :");
        console.printSeparator(20);
        System.out.println("(1) Continuer votre aventure");
        System.out.println("(2) Information sur votre personnage");
        System.out.println("(3) Quitter le jeu");
    }

    public void characterInfo(){
        console.clearConsole();
        console.printHeading("INFO JOUEUR");
        System.out.println(player.getName() + "\tHP: " + player.getHealth() + "/" + player.getMaxHealth() + "\tShield: " + player.getShield());
        console.printSeparator(20);
        //# of pots
        //System.out.println("# of Potions: " + player.pots);
        //printSeparator(20);

        //printing the chosen traits
//        if(player.numAttUpgrades > 0){
//            System.out.println("Offensive trait: " + player.attUpgrades[player.numAttUpgrades - 1]);
//            printSeparator(20);
//        }
//        if(player.numDefUpgrades > 0){
//            System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
//        }

        scanner.anythingToContinue();
    }

    public void playerDied(){
        console.clearConsole();
        console.printHeading("You died !");
        isRunning = false;
    }

    public void gameLoop(){
        while(isRunning){
            printMenu();
            int input = scanner.nextIntInRange(1, 3);
            if(input == 1){
                continueJourney();
            } else if(input == 2){
                characterInfo();
            } else {
                console.log("Merci de jouer à mon jeu, à bientôt pour une nouvelle aventure !");
                isRunning = false;
            }
        }
    }

}
