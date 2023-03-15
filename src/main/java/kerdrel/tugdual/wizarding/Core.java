package kerdrel.tugdual.wizarding;

import lombok.Getter;
import lombok.Setter;

/**
 * Class Core
 */
public enum Core {

    PHOENIX_FEATHER("pheonix feather"),
    DRAGON_HEARTSTRING("dragon heartstring");


  //
  // Fields
  //
  private @Getter @Setter String name;

  
  //
  // Constructors
  //
  Core (String name) {
    this.name = name;
  };
  
  //
  // Methods
  //


  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
