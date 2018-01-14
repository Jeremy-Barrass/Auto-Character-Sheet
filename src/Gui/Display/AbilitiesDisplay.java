package Gui.Display;

import Gui.JColumn;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import interfaces.iAbilities;
import interfaces.iDisplay;

import javax.swing.*;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class AbilitiesDisplay extends JPanel implements iDisplay, Serializable, Observer {
    private Abilities _abilities;
    private Hashtable<String, JLabel> _displayMap;
    private JColumn abilityTitles;
    private JColumn abilityScores;
    private JLabel title;
    private JLabel score;

    public AbilitiesDisplay(iAbilities abilities) {
        _abilities = (Abilities) abilities;
        _abilities.addObserver(this);
        _displayMap = new Hashtable<>();
    }

    public void Display(){
        abilityTitles = new JColumn();
        abilityScores = new JColumn();
        for (String statName : AbilityNames.ListAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);
            score = new JLabel(Integer.toString(_abilities.GetAbilityScore(statName)));
            abilityScores.add(score);
            _displayMap.put(statName, score);
        }
        add(abilityTitles);
        add(abilityScores);
    }

    public void update(Observable o, Object arg) {
        Abilities abilities = (Abilities) o;
        String changedAbility = (String) arg;
        _displayMap.get(changedAbility).setText(Integer.toString(abilities.GetAbilityScore(changedAbility)));
    }
}
