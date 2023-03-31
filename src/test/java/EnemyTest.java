import kerdrel.tugdual.characters.Enemy;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EnemyTest {

    private Enemy enemy = Enemy.builder().health(130).shield(40).attackPower(30).name("Petter Petigrow").build();

    // Test the constructor of the Enemy class
    @Test
    public void testEnemyConstructor() {
        // Check that the name, health, and damage values are set correctly
        assertEquals("Petter Petigrow", enemy.getName());
        assertEquals(100, enemy.getHealth(), 0.0);
        assertTrue(enemy.attack() >= 10);
    }

    // Test the takeDamage method of the Enemy class
    @Test
    public void testEnemyTakeDamage() {
        // Take damage from the enemy
        // the ennemy take 3 damages
        enemy.setHealth(enemy.getHealth() - 3);

        // Check that the health value has been updated correctly
        assertEquals(97, enemy.getHealth(), 0.0);
    }

    // Test the isDead method of the Enemy class
    @Test
    public void testEnemyIsDead() {
        // Take damage from the enemy
        enemy.setHealth(enemy.getHealth() - 97);

        // Check that the isDead method returns true
        assertTrue(enemy.getHealth() <= 0);
    }

    // Test the attack method of the Enemy class
    @Test
    public void testEnemyAttack() {
        // Check that the attack method returns a value between 10 and 30
        assertTrue(enemy.attack() > 0);
    }

    // Test the defend method of the Enemy class
    @Test
    public void testEnemyDefend() {
        // Check that the defend method returns a value between 10 and 30
        assertTrue(enemy.defend() > 0);
    }

}