import CharacterCosmetics.CosmeticDetails;
import SheetConstants.CosmeticDetailsLabels;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCosmeticDetails {
    private String NAME;
    private String CHARACTER_NAME;
    private String PLAYER;
    private String LAST_NAME;
    private String EYES;
    private String COLOUR;
    private String DEITY;
    private String GARBAGE;
    private CosmeticDetails characterDetails ;
    private String[] params;

    @Before
    public void setUp() {
        NAME = "Ronny";
        CHARACTER_NAME = CosmeticDetailsLabels.CharacterName;
        PLAYER = CosmeticDetailsLabels.Player;
        LAST_NAME = "Corbett";
        EYES = CosmeticDetailsLabels.Eyes;
        COLOUR = "Black";
        DEITY = CosmeticDetailsLabels.Deity;
        GARBAGE = "a;dsf;adjg;agkj";
        characterDetails = new CosmeticDetails();
    }

    @Test
    public void testConfigDetails_WhenItDetectsAKeyInTheArray_ItSetsTheNextArrayIndexAsTheKeyValue() {
        // Arrange
        params = new String[] {EYES, COLOUR};

        // Act
        characterDetails.setConfigDetails(params);

        // Assert
        Assert.assertEquals(COLOUR, characterDetails.getData(EYES));
    }

    @Test
    public void testConfigDetails_WhenItDetectsDataWithNoKey_ItSetsThatDataAsTheValueForTheFirstEmptyKeyItDetects() {
        // Arrange
        params = new String[] {NAME, EYES, COLOUR, LAST_NAME, DEITY, GARBAGE};

        // Act
        characterDetails.setConfigDetails(params);

        // Assert
        Assert.assertEquals(COLOUR, characterDetails.getData(EYES));
        Assert.assertEquals(NAME, characterDetails.getData(CHARACTER_NAME));
        Assert.assertEquals(LAST_NAME, characterDetails.getData(PLAYER));
        Assert.assertEquals(GARBAGE, characterDetails.getData(DEITY));
    }

    @Test
    public void testConfigDetails_WhenItReceivesEmptyData_ItDoesNotSetAnyKeys() {
        // Arrange
        params = new String[0];

        // Act
        characterDetails.setConfigDetails(params);

        // Assert
        Assert.assertEquals("", characterDetails.getData(EYES));
        Assert.assertEquals("", characterDetails.getData(CHARACTER_NAME));
        Assert.assertEquals("", characterDetails.getData(PLAYER));
        Assert.assertEquals("", characterDetails.getData(DEITY));

    }
}
