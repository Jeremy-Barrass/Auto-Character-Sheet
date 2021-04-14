import Gui.ActionProcessors.LoadFileProcessor;
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
        iAbilities mockAbilities = mock(iAbilities.class);
        iCosmeticDetails mockDetails = mock(iCosmeticDetails.class);
        ArrayList<Object> stateModelList = new ArrayList<>();
        stateModelList.add(mockAbilities);
        stateModelList.add(mockDetails);
        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File("test-file-1.txt"), stateModelList);

        // Assert
        verify(mockAbilities, times(6)).setAbilityScore(anyString(), anyInt());
        verify(mockDetails, times(10)).setDetail(anyString(), anyString());
    }

}
