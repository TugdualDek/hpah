package com.example.test_javafx.wizarding;


import lombok.Getter;
import lombok.Setter;

/**
 * Class House
 * This class represents a Hogwarts house and its corresponding efficacies for potions, spells, health, and precision.
 */
public class House {

    //
    // Fields
    //
    private @Getter
    @Setter String house; // The name of the Hogwarts house
    private @Getter
    @Setter float potionEfficacity; // The efficacy of potions for this house
    private @Getter
    @Setter float spellEfficacity; // The efficacy of spells for this house
    private @Getter
    @Setter float healthEfficacity; // The efficacy of health for this house
    private @Getter
    @Setter float precisionEfficacity; // The efficacy of precision for this house

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
