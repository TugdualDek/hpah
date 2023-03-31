/**
 * This class provides utility methods for interacting with the console.
 */
package kerdrel.tugdual.tools;

public class Console {

    /**
     * Prints a separator line consisting of dashes.
     *
     * @param n the number of dashes in the separator line
     */
    public void printSeparator(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Prints a heading with a separator line above and below the title.
     *
     * @param title the title of the heading
     */
    public void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    /**
     * Clears the console by printing 100 blank lines.
     */
    public void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    /**
     * Logs a message to the console.
     *
     * @param text the message to log
     */
    public void log(String text) {
        System.out.println(text);
    }

}
