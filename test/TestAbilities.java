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
        abilities.SetAbilityScore("Strength", -1);

        // Assert
        Assert.assertEquals(0, abilities.GetAbilityScore("Strength"));
    }

    @Test
    public void testSetAbilityScore_WhenItReceivesAnEmptyString_ItDoesNotSetAnyVariable() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.SetAbilityScore("", 10);

        // Assert
        Assert.assertEquals(0, abilities.GetAbilityScore("Strength"));
        Assert.assertEquals(0, abilities.GetAbilityScore("Dexterity"));
        Assert.assertEquals(0, abilities.GetAbilityScore("Constitution"));
        Assert.assertEquals(0, abilities.GetAbilityScore("Intelligence"));
        Assert.assertEquals(0, abilities.GetAbilityScore("Wisdom"));
        Assert.assertEquals(0, abilities.GetAbilityScore("Charisma"));
    }

    @Test
    public void testSetAbilityScore_WhenItReceivesValidParams_ItSetsTheAppropriateScore() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.SetAbilityScore("Strength", 10);
        abilities.SetAbilityScore("Intelligence", 14);

        // Assert
        Assert.assertEquals(10, abilities.GetAbilityScore("Strength"));
        Assert.assertEquals(14, abilities.GetAbilityScore("Intelligence"));
        Assert.assertNotEquals(14, abilities.GetAbilityScore("Constitution"));
    }
}
