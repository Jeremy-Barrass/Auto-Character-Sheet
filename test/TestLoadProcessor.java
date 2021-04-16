import CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.LoadFileProcessor;
import RulesLogic.Abilities;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@PrepareForTest(LoadFileProcessor.class)

public class TestLoadProcessor {
    @Test
    public void loadFile_WhenCalled_ItSetsTheModelDataFromTheFile() {
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);
        ArrayList<Object> stateModelList = new ArrayList<>();
        stateModelList.add(mockAbilities);
        stateModelList.add(mockDetails);
        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File(String.format("%s/test/testHelpers/test-file-1.txt", System.getProperty("user.dir"))), stateModelList);

        // Assert
        verify(mockAbilities, times(6)).setAbilityScore(anyString(), anyInt());
        verify(mockDetails, times(10)).setDetail(anyString(), anyString());
    }

    @Test
    public void loadFile_WhenNoFileIsSelected_ItDoesNotRun() {
        // Arrange
        iAbilities mockAbilities = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        ArrayList<Object> stateModelList = new ArrayList<>();
        stateModelList.add(mockAbilities);
        stateModelList.add(mockDetails);
        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File(""), stateModelList);

        // Assert
        verify(mockAbilities, times(0)).setAbilityScore(anyString(), anyInt());
        verify(mockDetails, times(0)).setDetail(anyString(), anyString());
    }
}
