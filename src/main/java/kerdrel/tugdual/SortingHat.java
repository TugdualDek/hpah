package kerdrel.tugdual;

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
    this.houses[0] = new House("Gryffondor");
    this.houses[1] = new House("Hufflepuff");
    this.houses[2] = new House("Ravenclaw");
    this.houses[3] = new House("Slytherin");
  };
  
  //
  // Methods
  //
  public String getRandomHouse(){
    House randomElement = houses[rand.nextInt(houses.length)];
    return randomElement.getHouse();
  }

  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
