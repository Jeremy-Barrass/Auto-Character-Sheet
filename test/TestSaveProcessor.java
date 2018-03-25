import Gui.ActionProcessors.SaveFileProcessor;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.BufferedWriter;

import static org.powermock.api.mockito.PowerMockito.mock;

@PrepareForTest(SaveFileProcessor.class)

public class TestSaveProcessor {
    @Test
    public void saveFile_WhenItReceivesAFile_ItCallsTheMethodsOnItsDependencies() {
        // Arrange
        BufferedWriter mockWriter = mock(BufferedWriter.class);
        iAbilities mockAbiliteis = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        SaveFileProcessor saveProc = new SaveFileProcessor();

        // Act

        // Assert
    }
}
