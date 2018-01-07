package Gui.Display;

import Gui.JColumn;
import interfaces.iAbilities;
import interfaces.iDisplay;

import javax.swing.*;
import java.io.Serializable;

public class AbilitiesDisplay extends JPanel implements iDisplay, Serializable {
    private iAbilities _abilities;
    private JColumn abilityTitles;
    private JColumn abilityScores;
    private JLabel title;
    private JLabel score;

    public AbilitiesDisplay(iAbilities abilities) {
        _abilities = abilities;
    }

    public void Display(){
        abilityTitles = new JColumn();
        abilityScores = new JColumn();
        for (String statName : _abilities.ListAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);
            score = new JLabel(Integer.toString(_abilities.GetAbilityScore(statName)));
            abilityScores.add(score);
        }
        add(abilityTitles);
        add(abilityScores);
    }
}
