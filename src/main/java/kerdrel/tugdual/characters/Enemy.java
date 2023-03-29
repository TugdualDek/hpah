package kerdrel.tugdual.characters;

import kerdrel.tugdual.spells.Spell;
import lombok.Builder;

/**
 * Class Enemy
 */
public class Enemy extends AbstractEnemy {


  //
  // Fields
  //

  
  //
  // Constructors
  //
  @Builder
  public Enemy(String name, float health, float shield, float attackPower) {
    super(name, health, shield, attackPower);
  }


  //
  // Methods
  //
  @Override
  public float attack() {
    return Math.round(attackPower / 3);
  }

  @Override
  public float attack(Spell spellUsed) {
    return 0;
  }

  @Override
  public float defend() {
    return Math.round(shield / 2);
  }


  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
