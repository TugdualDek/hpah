import kerdrel.tugdual.wizarding.Potion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PotionTest {

    private Potion potion = Potion.builder().name("strength").strength(5).shield(0).build();

    @Test
    void testNamePotion() {
        Assertions.assertEquals("strength", potion.getName());
    }

    @Test
    void testStrengthPotion() {
        Assertions.assertEquals(5, potion.getStrength());
    }

    @Test
    void testShieldPotion() {
        Assertions.assertEquals(0, potion.getShield());
    }
}
