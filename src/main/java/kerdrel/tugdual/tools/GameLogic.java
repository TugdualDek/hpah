package kerdrel.tugdual.tools;

import kerdrel.tugdual.characters.AbstractEnemy;
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

        //each pet will have a different attack power that willa dd to the player's attack power

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

        //the last level is the final boss level
        if (level == Levels.values().length) {
            console.log("You have reached the final boss level, you will now fight against the Dark Lord Voldemort !");
            currentLevel = Levels.values()[level - 1];
            finalBattle();
        }

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
     * @param currentEnemy the actual ennemy that the player will fight against
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

                float damages = player.attack() + player.getPet().getAttackPower() - currentEnemy.defend();
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
                console.log("You dealt " + damages + " damages to the " + currentEnemy.getName() + " !");
                console.printSeparator(20);
                console.log("The " + currentEnemy.getName() + " dealt " + damagesTook + " damages to you !");
                scanner.anythingToContinue();

                if (player.getHealth() <= 0) {
                    playerDied();
                    break;
                } else if (currentEnemy.getHealth() <= 0) {
                    console.clearConsole();
                    console.printHeading("You killed the " + currentEnemy.getName() + " !");

                    //if the enemy is killed, he will randomely drop either a potion of strength or a potion of shield

                    //35% chance to drop a potion
                    boolean addPotion = new Random().nextInt(100) < 35;

                    //if potion dropped, we will randomely choose between a potion of strength or a potion of shield
                    if (addPotion) {
                        boolean isStrengthPotion = new Random().nextBoolean();
                        if (isStrengthPotion) {
                            player.setPotions(Potion.builder().name("strength").strength(5).shield(0).build());
                            console.log("The enemy dropped a potion of strength ! This potion has been added to your inventory !");
                        } else {
                            player.setPotions(Potion.builder().name("shield").strength(0).shield(5).build());
                            console.log("The enemy dropped a potion of shield ! This potion has been added to your inventory !");
                        }
                    }

                    scanner.anythingToContinue();
                    break;
                }

            } else if (input == 2) {

                console.clearConsole();
                //check if player has potions
                if (player.getPotions().size() != 0) {
                    console.printHeading("Do you want to drink a potion ?");
                    //calculate the number of potions that has the same name
                    int strengthPotions = 0;
                    int shieldPotions = 0;
                    for (Potion potion : player.getPotions()) {
                        if (potion.getName().equals("strength")) {
                            strengthPotions++;
                        } else if (potion.getName().equals("shield")) {
                            shieldPotions++;
                        }
                    }

                    //print the number of potions that has the same name even if there is not any potion of this type
                    console.log("You have " + strengthPotions + " potion(s) of strength and " + shieldPotions + " potion(s) of shield");

                    //ask which one to drink
                    console.log("Which one to drink ?\n(1) Strength\n(2) Shield");

                    int potionInput = scanner.nextIntInRange(1, 2);

                    if (potionInput == 1) {
                        //drink a potion of strength
                        if (strengthPotions > 0) {
                            //set the attack power of the player to the actual attack power + the strength of the first potion of strength using the filter
                            player.getPotions().stream().filter(potion -> potion.getName().equals("strength")).findFirst().ifPresent(potionToDrink -> player.setAttackPower(player.getAttackPower() + potionToDrink.getStrength()));
                            console.log("You drank a potion of strength ! Your strength has been increased by 5 !");
                            //now remove the potion that has been drunk from the array with the player.removePotion() method
                            player.removePotion("strength");
                            scanner.anythingToContinue();
                        } else {
                            console.log("You don't have any potion of strength !");
                            scanner.anythingToContinue();
                        }
                    } else if (potionInput == 2) {
                        //drink a potion of shield
                        if (shieldPotions > 0) {
                            player.getPotions().stream().filter(potion -> potion.getName().equals("shield")).findFirst().ifPresent(potionToDrink -> player.setShield(player.getShield() + potionToDrink.getShield()));
                            console.log("You drank a potion of shield ! Your shield has been increased by 5 !");
                            //now remove the potion that has been drunk from the array with the player.removePotion() method
                            player.removePotion("shield");
                            scanner.anythingToContinue();
                        } else {
                            console.log("You don't have any potion of shield !");
                            scanner.anythingToContinue();
                        }
                    }
                } else {
                    //player CANNOT take a potion
                    console.printHeading("You don't have any potions !");
                    scanner.anythingToContinue();
                }

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
        console.printHeading("WIZARD INFORMATIONS");
        System.out.println(player.getName() + "\tHP: " + player.getHealth() + "/" + player.getMaxHealth() + "\tShield: " + player.getShield());
        console.printSeparator(20);
        //# of pots
        //System.out.println("# of Potions: " + player.pots);
        //printSeparator(20);
        scanner.anythingToContinue();
    }

    public void finalBattle() {
        //creating the evil emperor and letting the player fight against him
        AbstractEnemy firstEnemy = currentLevel.getEnemy();
        AbstractEnemy boss = currentLevel.getBoss();
        battle(firstEnemy);
        battle(boss);

        scanner.anythingToContinue();
        console.clearConsole();
        console.log("You have defeated the Dark Lord Voldemort !\nYou are now the new Dark Lord of the Wizarding World !");
        scanner.anythingToContinue();
        console.clearConsole();
        console.log("Thank you for playing Harry Potter At Home !\nMade by Tugdual Audren de Kerdrel");
        scanner.anythingToContinue();

        scanner.close();

        isRunning = false;
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
