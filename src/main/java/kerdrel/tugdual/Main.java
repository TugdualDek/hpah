package kerdrel.tugdual;


import kerdrel.tugdual.tools.GameLogic;

/**
 * This is the main class that starts the game.
 */
public class Main {
    /**
     * The main method that starts the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Create a new instance of GameLogic and start the game
        new GameLogic().startGame();
    }
}
