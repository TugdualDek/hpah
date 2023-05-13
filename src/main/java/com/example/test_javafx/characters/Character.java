package com.example.test_javafx.characters;


import  com.example.test_javafx.spells.Spell;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {

    // Fields
    protected String name; // The name of the character
    protected float health; // The current health of the character
    protected float maxHealth; // The maximum health of the character
    protected float shield; // The shield of the character
    protected float attackPower; // The attack power of the character

    // Constructor
    public Character(String name, float maxHealth, float shield, float attackPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.shield = shield;
        this.attackPower = attackPower;
    }

    // Returns true if the character is defeated (health is less than or equal to 0)
    public boolean isDefeated() {
        return health <= 0;
    }

    // Abstract methods
    public abstract float attack(); // Attack method without a spell

    public abstract float attack(Spell spellUsed); // Attack method with a spell

    public abstract float defend(); // Defend method

    // Private method to take damage and update health
    private void takeDamage(float damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}
