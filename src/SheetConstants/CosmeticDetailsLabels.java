package SheetConstants;

public final class CosmeticDetailsLabels {
    public static final String CharacterName = "Character Name";
    public static final String Player = "Player";
    public static final String Deity = "Deity";
    public static final String Homeland = "Homeland";
    public static final String Gender = "Gender";
    public static final String Height = "Height";
    public static final String Weight = "Weight";
    public static final String Hair = "Hair";
    public static final String Eyes = "Eyes";
    public static final String Languages = "Languages";

    public static String[] listCosmeticDetails() {
        return new String[] {
                CharacterName,
                Player,
                Deity,
                Homeland,
                Gender,
                Height,
                Weight,
                Hair,
                Eyes,
                Languages
        };
    }
}
