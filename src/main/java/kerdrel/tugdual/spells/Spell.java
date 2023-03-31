package kerdrel.tugdual.spells;


import lombok.Builder;

/**
 * Class Spell
 * This class represents a spell that can be cast by a wizard.
 * It extends the AbstractSpell class.
 */
public class Spell extends AbstractSpell {

  //
  // Fields
  //


  //
  // Constructors
  //

  /**
   * Constructor for Spell class.
   *
   * @param name   The name of the spell.
   * @param damage The amount of damage the spell can inflict.
   */
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
