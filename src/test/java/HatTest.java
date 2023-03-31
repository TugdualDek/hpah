import kerdrel.tugdual.wizarding.House;
import kerdrel.tugdual.wizarding.SortingHat;
import org.junit.Test;

import static org.junit.Assert.*;

public class HatTest {

    private SortingHat hat = new SortingHat();

    @Test
    public void testSortingHat() {
        House result = hat.getRandomHouse();
        assertNotNull(result);
    }

}
