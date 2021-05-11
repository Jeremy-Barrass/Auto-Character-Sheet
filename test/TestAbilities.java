import Models.RulesLogic.Abilities;
import org.junit.Assert;
import org.junit.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static java.util.OptionalInt.of;

@PrepareForTest(Abilities.class)

public class TestAbilities {
    @Test
    public void testSetAbilityScore_WhenItReceivesANegativeValue_ItDoesNotSetAnyVariable() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.setData("Strength", -1);

        // Assert
        Assert.assertEquals(of(0), of(abilities.getData("Strength")));
    }

    @Test
    public void testSetAbilityScore_WhenItReceivesAnEmptyString_ItDoesNotSetAnyVariable() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.setData("", 10);

        // Assert
        Assert.assertEquals(of(0), of(abilities.getData("Strength")));
        Assert.assertEquals(of(0), of(abilities.getData("Dexterity")));
        Assert.assertEquals(of(0), of(abilities.getData("Constitution")));
        Assert.assertEquals(of(0), of(abilities.getData("Intelligence")));
        Assert.assertEquals(of(0), of(abilities.getData("Wisdom")));
        Assert.assertEquals(of(0), of(abilities.getData("Charisma")));
    }

    @Test
    public void testSetAbilityScore_WhenItReceivesValidParams_ItSetsTheAppropriateScore() {
        // Arrange
        Abilities abilities = new Abilities();

        // Act
        abilities.setData("Strength", 10);
        abilities.setData("Intelligence", 14);

        // Assert
        Assert.assertEquals(of(10), of(abilities.getData("Strength")));
        Assert.assertEquals(of(14), of(abilities.getData("Intelligence")));
        Assert.assertNotEquals(of(14), of(abilities.getData("Constitution")));
    }

    @Test
    public void testGetAbilityModifier_WhenCalledWithAnAbilityScore_ItReturnsTheCorrectModifier() {
        // Arrange
        Abilities abilities = new Abilities();
        abilities.setData("Strength", 10);
        abilities.setData("Intelligence", 14);

        // Act
        int resultStr = abilities.getAbilityModifier("Strength");
        int resultInt = abilities.getAbilityModifier("Intelligence");

        // Assert
        Assert.assertEquals(of(0), of(resultStr));
        Assert.assertEquals(of(2), of(resultInt));
    }
}
