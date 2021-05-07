package Gui.Editor;

import Gui.JGridPanel;
import Models.Model;
import Models.RulesLogic.Abilities;
import SheetConstants.AbilityNames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;

public class AbilityEditor extends Editor<JTextField> {
    private Abilities abilities;
    private ActionListener listener;
    private JButton saveButton;
    private JGridPanel titleFieldDisplay;
    private JLabel title;
    private JTextField field;

    public AbilityEditor(Model abilities) {
        setLayout(new BorderLayout());
        this.abilities = (Abilities) abilities;
        this.abilities.addObserver(this);
        labelDataMap = new HashMap<>();
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
            labelDataMap.put(ability, field);
        }
        add(BorderLayout.CENTER, titleFieldDisplay);
        add(BorderLayout.SOUTH, saveButton);
    }

    public void updateModel() {
        updateAbilities();
    }

    private void updateAbilities() {
        for (String ability : labelDataMap.keySet()) {
            int score = Integer.parseInt(labelDataMap.get(ability).getText());
            if (score != abilities.getData(ability)) {
                abilities.setData(ability, score);
                abilities.setIsSaved(false);
                abilities.notifyObservers(ability);
            }
        }
    }

    public void update(Observable observable, Object o) {
        Abilities abilities = (Abilities) observable;
        String changedAbility = (String) o;
        labelDataMap.get(changedAbility).setText(Integer.toString(abilities.getData(changedAbility)));
    }
    private class AbilityEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            updateAbilities();
        }
    }
}
