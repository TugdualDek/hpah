package kerdrel.tugdual.characters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class Boss
 */
public class Boss extends AbstractEnemy {


  //
  // Fields
  //

  
  //
  // Constructors
  //
  @Builder
  public Boss(String name, float health, float shield, float attackPower) {
    super(name, health, shield, attackPower);
  }
  
  //
  // Methods
  //
  @Override
  public float attack() {
      return attackPower / 2;
  }

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
