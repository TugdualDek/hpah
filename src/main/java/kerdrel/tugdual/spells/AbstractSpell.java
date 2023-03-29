package kerdrel.tugdual.spells;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;


/**
 * Class AbstractSpell
 */
public abstract class AbstractSpell {

    //
    // Fields
    //
    private @Getter
    @Setter String name;
    private @Getter
    @Setter float damage;


    //
    // Constructors
    //
    public AbstractSpell(String name, float damage) {
        this.name = name;
        this.damage = damage;
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
