import CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.SaveFileProcessor;
import Gui.Gui;
import RulesLogic.Abilities;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(characterSheet.class)
@PowerMockIgnore("javax.management")
public class TestCharacterSheet {
    String name;
    String player;
    String god;
    String[] params;
    SaveFileProcessor mockSaver;
    Gui mockGui;
    Abilities mockAbilities;
    CosmeticDetails mockDetails;
    characterSheet manny;

    @Before
    public void setUp() {
        name = "Manetherin";
        params = new String[] {name, player, god};
        mockGui = mock(Gui.class);
        mockAbilities = mock(Abilities.class);
        mockDetails = mock(CosmeticDetails.class);
        manny = new characterSheet(params, mockGui, mockAbilities, mockDetails);
    }

    @Test
    public void testConstructor() {
        verify(mockDetails, times(1)).setConfigDetails(params);
    }

    @Test
	public void testGenerateGui() {
		manny.generateGui();
        verify(mockGui, times(1)).run(mockAbilities, mockDetails);
	}



































































































































































































































































































































































































































































































































































































































































































}