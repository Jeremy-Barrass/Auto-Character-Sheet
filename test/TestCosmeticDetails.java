import CharacterCosmetics.CosmeticDetails;
import org.junit.Assert;
import org.junit.Test;

public class TestCosmeticDetails {
    @Test
    public void testConfigDetails_WhenItDetectsAKeyInTheArray_ItSetsTheNextArrayIndexAsTheKeyValue() {
        // Arrange
        CosmeticDetails characterDetails = new CosmeticDetails();
        String[] params = new String[] {"Eyes", "Black"};

        // Act
        characterDetails.setConfigDetails(params);

        // Assert
        Assert.assertEquals(params[1], characterDetails.getDetail(params[0]));
    }
}
