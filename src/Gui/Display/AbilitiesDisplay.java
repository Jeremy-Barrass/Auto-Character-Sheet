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
    private JLabel title;
    private JLabel score;

    public AbilitiesDisplay(Model abilities) {
        this.abilities = (Abilities) abilities;
        this.abilities.addObserver(this);
        labelDataMap = new HashMap<>();
    }

    public void display(){
        abilityTitles = new JColumn();
        abilityScores = new JColumn();
        for (String statName : AbilityNames.listAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);
            score = new JLabel(Integer.toString(abilities.getData(statName)));
            abilityScores.add(score);
            labelDataMap.put(statName, score);
        }
        add(abilityTitles);
        add(abilityScores);
    }

    public void update(Observable o, Object arg) {
        Abilities abilities = (Abilities) o;
        String changedAbility = (String) arg;
        labelDataMap.get(changedAbility).setText(Integer.toString(abilities.getData(changedAbility)));
    }
}
