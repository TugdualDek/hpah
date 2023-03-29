package kerdrel.tugdual.characters;

import kerdrel.tugdual.spells.Spell;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {

    protected String name;
    protected float health;
    protected float maxHealth;
    protected float shield;
    protected float attackPower;

    public Character(String name, float maxHealth, float shield, float attackPower) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.shield = shield;
        this.attackPower = attackPower;
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    //
    // Methods
    //
    public abstract float attack();

    public abstract float attack(Spell spellUsed);

    public abstract float defend();

    private void takeDamage(float damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }
}

