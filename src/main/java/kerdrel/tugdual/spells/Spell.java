package kerdrel.tugdual.spells;

import lombok.Builder;

/**
 * Class Spell
 */
public class Spell extends AbstractSpell {

  //
  // Fields
  //


  //
  // Constructors
  //
  @Builder
  public Spell(String name, float damage) {
    super(name, damage);
  }

  ;

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
