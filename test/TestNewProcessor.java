import Gui.ActionProcessors.NewFileProcessor;
import CharacterCosmetics.CosmeticDetails;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class TestNewProcessor {
    @Test
    public void NewFile_WhenCalled_ItSetsAllModelsToEmpty() {
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        for (String name : AbilityNames.listAbilityNames()) {
            mockAbilities.setAbilityScore(name, 10);
        }

        CosmeticDetails mockDetails = mock(CosmeticDetails.class);
        for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
            mockDetails.setDetail(detail, "Test detail");
        }

        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);

        NewFileProcessor newProc = new NewFileProcessor();

        // Act
        newProc.CreateNewFile(modelList);

        // Assert
        for (String name : AbilityNames.listAbilityNames()) {
            assertEquals(0, mockAbilities.getAbilityScore(name));
        }

        for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
            assertEquals("", mockDetails.getDetail(detail));
        }
    }
}
