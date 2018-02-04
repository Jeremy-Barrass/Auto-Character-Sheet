package SheetConstants;

import java.io.Serializable;

public final class AbilityNames implements Serializable {
    public static final String Strength = "Strength";
    public static final String Dexterity = "Dexterity";
    public static final String Constitution = "Constitution";
    public static final String Intelligence = "Intelligence";
    public static final String Wisdom = "Wisdom";
    public static final String Charisma = "Charisma";

    public static String[] ListAbilityNames() {
        return new String[]{
                Strength,
                Dexterity,
                Constitution,
                Intelligence,
                Wisdom,
                Charisma
        };
    }
}