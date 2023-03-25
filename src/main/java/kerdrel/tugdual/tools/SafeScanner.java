package kerdrel.tugdual.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeScanner {

    private Scanner sc;

    public SafeScanner(){
        this.sc = new Scanner(System.in);
    }

    public void close(){
        this.sc.close();
    }

    public int nextIntSafe () {
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

    public int nextIntInRange (int min, int max) {
        int response = nextIntSafe();
        while (response < min || response > max) {
            System.out.println("Number must be between " + min + " and " + max + " inclusive.");
            response = nextIntSafe();
        }
        return response;
    }

    public void anythingToContinue(){
        System.out.println("\nEnter anything to continue ...");
        this.sc.next();
    }

    public String nextStringSafe () {
        System.out.println("Please input a string");
        return this.sc.next();
    }

    public boolean nextYesNoAnswer () {
        String response = this.sc.next();
        if (response.contains("y") || response.contains("Y")) {
            return true;
        } else if (response.contains("n") || response.contains("N")) {
            return false;
        } else {
            System.out.println("Yes/no response required. (y/n, Yeah, Yep, Nope, No)");
            return nextYesNoAnswer ();
        }
    }
}
