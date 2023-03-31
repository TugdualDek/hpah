import kerdrel.tugdual.spells.Spell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SpellTest {

    private Spell spell = Spell.builder().name("Expelliarmus").damage(10).build();

    @Test
    void testNameSpell() {
        Assertions.assertNotNull(spell.getName());
    }

    @Test
    void testDamageSpell() {
        Assertions.assertEquals(10, spell.getDamage());
    }
}
