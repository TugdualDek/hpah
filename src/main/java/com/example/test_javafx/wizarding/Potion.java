package com.example.test_javafx.wizarding;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Class representing a potion in the wizarding world.
 */
public class Potion {

    // Fields
    private @Getter
    @Setter String name; // The name of the potion.
    private @Getter
    @Setter float strength; // The strength of the potion.
    private @Getter
    @Setter float shield; // The shield provided by the potion.

    // Constructors
    @Builder
    public Potion(String name, float strength, float shield) {
        this.name = name;
        this.strength = strength;
        this.shield = shield;
    }

    // Accessor methods

  // Other methods

}
