import Exceptions.FileNotSavedException;
import Gui.ActionProcessors.NewFileProcessor;
import CharacterCosmetics.CosmeticDetails;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestNewProcessor {
    @Test
    public void CreateNewFile_WhenCalled_ItSetsAllModelsToEmpty() throws FileNotSavedException {
        // Arrange
        Abilities testAbilities = new Abilities();
        testAbilities.setIsSaved(true);
        for (String name : AbilityNames.listAbilityNames()) {
            testAbilities.setAbilityScore(name, 10);
        }

        CosmeticDetails testDetails = new CosmeticDetails();
        testDetails.setIsSaved(true);
        for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
            testDetails.setDetail(detail, "Test detail");
        }

        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(testAbilities);
        modelList.add(testDetails);

        NewFileProcessor newProc = new NewFileProcessor();

        // Act
        newProc.CreateNewFile(modelList);

        // Assert
        for (String name : AbilityNames.listAbilityNames()) {
            assertEquals(0, testAbilities.getAbilityScore(name));
        }

        for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
            assertEquals("", testDetails.getDetail(detail));
        }
    }

    @Test
    public void CreateNewFile_WhenCalled_ItChecksTheModelIsSaved() throws FileNotSavedException{
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);

        when(mockAbilities.getIsSaved()).thenReturn(true);
        when(mockDetails.getIsSaved()).thenReturn(true);

        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);

        NewFileProcessor newProc = new NewFileProcessor();

        // Act
        newProc.CreateNewFile(modelList);

        // Assert
        verify(mockAbilities, times(1)).getIsSaved();
        verify(mockDetails, times(1)).getIsSaved();
    }

    @Test(expected = FileNotSavedException.class)
    public void CreateNewFile_IfAModelIsNotSaved_ItThrowsAFileNotSavedException() throws FileNotSavedException{
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);

        when(mockAbilities.getIsSaved()).thenReturn(true);        when(mockDetails.getIsSaved()).thenReturn(false);

        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);

        NewFileProcessor newProc = new NewFileProcessor();

        // Act
        newProc.CreateNewFile(modelList);
    }
}
