import RulesLogic.Abilities;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

@PrepareForTest(Abilities.class)

public class TestAbilities {
    @Test
    public void testSetAbilityScore_WhenItReceivesANegativeValue_ItDoesNotSetAnyVariable() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.setAbilityScore("Strength", -1);

        // Assert
        Assert.assertEquals(0, abilities.getAbilityScore("Strength"));
    }

    @Test
    public void testSetAbilityScore_WhenItReceivesAnEmptyString_ItDoesNotSetAnyVariable() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.setAbilityScore("", 10);

        // Assert
        Assert.assertEquals(0, abilities.getAbilityScore("Strength"));
        Assert.assertEquals(0, abilities.getAbilityScore("Dexterity"));
        Assert.assertEquals(0, abilities.getAbilityScore("Constitution"));
        Assert.assertEquals(0, abilities.getAbilityScore("Intelligence"));
        Assert.assertEquals(0, abilities.getAbilityScore("Wisdom"));
        Assert.assertEquals(0, abilities.getAbilityScore("Charisma"));
    }

    @Test
    public void testSetAbilityScore_WhenItReceivesValidParams_ItSetsTheAppropriateScore() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.setAbilityScore("Strength", 10);
        abilities.setAbilityScore("Intelligence", 14);

        // Assert
        Assert.assertEquals(10, abilities.getAbilityScore("Strength"));
        Assert.assertEquals(14, abilities.getAbilityScore("Intelligence"));
        Assert.assertNotEquals(14, abilities.getAbilityScore("Constitution"));
    }
}
