package kerdrel.tugdual;

import kerdrel.tugdual.characters.Boss;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Boss test = new Boss();
        test.setTest(1);
        System.out.println(test.getTest());
    }
}

