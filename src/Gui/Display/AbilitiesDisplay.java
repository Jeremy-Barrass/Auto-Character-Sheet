package Gui.Display;

import Gui.JColumn;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import interfaces.iAbilities;
import interfaces.iDisplay;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class AbilitiesDisplay extends JPanel implements iDisplay, Observer {
    private Abilities abilities;
    private Hashtable<String, JLabel> displayMap;
    private JColumn abilityTitles;
    private JColumn abilityScores;
    private JLabel title;
    private JLabel score;

    public AbilitiesDisplay(iAbilities abilities) {
        this.abilities = (Abilities) abilities;
        this.abilities.addObserver(this);
        displayMap = new Hashtable<>();
    }

    public void display(){
        abilityTitles = new JColumn();
        abilityScores = new JColumn();
        for (String statName : AbilityNames.listAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);
            score = new JLabel(Integer.toString(abilities.getAbilityScore(statName)));
            abilityScores.add(score);
            displayMap.put(statName, score);
        }
        add(abilityTitles);
        add(abilityScores);
    }

    public void update(Observable o, Object arg) {
        Abilities abilities = (Abilities) o;
        String changedAbility = (String) arg;
        displayMap.get(changedAbility).setText(Integer.toString(abilities.getAbilityScore(changedAbility)));
    }
}
