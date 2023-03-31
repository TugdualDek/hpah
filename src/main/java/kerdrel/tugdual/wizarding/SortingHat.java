package kerdrel.tugdual.wizarding;


import kerdrel.tugdual.wizarding.House;

import java.util.Random;

/**
 * The SortingHat class represents the magical hat that assigns Hogwarts students to their respective houses.
 * It contains an array of House objects representing the four houses of Hogwarts.
 */
public class SortingHat {

    //
    // Fields
    //
    private House[] houses = new House[4];
    private Random rand = new Random();


    //
    // Constructors
    //

    /**
     * Constructs a SortingHat object with the four houses of Hogwarts.
     * Gryffindor, Hufflepuff, Ravenclaw, and Slytherin are initialized with their respective values.
     */
    public SortingHat() {
        this.houses[0] = new House("Gryffondor", 0, 0, 10, 0);
        this.houses[1] = new House("Hufflepuff", 10, 0, 0, 0);
        this.houses[2] = new House("Ravenclaw", 0, 0, 0, 10);
        this.houses[3] = new House("Slytherin", 0, 10, 0, 0);
    }

    ;

    //
    // Methods
    //

    /**
     * Returns a random House object from the array of houses.
     *
     * @return a random House object
     */
    public House getRandomHouse() {
        return houses[rand.nextInt(houses.length)];
    }

    //
    // Accessor methods
    //

    //
    // Other methods
    //

}
