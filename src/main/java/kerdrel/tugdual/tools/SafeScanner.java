/**
 * A utility class for safely scanning user input from the console.
 */
package kerdrel.tugdual.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeScanner {

    private Scanner sc;

    /**
     * Constructs a new SafeScanner object.
     */
    public SafeScanner() {
        this.sc = new Scanner(System.in);
    }

    /**
     * Closes the underlying Scanner object.
     */
    public void close() {
        this.sc.close();
    }

    /**
     * Safely reads an integer from the console.
     *
     * @return the integer entered by the user
     */
    public int nextIntSafe() {
        System.out.println("Please input an integer:");
        int response = 0;
        try {
            response = this.sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("You did not enter an integer.");
            this.sc.next();
            return nextIntSafe();
        }
        return response;
    }

    /**
     * Safely reads an integer from the console within a specified range.
     *
     * @param min the minimum value of the integer
     * @param max the maximum value of the integer
     * @return the integer entered by the user
     */
    public int nextIntInRange(int min, int max) {
        int response = nextIntSafe();
        while (response < min || response > max) {
            System.out.println("Number must be between " + min + " and " + max + " inclusive.");
            response = nextIntSafe();
        }
        return response;
    }

    /**
     * Prompts the user to enter anything to continue.
     */
    public void anythingToContinue() {
        System.out.println("\nEnter anything to continue ...");
        this.sc.next();
    }

    /**
     * Safely reads a string from the console.
     *
     * @return the string entered by the user
     */
    public String nextStringSafe() {
        System.out.println("Please input a string");
        return this.sc.next();
    }

    /**
     * Safely reads a yes/no answer from the console.
     *
     * @return true if the user entered "y" or "Y", false if the user entered "n" or "N"
     */
    public boolean nextYesNoAnswer() {
        String response = this.sc.next();
        if (response.contains("y") || response.contains("n")) {
            return true;
        } else if (response.contains("n") || response.contains("N")) {
            return false;
        } else {
            System.out.println("Yes/no response required. (y/n, Yeah, Yep, Nope, No)");
            return nextYesNoAnswer();
        }
    }
}
