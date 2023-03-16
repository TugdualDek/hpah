package kerdrel.tugdual.wizarding;

import lombok.Setter;
import lombok.Getter;

/**
 * Class Pet
 */
public enum Pet {

  OWL("Hibou"),
  RAT("Rat"),
  CAT("Chat"),
  TOAD("Crapaud");

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
