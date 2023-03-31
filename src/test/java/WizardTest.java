import kerdrel.tugdual.characters.Wizard;
import kerdrel.tugdual.wizarding.*;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WizardTest {

    private Pet pet = Pet.OWL;
    private SortingHat hat = new SortingHat();
    private House house = hat.getRandomHouse();
    private Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new Random().nextInt(10, 16));
    private Wizard wizard = Wizard.builder().name("test").health(100 + house.getHealthEfficacity()).shield(20).attackPower(15 + house.getSpellEfficacity()).pet(pet).wand(wand).house(house).precision(50 + house.getPrecisionEfficacity()).build();


    @Test
    public void testAttack() {
        float damage = wizard.attack();
        assertTrue(damage >= 0);
    }

    @Test
    public void testDefend() {
        float defense = wizard.defend();
        assertTrue(defense >= 0);
    }

    @Test
    public void testGetHealth() {
        float health = wizard.getHealth();
        assertTrue(health >= 0);
    }

    @Test
    public void testGetShield() {
        float shield = wizard.getShield();
        assertTrue(shield >= 0);
    }

    @Test
    public void testGetAttackPower() {
        float attackPower = wizard.getAttackPower();
        assertTrue(attackPower >= 0);
    }

    @Test
    public void testGetPrecision() {
        float precision = wizard.getPrecision();
        assertTrue(precision >= 0);
    }

    @Test
    public void testGetPet() {
        Pet pet = wizard.getPet();
        assertNotNull(pet);
    }

    @Test
    public void testGetWand() {
        Wand wand = wizard.getWand();
        assertNotNull(wand);
    }

    @Test
    public void testGetHouse() {
        House house = wizard.getHouse();
        assertNotNull(house);
    }


}