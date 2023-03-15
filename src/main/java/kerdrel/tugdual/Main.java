package kerdrel.tugdual;

import kerdrel.tugdual.characters.Boss;
import kerdrel.tugdual.tools.SafeScanner;
import kerdrel.tugdual.wizarding.House;
import kerdrel.tugdual.wizarding.Pet;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello to Harry Potter At Home!");

        SafeScanner scanner = new SafeScanner();

        //Boss test = new Boss();
        //test.setTest(1);
        //System.out.println(test.getTest());
        SortingHat hat = new SortingHat();
        House house = new House(hat.getRandomHouse());
        System.out.println("Votre maison : " + house.getHouse());

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Please choose a pet :");
        System.out.println("-------------------------\n");
        System.out.println("1 - Owl");
        System.out.println("2 - Rat");
        System.out.println("3 - Cat");
        System.out.println("4 - Toad");

        selection = scanner.nextIntInRange(1, 4);

        Pet pet;
        switch (selection) {
            case 1 -> pet = Pet.OWL;
            case 2 -> pet = Pet.RAT;
            case 3 -> pet = Pet.CAT;
            case 4 -> pet = Pet.TOAD;
            default -> {
                System.out.println("Vous n'avez pas selectionné un bon animal !");
                pet = Pet.values()[new Random().nextInt(Pet.values().length)];
            }
        }
        System.out.println("Votre animal de compagnie : " + pet.getName());

    }
}

