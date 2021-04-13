import Gui.ActionProcessors.SaveFileProcessor;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.File;

import static org.powermock.api.mockito.PowerMockito.mock;
import static org.mockito.Mockito.*;

@PrepareForTest(SaveFileProcessor.class)

public class TestSaveProcessor {
    @Test
    public void testSaveFile_WhenItReceivesAFile_ItCallsTheMethodsOnItsDependencies() {
        // Arrange
        iAbilities mockAbilities = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        SaveFileProcessor saveProcessor = new SaveFileProcessor();
        saveProcessor.setSaveModels(mockAbilities, mockDetails);

        // Act
        saveProcessor.saveFile(new File("test-file"));

        // Assert
        verify(mockAbilities, times(6)).getAbilityScore(anyString());
        verify(mockDetails, times(10)).getDetail(anyString());
    }
}
