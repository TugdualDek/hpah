package kerdrel.tugdual.tools;

import kerdrel.tugdual.characters.AbstractEnemy;
import kerdrel.tugdual.characters.Wizard;
import kerdrel.tugdual.ressources.Levels;
import kerdrel.tugdual.spells.Spell;
import kerdrel.tugdual.wizarding.*;

import java.util.*;

public class GameLogic {

    //

    // Fields
    //
    // Scanner and Console objects for user input and output
    SafeScanner scanner = new SafeScanner();
    Console console = new Console();

    // Player, pet, house, wand, and SortingHat objects for game setup
    private Wizard player;
    private Pet pet;
    private SortingHat hat = new SortingHat();
    private House house = hat.getRandomHouse();
    private Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new Random().nextInt(10, 16));

    // Game state variables
    private boolean isRunning;
    private int level = 1;
    private Levels currentLevel;

    // Battle state variable
    private boolean inBattle = false;

    // instanciate an arraylist of forbidden spells with one called Avada Kedavra
    private ArrayList<Spell> forbiddenSpells = new ArrayList<>();

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
     * Starts the game and show the introduction to the player
     */
    public void startGame() {
        forbiddenSpells.add(Spell.builder().name("Avada Kedavra").damage(80).build());
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

        //each pet will have a different attack power that will add to the player's attack power

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
        console.log("Very good choice, your pet is therefore a " + pet.getName() + "\nWe will now provide you with a wand that will best suit you!\nA wand of type " + wand.getCore().getName() + " and of " + wand.getSize() + "cm has chosen you !");
        scanner.anythingToContinue();

        // The player starts with 150 health points, 20 shield points, 15 attack points, and 50% precision
        player = Wizard.builder().name(name).health(150 + house.getHealthEfficacity()).shield(20).attackPower(15 + house.getSpellEfficacity()).pet(pet).wand(wand).house(house).precision(50 + house.getPrecisionEfficacity()).build();
        player.setKnownSpells((Spell) Spell.builder().name("Wingardium Leviosa").damage(10).build());
        isRunning = true;
        gameLoop();
    }

    /**
     * Method checkLevel
     * Will check the informations of the current level and will go to the next level if the boss is dead
     */
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
                console.log("You learnt a new spell : " + spellLearnt.getName());
                scanner.anythingToContinue();
            }

            level++;
            currentLevel = Levels.values()[level - 1];
            // If the current level is the last level, start the final battle
            if (level == Levels.values().length) {
                finalBattle();
            }
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
            inBattle = true;
            battle(currentLevel.getEnemy(), false);
        }

        inBattle = true;
        battle(currentLevel.getBoss(), false);
        inBattle = false;

        console.log("You have defeated the boss of the level !");

        scanner.anythingToContinue();

    }


    /**
     * Class battle
     *
     * @param currentEnemy the enemy that the player will have to fight (boss or enemy)
     * @param isFinal      chack if this is the final battle
     */
    private void battle(AbstractEnemy currentEnemy, boolean isFinal) {
        //while the player is in battle
        while (inBattle) {
            console.clearConsole();
            //print the name and health of the enemy and the player
            console.printHeading(currentEnemy.getName() + "\nHP: " + currentEnemy.getHealth() + "/" + currentEnemy.getMaxHealth());
            console.printHeading(player.getName() + "\nHP: " + player.getHealth() + "/" + player.getMaxHealth());
            console.log("Choose an action :");
            console.printSeparator(20);
            console.log("(1) Attack\n(2) Potion\n(3) Run");
            //the player will choose an action
            int input = scanner.nextIntInRange(1, 3);

            if (input == 1) {
                //if the player chooses to attack, call the attack method
                attack(currentEnemy);
            } else if (input == 2) {
                //if the player chooses to use a potion, call the usePotion method
                usePotion();
            } else if (input == 3) {
                //if the player chooses to run away, call the runAway method
                runAway(currentEnemy, isFinal);
            }
        }
    }

    /**
     * Method attack
     * Will start an attack between the player and the enemy
     *
     * @param currentEnemy the actual enemy that the player will fight against
     */
    private void attack(AbstractEnemy currentEnemy) {
        //print all the spells that the player knows
        console.log("Choose a spell to attack the enemy :");
        for (int i = 0; i < player.getKnownSpells().length; i++) {
            System.out.println("(" + (i + 1) + ") " + player.getKnownSpells()[i].getName());
        }

        //the player will choose a spell to attack the enemy
        int input;

        // check if there is a forbidden spell and if yes, then print the forbidden spell
        if (forbiddenSpells.size() > 0) {
            System.out.println("(0) " + forbiddenSpells.get(0).getName());
            input = scanner.nextIntInRange(0, player.getKnownSpells().length);
        } else {
            input = scanner.nextIntInRange(1, player.getKnownSpells().length);
        }

        float damagesTook, damages;

        //if the player chooses the forbidden spell, the enemy will attack the player
        if (input == 0) {
            console.log("You used the forbidden spell ! It is forbidden as its name says !");
            damagesTook = player.getHealth() / 2;
            damages = 0;

        } else {

            //calculate the damages dealt by the player
            damages = player.attack(player.getKnownSpells()[input - 1]) + player.getPet().getAttackPower() - currentEnemy.defend();
            //calculate the damages taken by the player
            damagesTook = currentEnemy.attack() - player.defend() / 2.5f;

            // check if the spell used is the spellToUse in the levels enum and if yes, then the player will deal *3 damages
            if (player.getKnownSpells()[input - 1].getName().equals(currentLevel.getSpellToUse())) {
                damages *= 3;
            }

            //check if the player missed the shot
            if (new Random().nextInt(100) > player.getPrecision()) {
                damages = Math.round(damages / new Random().nextInt(10));
                if (damages < 0) {
                    damages = 0;
                }
                console.log("You barely missed your shot !");
            }
        }

        //check if the damages taken by the player are negative
        if (damagesTook < 0) {
            damages -= damagesTook / 2;
            damagesTook = 0;
        }

        //check if the damages dealt by the player are negative
        if (damages < 0) {
            damages = 0;
        }

        //update the health of the enemy and the player
        currentEnemy.setHealth(currentEnemy.getHealth() - damages);
        player.setHealth(player.getHealth() - damagesTook);

        //print the result of the attack
        console.clearConsole();
        console.printHeading("Battle");
        console.log("You dealt " + damages + " damages to the " + currentEnemy.getName() + " !");
        console.printSeparator(20);
        console.log("The " + currentEnemy.getName() + " dealt " + damagesTook + " damages to you !");

        if (player.getHealth() <= 0) {
            playerDied();
            inBattle = false;
            return;
        } else if (currentEnemy.getHealth() <= 0) {
            enemyDied(currentEnemy);
            inBattle = false;
            return;

        }

        scanner.anythingToContinue();
    }

    /**
     * Class enemyDied
     *
     * @param currentEnemy the enemy that the player is currently fighting
     */
    public void enemyDied(AbstractEnemy currentEnemy) {
        //check if the enemy is dead
        if (currentEnemy.getHealth() <= 0) {
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

            //ask the player to increase his health or attack power

            console.log("Would you like to increase your health or your attack power ?");
            console.log("(1) Health\n(2) Attack power");
            int choice = scanner.nextIntInRange(1, 2);
            if (choice == 1) {
                player.setHealth(player.getHealth() + 15);
                console.log("Your health has been increased to " + player.getHealth() + " !");
            } else {
                player.setAttackPower(player.getAttackPower() + 10);
                console.log("Your attack power has been increased to " + player.getAttackPower() + " !");
            }

            inBattle = false;

            scanner.anythingToContinue();
        }
    }

    /**
     * Class usePotion
     * This is the class that allows the player to drink a potion during a fight
     */
    private void usePotion() {
        console.clearConsole();
        List<Potion> potions = player.getPotions();
        if (potions.isEmpty()) {
            console.log("You don't have any potions left!");
            scanner.anythingToContinue();
            return;
        }
        console.printHeading("Which potion do you want to use?");
        Map<Integer, Potion> potionsMap = new HashMap<>();
        int i = 1;
        for (Potion potion : potions) {
            console.log(i + ") " + potion.getName() + " potion (" + potion.getStrength() + " strength, " + potion.getShield() + " shield)");
            potionsMap.put(i, potion);
            i++;
        }
        int choice = scanner.nextIntInRange(1, potions.size());
        Potion selectedPotion = potionsMap.get(choice);
        if (selectedPotion.getName().equals("strength")) {
            console.log("You drank a strength potion and gained " + selectedPotion.getStrength() + " strength points!");
            player.setAttackPower(player.getAttackPower() + selectedPotion.getStrength());
        } else {
            console.log("You drank a shield potion and gained " + selectedPotion.getShield() + " shield points!");
            player.setShield(player.getShield() + selectedPotion.getShield());
        }
        player.removePotion(selectedPotion.getName());
        scanner.anythingToContinue();
    }

    /**
     * Class runAway
     *
     * @param currentEnemy the enemy that the player is currently fighting
     * @param isFinal      check if it is the final battle
     *                     if it is the final battle, not possible to run away
     */
    public void runAway(AbstractEnemy currentEnemy, boolean isFinal) {
        console.clearConsole();

        // if it is the final boss, the the player can't get away

        if (isFinal) {
            console.printHeading("You can't run away from the final boss !");
            scanner.anythingToContinue();
        } else {

            if (Math.random() * 10 + 1 <= 3.5) { // 35% chance to run away
                console.printHeading("You ran away from the " + currentEnemy.getName() + " !");
                inBattle = false;
                scanner.anythingToContinue();
            } else {
                System.out.println("You couldn't run away !");
                scanner.anythingToContinue();

                float damagesTook = currentEnemy.attack() - player.defend();
                System.out.println("In your hurry, the " + currentEnemy.getName() + " dealt " + damagesTook + " damages to you !");
                player.setHealth(player.getHealth() - damagesTook);
                scanner.anythingToContinue();

                if (player.getHealth() <= 0) {
                    playerDied();
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
        // Option 1: Continue journey
        System.out.println("(1) Continue your journey");
        // Option 2: Wizard information
        System.out.println("(2) Wizard information");
        // Option 3: Exit game
        System.out.println("(3) Exit the game");
    }

    /**
     * Method characterInfo
     * Will print the informations of the wizard
     */
    public void characterInfo() {
        console.clearConsole();
        console.printHeading("WIZARD INFORMATIONS");
        console.log(player.getName() + " stats =>\tHP: " + player.getHealth() + "/" + player.getMaxHealth() + "\tAttack: " + player.getAttackPower() + "\tShield: " + player.getShield());
        console.log("You have " + player.getPotions().size() + " potion(s) in your inventory");
        console.printSeparator(20);
        scanner.anythingToContinue();
    }

    /**
     * Class finalBattle
     * To "instanciate" the final battle
     */
    public void finalBattle() {

        // pass the forbidden spell into a normal spell
        player.setKnownSpells(forbiddenSpells.get(0));
        forbiddenSpells.remove(0);

        // Introduce the final boss level
        console.log("You have reached the final boss level, you will now fight against the Dark Lord Voldemort !");
        scanner.anythingToContinue();

        //creating the evil emperor and letting the player fight against him
        AbstractEnemy firstEnemy = currentLevel.getEnemy();
        AbstractEnemy boss = currentLevel.getBoss();
        battle(firstEnemy, true);
        battle(boss, true);

        scanner.anythingToContinue();
        console.clearConsole();

        // Congratulate the player for defeating the final boss
        console.log("You have defeated the Dark Lord Voldemort !\nYou are now the new Dark Lord of the Wizarding World !");
        scanner.anythingToContinue();
        console.clearConsole();

        // Thank the player for playing the game
        console.log("Thank you for playing Harry Potter At Home !\nMade by Tugdual Audren de Kerdrel");

        scanner.close();

        isRunning = false;
    }

    /**
     * Method playerDied
     * Will print the message when the player died
     */
    public void playerDied() {
        console.clearConsole(); // clear the console
        console.printHeading("You died !"); // print the message "You died !" as a heading
        scanner.close(); // close the scanner
        isRunning = false; // set isRunning to false to end the game loop
    }

    /**
     * Method gameLoop
     * Will loop the game until the player choose to exit
     */
    public void gameLoop() {
        while (isRunning) {
            printMenu(); // print the game menu
            int input = scanner.nextIntInRange(1, 3); // get user input
            if (input == 1) {
                continueJourney(); // continue the journey
            } else if (input == 2) {
                characterInfo(); // print the character information
            } else {
                console.log("Thanks for playing my game ! See you soon !"); // print the exit message
                scanner.close(); // close the scanner
                isRunning = false; // set isRunning to false to end the game loop
            }
        }
    }

}
