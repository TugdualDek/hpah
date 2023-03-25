package kerdrel.tugdual.tools;

public class Console {

    public void printSeparator(int n){
        for(int i = 0; i < n; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    public void clearConsole () {
        for(int i = 0; i<100; i++){
            System.out.println();
        }
    }

    public void log(String text) {
        System.out.println(text);
    }

}
