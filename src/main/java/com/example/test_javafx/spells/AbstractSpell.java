package com.example.test_javafx.spells;


import lombok.Getter;
import lombok.Setter;


/**
 * This is an abstract class that represents a spell in the game.
 * It contains fields for the spell's name and damage, as well as
 * a constructor to set these values.
 */
public abstract class AbstractSpell {

    // Fields
    private @Getter
    @Setter String name;
    private @Getter
    @Setter float damage;

    // Constructors
    public AbstractSpell(String name, float damage) {
        this.name = name;
        this.damage = damage;
    }

    // Accessor methods

    // Other methods

}
