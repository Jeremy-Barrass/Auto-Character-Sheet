package Gui.Display;

import Gui.JColumn;
import Models.Model;
import Models.RulesLogic.Abilities;
import SheetConstants.AbilityNames;

import javax.swing.*;
import java.util.HashMap;
import java.util.Observable;

public class AbilitiesDisplay extends Display {
    private Abilities abilities;
    private JColumn abilityTitles;
    private JColumn abilityScores;
    private JColumn abilityModifiers;
    private JLabel title;
    private JLabel score;
    private JLabel modifier;
    private HashMap<String, JLabel> labelModifierMap;

    public AbilitiesDisplay(Model abilities) {
        this.abilities = (Abilities) abilities;
        this.abilities.addObserver(this);
        labelDataMap = new HashMap<>();
        labelModifierMap = new HashMap<>();
    }

    public void display(){
        abilityTitles = new JColumn();
        abilityScores = new JColumn();
        abilityModifiers = new JColumn();
        for (String statName : AbilityNames.listAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);

            score = new JLabel(stringifyNumber(abilities.getData(statName)));
            abilityScores.add(score);
            labelDataMap.put(statName, score);

            modifier = new JLabel(setModifierDisplay(abilities.getAbilityModifier(statName)));
            abilityModifiers.add(modifier);
            labelModifierMap.put(statName, modifier);
        }
        add(abilityTitles);
        add(abilityScores);
        add(abilityModifiers);
    }

    private String stringifyNumber(int number) {
        return Integer.toString(number);
    }

    private String setModifierDisplay(int modifier) {
        return modifier > 0 ? String.format("+%s", stringifyNumber(modifier)) : stringifyNumber(modifier);
    }

    public void update(Observable o, Object arg) {
        Abilities abilities = (Abilities) o;
        String changedAbility = (String) arg;
        labelDataMap.get(changedAbility).setText(Integer.toString(abilities.getData(changedAbility)));
        labelModifierMap.get(changedAbility).setText(setModifierDisplay(abilities.getAbilityModifier(changedAbility)));
    }
}
