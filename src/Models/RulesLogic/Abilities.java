package Models.RulesLogic;

import Models.Model;

import java.util.Hashtable;

import static SheetConstants.AbilityNames.*;

/**
 * Created by jeremy on 29/05/17.
 */
public class Abilities extends Model<Integer> {
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

    public void setData(String label, Object data) {
        setAbilityScore(label, Integer.parseInt(data.toString()));
    }

    public Integer getData(String label) {
        return getAbilityScore(label);
    }

    public int getAbilityModifier(String ability) {
        return 0;
    }

    private int getAbilityScore(String ability) {
        return AbilityMap.get(ability);
    }

    private void setAbilityScore(String ability, int score) {
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
