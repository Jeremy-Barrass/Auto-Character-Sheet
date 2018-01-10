import Gui.Editor.AbilityEditor;
import RulesLogic.Abilities;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.awt.event.ActionListener;

import static org.mockito.Mockito.mock;

@PrepareForTest(AbilityEditor.class)

public class TestAbilityEditor {

    @Test
    public void testUpdateAbilities_WhenItReceivesANullValue_ItDoesNotChangeTheScores() {
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        ActionListener mockListener = mock(ActionListener.class);

        // Act


        // Assert
    }
}
