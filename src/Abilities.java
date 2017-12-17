import interfaces.iAbilities;

import java.util.*;

/**
 * Created by jeremy on 29/05/17.
 */
public class Abilities implements iAbilities {
    private static final String Strength = "Strength";
    private static final String Dexterity = "Dexterity";
    private static final String Constitution = "Constitution";
    private static final String Intelligence = "Intelligence";
    private static final String Wisdom = "Wisdom";
    private static final String Charisma = "Charisma";


    private int StrengthScore;
    private int DexterityScore;
    private int ConstitutionScore;
    private int IntelligenceScore;
    private int WisdomScore;
    private int CharismaScore;

    private static Hashtable<String, Integer> AbilityMap;

    private void SetAbilities() {
        AbilityMap.put(Strength, StrengthScore);
        AbilityMap.put(Dexterity, DexterityScore);
        AbilityMap.put(Constitution, ConstitutionScore);
        AbilityMap.put(Intelligence, IntelligenceScore);
        AbilityMap.put(Wisdom, WisdomScore);
        AbilityMap.put(Charisma, CharismaScore);
    }

    public Abilities() {
        AbilityMap = new Hashtable<String, Integer>();
        SetAbilities();
    }

    public static String[] ListAbilityNames() {
        return new String[] {
                Strength,
                Dexterity,
                Constitution,
                Intelligence,
                Wisdom,
                Charisma
        };
    }

    public int GetAbilityScore(String ability) {
        return AbilityMap.get(ability);
    }

    public void SetAbilityScore(String ability, int score) {
        if (score >= 0) {
            switch (ability) {
                case Strength:
                    StrengthScore = score;
                    break;
                case Dexterity:
                    DexterityScore = score;
                    break;
                case Constitution:
                    ConstitutionScore = score;
                    break;
                case Intelligence:
                    IntelligenceScore = score;
                    break;
                case Wisdom:
                    WisdomScore = score;
                    break;
                case Charisma:
                    CharismaScore = score;
            }
        }
        SetAbilities();
    }
}
