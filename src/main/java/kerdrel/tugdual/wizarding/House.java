package kerdrel.tugdual.wizarding;

import lombok.Setter;
import lombok.Getter;

/**
 * Class House
 */
public class House {

  //
  // Fields
  //
  private @Getter
  @Setter String house;
  private @Getter
  @Setter float potionEfficacity; // hufflepuf
  private @Getter
  @Setter float spellEfficacity; // slytherin
  private @Getter
  @Setter float healthEfficacity; // Gryffindor
  private @Getter
  @Setter float precisionEfficacity; // Ravenclaw

  //
  // Constructors
  //
  public House(String house, float potionEfficacity, float spellEfficacity, float healthEfficacity, float precisionEfficacity) {
    this.house = house;
    this.potionEfficacity = potionEfficacity;
    this.spellEfficacity = spellEfficacity;
    this.healthEfficacity = healthEfficacity;
    this.precisionEfficacity = precisionEfficacity;
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
