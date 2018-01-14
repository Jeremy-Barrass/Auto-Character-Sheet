package Gui.Editor;

import Gui.JGridPanel;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import interfaces.iAbilities;
import interfaces.iDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Hashtable;

public class AbilityEditor extends JPanel implements iDisplay, Serializable {
    private Abilities _abilities;
    private ActionListener _listener;
    private Hashtable<String, JTextField> _editMap;
    private JButton saveButton;
    private JGridPanel titleFieldDisplay;
    private JLabel title;
    private JTextField field;

    public AbilityEditor(iAbilities abilities) {
        setLayout(new BorderLayout());
        _abilities = (Abilities) abilities;
        _editMap = new Hashtable<>();
        _listener = new AbilityEditorListener();
    }

    public void Display() {
        titleFieldDisplay = new JGridPanel(6,2);
        saveButton = new JButton("Change Abilities");
        saveButton.addActionListener(_listener);
        for(String ability : AbilityNames.ListAbilityNames()) {
            title = new JLabel(ability);
            titleFieldDisplay.add(title);
            field = new JTextField("0", 4);
            titleFieldDisplay.add(field);
            _editMap.put(ability, field);
        }
        add(BorderLayout.CENTER, titleFieldDisplay);
        add(BorderLayout.SOUTH, saveButton);
    }

    private void UpdateAbilities() {
        for (String ability : _editMap.keySet()) {
            int score = Integer.parseInt(_editMap.get(ability).getText());
            if (score != _abilities.GetAbilityScore(ability)) {
                _abilities.SetAbilityScore(ability, score);
                _abilities.notifyObservers(ability);
            }
        }
    }

    private class AbilityEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            UpdateAbilities();
        }
    }
}
