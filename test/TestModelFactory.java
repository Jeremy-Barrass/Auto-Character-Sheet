import Factories.ModelFactory;
import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(ModelFactory.class)
public class TestModelFactory {
    @Test
    public void createModel_whenCreatingCosmeticDetails_suppliesCosmeticConfig() {
        // arrange
        String[] config = new String[] {
                "Character Name",
                "manny",
                "deity",
                "god",
                "homeland",
                "Harffenlarfen."
        };
        String[] expectedValues = new String[]{
                config[1],
                config[3],
                config[5]
        };
        ModelFactory factory = new ModelFactory(config);

        // act
        Model result = factory.createModel("cosmetics");

        // assert
        Assert.assertEquals(expectedValues[0], result.getData("Character Name"));
        Assert.assertEquals(expectedValues[1], result.getData("deity"));
        Assert.assertEquals(expectedValues[2], result.getData("homeland"));
    }
}
