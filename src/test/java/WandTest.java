import kerdrel.tugdual.wizarding.Core;
import kerdrel.tugdual.wizarding.Wand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class WandTest {

    private Wand wand = new Wand(Core.values()[new Random().nextInt(Core.values().length)], new Random().nextInt(10, 16));

    @Test
    void testCoreWand() {
        //test if the core name is in the Core enum class
        Core name = Core.valueOf(wand.getCore().name());
        Assertions.assertNotNull(name);
    }

    @Test
    void testSizeWand() {
        //test if the size is between 10 and 16
        Assertions.assertTrue(wand.getSize() >= 10 && wand.getSize() <= 16);
    }
}
