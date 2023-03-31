/**
 * This class contains JUnit tests for the Boss class.
 */
import kerdrel.tugdual.characters.Boss;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BossTest {

    private Boss boss = Boss.builder().health(100).shield(10).attackPower(30).name("Basilic").build();

    @Test
    public void testAttack() {
        float expected = 10;
        float actual = boss.attack();
        assertTrue(actual >= expected);
    }

    @Test
    public void testDefend() {
        float expected = 5;
        float actual = boss.defend();
        assertTrue(expected <= actual);
    }

    @Test
    public void testGetHealth() {
        float expected = 100;
        float actual = boss.getHealth();
        assertTrue(expected <= actual);
    }

    @Test
    public void testGetShield() {
        float expected = 10;
        float actual = boss.getShield();
        assertTrue(expected <= actual);
    }

    @Test
    public void testGetAttackPower() {
        float expected = 30;
        float actual = boss.getAttackPower();
        assertTrue(expected <= actual);
    }

}
