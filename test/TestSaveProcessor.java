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
    public void testSaveFile_WhenItReceivesAFileAndStateModels_ItCallsTheMethodsOnItsDependencies() {
        // Arrange
        iAbilities mockAbilities = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();

        // Act
        saveProcessor.saveFile(new File("test-file"), modelList);

        // Assert
        verify(mockAbilities, times(6)).getAbilityScore(anyString());
        verify(mockDetails, times(10)).getDetail(anyString());
    }
}
