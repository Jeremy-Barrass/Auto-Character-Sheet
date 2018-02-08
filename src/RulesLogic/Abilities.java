package RulesLogic;

import interfaces.iAbilities;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Observable;

import static SheetConstants.AbilityNames.*;

/**
 * Created by jeremy on 29/05/17.
 */
public class Abilities extends Observable implements iAbilities, Serializable {
    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;

    private static Hashtable<String, Integer> AbilityMap;

    private void setAbilities() {
        AbilityMap.put(Strength, strengthScore);
        AbilityMap.put(Dexterity, dexterityScore);
        AbilityMap.put(Constitution, constitutionScore);
        AbilityMap.put(Intelligence, intelligenceScore);
        AbilityMap.put(Wisdom, wisdomScore);
        AbilityMap.put(Charisma, charismaScore);
        this.setChanged();
    }

    public Abilities() {
        AbilityMap = new Hashtable<String, Integer>();
        setAbilities();
    }

    public int getAbilityScore(String ability) {
        return AbilityMap.get(ability);
    }

    public void setAbilityScore(String ability, int score) {
        if (score >= 0) {
            switch (ability) {
                case Strength:
                    strengthScore = score;
                    break;
                case Dexterity:
                    dexterityScore = score;
                    break;
                case Constitution:
                    constitutionScore = score;
                    break;
                case Intelligence:
                    intelligenceScore = score;
                    break;
                case Wisdom:
                    wisdomScore = score;
                    break;
                case Charisma:
                    charismaScore = score;
            }
        }
        setAbilities();
    }


}
