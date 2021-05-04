import CharacterCosmetics.CosmeticDetails;
import Exceptions.FileNotSavedException;
import Gui.ActionProcessors.LoadFileProcessor;
import RulesLogic.Abilities;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.io.File;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@PrepareForTest(LoadFileProcessor.class)

public class TestLoadProcessor {
    @Test
    public void loadFile_WhenCalled_ItSetsTheModelDataFromTheFile() throws FileNotSavedException {
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);

        when(mockAbilities.getIsSaved()).thenReturn(true);
        when(mockDetails.getIsSaved()).thenReturn(true);

        ArrayList<Object> stateModelList = new ArrayList<>();
        stateModelList.add(mockAbilities);
        stateModelList.add(mockDetails);
        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File(String.format("%s/test/testHelpers/test-file-1.txt", System.getProperty("user.dir"))), stateModelList);

        // Assert
        verify(mockAbilities, times(6)).setData(anyString(), anyInt());
        verify(mockDetails, times(10)).setDetail(anyString(), anyString());
    }

    @Test
    public void loadFile_WhenNoFileIsSelected_ItDoesNotRun() throws FileNotSavedException {
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);

        when(mockAbilities.getIsSaved()).thenReturn(true);
        when(mockDetails.getIsSaved()).thenReturn(true);

        ArrayList<Object> stateModelList = new ArrayList<>();
        stateModelList.add(mockAbilities);
        stateModelList.add(mockDetails);
        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File(""), stateModelList);

        // Assert
        verify(mockAbilities, times(0)).setData(anyString(), anyInt());
        verify(mockDetails, times(0)).setDetail(anyString(), anyString());
    }

    @Test
    public void loadFile_WhenCalled_ItChecksTheModelIsSaved() throws FileNotSavedException {
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);

        when(mockAbilities.getIsSaved()).thenReturn(true);
        when(mockDetails.getIsSaved()).thenReturn(true);

        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);

        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File(String.format("%s/test/testHelpers/test-file-1.txt", System.getProperty("user.dir"))), modelList);

        // Assert
        verify(mockAbilities, times(6)).getIsSaved();
        verify(mockDetails, times(10)).getIsSaved();
    }

    @Test(expected = FileNotSavedException.class)
    public void loadFile_IfAModelIsNotSaved_ItThrowsAFileNotSavedException() throws FileNotSavedException{
        // Arrange
        Abilities mockAbilities = mock(Abilities.class);
        CosmeticDetails mockDetails = mock(CosmeticDetails.class);

        when(mockAbilities.getIsSaved()).thenReturn(true);
        when(mockDetails.getIsSaved()).thenReturn(false);

        ArrayList<Object> modelList = new ArrayList<>();
        modelList.add(mockAbilities);
        modelList.add(mockDetails);

        LoadFileProcessor loadProcessor = new LoadFileProcessor();

        // Act
        loadProcessor.loadFile(new File(String.format("%s/test/testHelpers/test-file-1.txt", System.getProperty("user.dir"))), modelList);
    }

}
