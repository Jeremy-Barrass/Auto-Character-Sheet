import Gui.Editor.AbilityEditor;
import RulesLogic.Abilities;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.mockito.Mockito.mock;

@PrepareForTest(AbilityEditor.class)

public class TestAbilityEditor {
    Abilities mockAbilities = mock(Abilities.class);
    AbilityEditor editor = new AbilityEditor(mockAbilities);

    @Test
    public void testUpdateAbilities_WhenItReceivesANullValue_ItDoesNotChangeTheScores() {

    }
}
