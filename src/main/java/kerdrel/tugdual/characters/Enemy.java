package kerdrel.tugdual.characters;

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
  public Enemy(String name, float health, float shield, float attackPower) {
    super(name, health, shield, attackPower);
  }


  
  //
  // Methods
  //
  @Override
  public int attack() {
    return 0;
  }

  @Override
  public int defend() {
    return 0;
  }


  //
  // Accessor methods
  //

  //
  // Other methods
  //

}
