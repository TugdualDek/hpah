package kerdrel.tugdual.wizarding;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Potion
 */
public class Potion {

  //
  // Fields
  //
  private @Getter
  @Setter String name;
  private @Getter
  @Setter float strength;
  private @Getter
  @Setter float shield;


  //
  // Constructors
  //
  @Builder
  public Potion(String name, float strength, float shield) {
    this.name = name;
    this.strength = strength;
    this.shield = shield;
  }


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
