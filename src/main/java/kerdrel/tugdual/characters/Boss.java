package kerdrel.tugdual.characters;


import kerdrel.tugdual.spells.Spell;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Boss
 * <p>
 * This class represents a boss enemy in the game. It extends the AbstractEnemy class.
 */
public class Boss extends AbstractEnemy {

  //
  // Fields
  //


  //
  // Constructors
  //

  /**
   * Constructor for the Boss class.
   *
   * @param name        The name of the boss.
   * @param health      The health of the boss.
   * @param shield      The shield of the boss.
   * @param attackPower The attack power of the boss.
   */
  @Builder
  public Boss(String name, float health, float shield, float attackPower) {
    super(name, health, shield, attackPower);
  }

  //
  // Methods
  //

  /**
   * This method calculates the boss's attack power.
   *
   * @return The boss's attack power.
   */
  @Override
  public float attack() {
    return attackPower / 2;
  }

  /**
   * This method calculates the boss's attack power when using a spell.
   *
   * @param spellUsed The spell used by the boss.
   * @return The boss's attack power.
   */
  @Override
  public float attack(Spell spellUsed) {
    return 0;
  }

  /**
   * This method calculates the boss's shield.
   *
   * @return The boss's shield.
   */
  @Override
  public float defend() {
    return shield / 2;
  }

  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
