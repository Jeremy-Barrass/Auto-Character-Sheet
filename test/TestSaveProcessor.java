import CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.SaveFileProcessor;
import Models.Model;
import RulesLogic.Abilities;
import interfaces.*;
import interfaces.iCosmeticDetails;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.File;
import java.util.ArrayList;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.mockito.Mockito.*;

@PrepareForTest(SaveFileProcessor.class)

public class TestSaveProcessor {
    @Test
    public void saveFile_WhenItReceivesAFileAndStateModels_ItCallsTheModelDataGetters() {
        // Arrange
        Model mockAbilities = mock(Model.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);
        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();

        // Act
        saveProcessor.saveFile(new File("test/testHelpers/test-file.txt"), modelList);

        // Assert
        verify(mockAbilities, times(6)).getData(anyString());
        verify(mockDetails, times(10)).getDetail(anyString());
    }

    @Test
    public void saveFile_WhenItSavesAFile_ItSetsTheModelsToIsSaved() {
        // Arrange
        Model mockAbilities = mock(Model.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);
        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();

        // Act
        saveProcessor.saveFile(new File("test/testHelpers/test-file.txt"), modelList);

        // Assert
        verify(mockAbilities, times(1)).setIsSaved(true);
        verify(mockDetails, times(1)).setIsSaved(true);

    }

    @Test
    public void saveFile_WhenThereIsNoFileName_ItDoesNotRun() {
        // Arrange
        Model mockAbilities = mock(Model.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();

        // Act
        saveProcessor.saveFile(new File(""), modelList);

        // Assert
        verify(mockAbilities, times(0)).getData(anyString());
        verify(mockDetails, times(0)).getDetail(anyString());
    }
}
