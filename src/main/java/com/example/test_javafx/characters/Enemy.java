package com.example.test_javafx.characters;


import  com.example.test_javafx.spells.Spell;
import lombok.Builder;

/**
 * Class Enemy
 * <p>
 * This class represents an enemy character in the game. It extends the AbstractEnemy class.
 * It contains fields for the enemy's name, health, shield, and attack power.
 * It has constructors to create an instance of the class with the specified values for the fields.
 * It has methods to attack, defend, and access the fields.
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

    /**
     * This method calculates the amount of damage the enemy can deal in a basic attack.
     * It returns the result as a float.
     *
     * @return The amount of damage the enemy can deal in a basic attack.
     */
    @Override
    public float attack() {
        return Math.round(attackPower / 3);
    }

    /**
     * This method calculates the amount of damage the enemy can deal when using a spell.
     * It returns the result as a float.
     *
     * @param spellUsed The spell used by the enemy.
     * @return The amount of damage the enemy can deal when using the specified spell.
     */
    @Override
    public float attack(Spell spellUsed) {
        return 0;
    }

    /**
     * This method calculates the amount of damage the enemy can block with its shield.
     * It returns the result as a float.
     *
     * @return The amount of damage the enemy can block with its shield.
     */
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
