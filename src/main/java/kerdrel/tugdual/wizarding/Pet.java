package kerdrel.tugdual.wizarding;

import lombok.Setter;
import lombok.Getter;

/**
 * Class Pet
 */
public enum Pet {

  OWL("Owl", 10),
  RAT("Rat", 11),
  CAT("Cat", 9),
  TOAD("Toad", 10);

  //
  // Fields
  //
  private String name;
  private int attackPower;

  //
  // Constructors
  //
  Pet(String name, int attackPower) {
    this.name = name;
    this.attackPower = attackPower;
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //
  public String getName() {
    return this.name;
  }

  public int getAttackPower() {
    return this.attackPower;
  }


  //
  // Other methods
  //

}
