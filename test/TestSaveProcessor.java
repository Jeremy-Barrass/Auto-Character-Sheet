import Gui.ActionProcessors.SaveFileProcessor;
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
    public void testSaveFile_WhenItReceivesAFileAndStateModels_ItCallsTheModelDataGetters() {
        // Arrange
        iAbilities mockAbilities = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();

        // Act
        saveProcessor.saveFile(new File("test/testHelpers/test-file.txt"), modelList);

        // Assert
        verify(mockAbilities, times(6)).getAbilityScore(anyString());
        verify(mockDetails, times(10)).getDetail(anyString());
    }

    @Test
    public void testSaveFile_WhenThereIsNoFileName_ItDoesNotRun() {
        // Arrange
        iAbilities mockAbilities = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();

        // Act
        saveProcessor.saveFile(new File(""), modelList);

        // Assert
        verify(mockAbilities, times(0)).getAbilityScore(anyString());
        verify(mockDetails, times(0)).getDetail(anyString());
    }
}
