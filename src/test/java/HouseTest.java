import kerdrel.tugdual.wizarding.House;
import kerdrel.tugdual.wizarding.SortingHat;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

    private SortingHat hat = new SortingHat();
    private House house = hat.getRandomHouse();

    @Test
    public void testNameHouse() {
        assertNotNull(house.getHouse());
    }

    @Test
    public void testPotionEfficacity() {
        assertTrue(house.getPotionEfficacity() >= 0);
    }

    @Test
    public void testSpellEfficacity() {
        assertTrue(house.getSpellEfficacity() >= 0);
    }

    @Test
    public void testHealthEfficacity() {
        assertTrue(house.getHealthEfficacity() >= 0);
    }

    @Test
    public void getPrecisionEfficacity() {
        assertTrue(house.getPrecisionEfficacity() >= 0);
    }
}
