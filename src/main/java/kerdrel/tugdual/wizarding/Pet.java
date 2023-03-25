package kerdrel.tugdual.wizarding;

import lombok.Setter;
import lombok.Getter;

/**
 * Class Pet
 */
public enum Pet {

  OWL("Owl"),
  RAT("Rat"),
  CAT("Cat"),
  TOAD("Toad");

  //
  // Fields
  //
  private String name;
  
  //
  // Constructors
  //
  Pet (String name) {
    this.name = name;
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


  //
  // Other methods
  //

}
