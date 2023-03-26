package kerdrel.tugdual.tools;

import kerdrel.tugdual.characters.AbstractEnemy;
import kerdrel.tugdual.characters.Boss;
import kerdrel.tugdual.characters.Enemy;
import kerdrel.tugdual.characters.Wizard;
import kerdrel.tugdual.ressources.Levels;
import kerdrel.tugdual.wizarding.*;

import java.util.Random;

public class GameLogic {

    //
    // Fields
    //
    SafeScanner scanner = new SafeScanner();
    Console console = new Console();

    private Wizard player;
    private Pet pet;
    private SortingHat hat = new SortingHat();
    private House house = new House(hat.getRandomHouse());
    private Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new Random().nextInt(10, 16));

    private boolean isRunning;
    private int level = 1;
    private Levels currentLevel;

    //
    // Constructors
    //
    public GameLogic() {
    }

    //
    // Methods
    //

    /**
     * Method startGame
     * Starts the game
     */
    public void startGame() {
        boolean nameSet = false;
        String name;
        console.clearConsole();
        console.printSeparator(40);
        console.printSeparator(30);
        console.log("Harry Potter At Home\nMade by Tugdual Audren de Kerdrel");
        console.printSeparator(30);
        console.printSeparator(40);
        scanner.anythingToContinue();

        do {
            console.clearConsole();
            console.printHeading("What's your name ?");
            name = scanner.nextStringSafe();

            console.clearConsole();
            console.printHeading("Your name is " + name + ".\n Is that corect ?");
            console.log("(1) Yes !\n(2) No, I want to change my name !");
            int input = scanner.nextIntInRange(1, 2);
            if (input == 1) {
                nameSet = true;
            }
        } while (!nameSet);

        console.log("The sorting hat will decide your fate !\nThe sorting hat decided, and it was not easy, but your home is now " + house.getHouse());
        scanner.anythingToContinue();
        console.clearConsole();
        console.log("You will now be able to select your pet that will accompany you throughout the game:");
        console.printSeparator(30);
        console.log("(1) - Owl\n(2) - Rat\n(3) - Cat\n(4) - Toad");

        int selection = scanner.nextIntInRange(1, 4);

        switch (selection) {
            case 1 -> pet = Pet.OWL;
            case 2 -> pet = Pet.RAT;
            case 3 -> pet = Pet.CAT;
            case 4 -> pet = Pet.TOAD;
            default -> {
                console.log("You didn't select a good animal, we will do it for you !");
                pet = Pet.values()[new Random().nextInt(Pet.values().length)];
            }
        }
        console.log("Very good choice, your pet is therefore a " + pet.getName() + "\nWe will now provide you with a wand that will best suit you!");

        console.log("A wand of type " + wand.getCore().getName() + " and of " + wand.getSize() + "cm has chosen you !");

        scanner.anythingToContinue();

        player = Wizard.builder().name(name).health(100).shield(100).attackPower(10).pet(pet).wand(wand).house(house).build();

        isRunning = true;

        gameLoop();
    }

    /**
     * Method checkLevel
     * Will check the informations of the current level and will go to the next level if the boss is dead
     */
    public void checkLevel() {

        //get all the informations from the enum Levels that corresponds to the current level
        currentLevel = Levels.values()[level - 1];


        // go to next level if the boss of the currentLevel is dead
        if (currentLevel.getBoss().getHealth() <= 0) {
            level++;
            currentLevel = Levels.values()[level - 1];
        }


    }

    /**
     * Method continueJourney
     * Will continue the journey of the player
     * will print the texts of the level and will fight against the boss of the level
     */
    public void continueJourney() {

        //we will check the actual level and if the boss is dead, we will go to the next level
        checkLevel();
        console.clearConsole();

        //we print the texts from the level
        for (String text : currentLevel.getText()) {
            console.log(text);
        }

        scanner.anythingToContinue();
        //we fight against the boss of the level

        // if there is en enemy in the level, we will fight against it before we fight against the boss

        if (currentLevel.getEnemy() != null) {
            battle(currentLevel.getEnemy());
        }

        battle(currentLevel.getBoss());

        console.log("You have defeated the boss of the level !");

        scanner.anythingToContinue();

    }

    /**
     * Method battle
     * Will start a battle between the player and the boss
     *
     * @param boss the boss that the player will fight against
     */
    private void battle(AbstractEnemy currentEnemy) {

        while (true) {

            console.clearConsole();
            console.printHeading(currentEnemy.getName() + "\nHP: " + currentEnemy.getHealth() + "/" + currentEnemy.getMaxHealth());
            console.printHeading(player.getName() + "\nHP: " + player.getHealth() + "/" + player.getMaxHealth());
            System.out.println("Choose an action :");
            console.printSeparator(20);
            System.out.println("(1) Attack\n(2) Potion\n(3) Run");

            int input = scanner.nextIntInRange(1, 3);

            if (input == 1) {

                float damages = player.attack() - currentEnemy.defend();
                float damagesTook = currentEnemy.attack() - player.defend();

                if (damagesTook < 0) {
                    damages -= damagesTook / 2;
                    damagesTook = 0;
                }

                if (damages < 0) {
                    damages = 0;
                }

                player.setHealth(player.getHealth() - damagesTook);
                currentEnemy.setHealth(currentEnemy.getHealth() - damages);

                console.clearConsole();
                console.printHeading("Battle");
                System.out.println("You dealt " + damages + " damages to the " + currentEnemy.getName() + " !");
                console.printSeparator(20);
                System.out.println("The " + currentEnemy.getName() + " dealt " + damagesTook + " damages to you !");
                scanner.anythingToContinue();

                if (player.getHealth() <= 0) {
                    playerDied();
                    break;
                } else if (currentEnemy.getHealth() <= 0) {
                    console.clearConsole();
                    console.printHeading("You killed the " + currentEnemy.getName() + " !");

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

                if (Math.random() * 10 + 1 <= 3.5) { // 35% chance to run away
                    console.printHeading("You ran away from the " + currentEnemy.getName() + " !");
                    scanner.anythingToContinue();
                    break;
                } else {
                    System.out.println("You couldn't run away !");
                    scanner.anythingToContinue();

                    float damagesTook = currentEnemy.attack() - player.defend();
                    System.out.println("In your hurry, the " + currentEnemy.getName() + " dealt " + damagesTook + " damages to you !");
                    player.setHealth(player.getHealth() - damagesTook);
                    scanner.anythingToContinue();

                    if (player.getHealth() <= 0) {
                        playerDied();
                        break;
                    }
                }
            }
        }
    }

    /**
     * Method printMenu
     * Will print the menu of the game before the player choose an action
     */
    public void printMenu() {
        console.clearConsole();
        console.printHeading("Choose an action :");
        console.printSeparator(20);
        System.out.println("(1) Continue your journey");
        System.out.println("(2) Wizard information");
        System.out.println("(3) Exit the game");
    }

    /**
     * Method characterInfo
     * Will print the informations of the wizard
     */
    public void characterInfo() {
        console.clearConsole();
        console.printHeading("WAZRD INFORMATIONS");
        System.out.println(player.getName() + "\tHP: " + player.getHealth() + "/" + player.getMaxHealth() + "\tShield: " + player.getShield());
        console.printSeparator(20);
        //# of pots
        //System.out.println("# of Potions: " + player.pots);
        //printSeparator(20);
        scanner.anythingToContinue();
    }

    /**
     * Method playerDied
     * Will print the message when the player died
     */
    public void playerDied() {
        console.clearConsole();
        console.printHeading("You died !");
        scanner.close();
        isRunning = false;
    }

    /**
     * Method gameLoop
     * Will loop the game until the player choose to exit
     */
    public void gameLoop() {
        while (isRunning) {
            printMenu();
            int input = scanner.nextIntInRange(1, 3);
            if (input == 1) {
                continueJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                console.log("Thanks for playing my game ! See you soon !");
                scanner.close();
                isRunning = false;
            }
        }
    }

}
