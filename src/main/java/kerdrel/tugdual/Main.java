package kerdrel.tugdual;

import kerdrel.tugdual.tools.SafeScanner;
import kerdrel.tugdual.wizarding.*;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Bienvenue à Poudlard !");

        SafeScanner scanner = new SafeScanner();

        //Boss test = new Boss();
        //test.setTest(1);
        //System.out.println(test.getTest());
        System.out.println("Le choipeau magique va décider de votre sort !");
        SortingHat hat = new SortingHat();
        House house = new House(hat.getRandomHouse());
        System.out.println("Le choipeau magique a decidé, et ce n'était pas facile, mais votre maison est desormais " + house.getHouse());

        scanner.clearScreen();

        int selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Vous allez maintenant pouvoir selectionner votre animal de compagnie qui vous accompagnera durant tout le jeu :");
        System.out.println("-------------------------\n");
        System.out.println("1 - Hibou");
        System.out.println("2 - Rat");
        System.out.println("3 - Chat");
        System.out.println("4 - Crapaud");

        selection = scanner.nextIntInRange(1, 4);

        Pet pet;
        switch (selection) {
            case 1 -> pet = Pet.OWL;
            case 2 -> pet = Pet.RAT;
            case 3 -> pet = Pet.CAT;
            case 4 -> pet = Pet.TOAD;
            default -> {
                System.out.println("Vous n'avez pas selectionné un bon animal, nous allons le faire pour vous !");
                pet = Pet.values()[new Random().nextInt(Pet.values().length)];
            }
        }
        System.out.println("Très bon choix, votre animal de compagnie est donc un " + pet.getName());

        System.out.println("Nous allons maintenant vous fournir une baguette qui vous correspondra au mieux !");

        Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new  Random().nextInt(10, 16));

        System.out.println("Une baguette de type " + wand.getCore().getName() + " et de " + wand.getSize() + "cm vous a choisie !");

        scanner.close();
    }
}

