/**
 * Created by jeremy on 04/05/16.
 */

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestGui {
    Gui gui = new Gui();

    @Test
    public void testDisplayAbilities() {
        gui.displayAbilities();
        assertNotNull(gui.abilities)
    }

    @Test
    public void testAbilitiesPane() {
        assertNotNull(gui.abilities);
        gui.displayAbilities();
    }

    @Test
    public void testAbilityPane() {
        assertNotNull(gui.ability);
    }
}
