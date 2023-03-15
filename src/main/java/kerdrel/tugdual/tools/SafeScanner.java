package kerdrel.tugdual.tools;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SafeScanner {

    private Scanner sc;
    public static final boolean DEBUG = true;

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

    public double nextDoubleSafe () {
        System.out.println("Please input a double/floating point number.");
        double response = 0.0;
        try {
            response = this.sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("You did not enter a double.");
            this.sc.next();
            return nextDoubleSafe();
        }
        return response;
    }

    public String nextStringSafe () {
        System.out.println("Please input a string");
        return this.sc.next();
    }

    public boolean nextBoolSafe () {
        System.out.println("Please input a boolean value. (\"true\" or \"false\")");
        boolean response = true;
        try {
            response = this.sc.nextBoolean();
        } catch (InputMismatchException e) {
            System.out.println("You did not enter a boolean.");
            this.sc.next();
            nextBoolSafe();
        }
        return response;
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

    public static void clearScreen () {
        if (!DEBUG) {
            String systemInfo = System.getProperty("os.name");
            if (systemInfo.contains("Windows")) {
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (Exception exception) {
                    System.out.println(exception);
                }
            } else if (systemInfo.contains("Mac")) {
                System.out.print("\033[H\033[2J"); //This is safe in windows, it just doesn't clear the screen.
            } else {
                System.out.println("Unable to determine system info. Unable to clear screen.");
            }
        }
    }
}
