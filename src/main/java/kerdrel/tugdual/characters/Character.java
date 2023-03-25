package kerdrel.tugdual.characters;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Character {

    protected String name;
    protected float health;
    protected float shield;
    protected float attackPower;

    public Character(String name, float health, float shield, float attackPower) {
        this.name = name;
        this.health = health;
        this.shield = shield;
        this.attackPower = attackPower;
    }

    public boolean isDefeated() {
        return health <= 0;
    }

    public abstract int attack();
    public abstract int defend();

    private void takeDamage(float damage) {
        health -= damage;
        if(health < 0) {
            health = 0;
        }
    }
}
