package kerdrel.tugdual.wizarding;

import kerdrel.tugdual.wizarding.House;

import java.util.Random;

/**
 * Class SortingHat
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
  public SortingHat () {
    this.houses[0] = new House("Gryffondor", 0, 0, 10, 0);
    this.houses[1] = new House("Hufflepuff", 10, 0, 0, 0);
    this.houses[2] = new House("Ravenclaw", 0, 0, 0, 10);
    this.houses[3] = new House("Slytherin", 0, 10, 0, 0);
  };
  
  //
  // Methods
  //
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
