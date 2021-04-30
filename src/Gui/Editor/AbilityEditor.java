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
import java.util.Hashtable;
import java.util.Observer;

public class AbilityEditor extends JPanel implements iDisplay, Observer {
    private Abilities abilities;
    private ActionListener listener;
    private Hashtable<String, JTextField> editMap;
    private JButton saveButton;
    private JGridPanel titleFieldDisplay;
    private JLabel title;
    private JTextField field;

    public AbilityEditor(iAbilities abilities) {
        setLayout(new BorderLayout());
        this.abilities = (Abilities) abilities;
        editMap = new Hashtable<>();
        listener = new AbilityEditorListener();
    }

    public void display() {
        titleFieldDisplay = new JGridPanel(6,2);
        saveButton = new JButton("Change Abilities");
        saveButton.addActionListener(listener);
        for(String ability : AbilityNames.listAbilityNames()) {
            title = new JLabel(ability);
            titleFieldDisplay.add(title);
            field = new JTextField("0", 4);
            titleFieldDisplay.add(field);
            editMap.put(ability, field);
        }
        add(BorderLayout.CENTER, titleFieldDisplay);
        add(BorderLayout.SOUTH, saveButton);
    }

    private void UpdateAbilities() {
        for (String ability : editMap.keySet()) {
            int score = Integer.parseInt(editMap.get(ability).getText());
            if (score != abilities.getAbilityScore(ability)) {
                abilities.setAbilityScore(ability, score);
                abilities.notifyObservers(ability);
            }
        }
    }

    private class AbilityEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            UpdateAbilities();
        }
    }
}
