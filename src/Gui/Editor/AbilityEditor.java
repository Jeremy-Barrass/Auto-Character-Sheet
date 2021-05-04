package Gui.Editor;

import Gui.JGridPanel;
import Models.Model;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import interfaces.iDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class AbilityEditor extends JPanel implements iDisplay, Observer {
    private Abilities abilities;
    private ActionListener listener;
    private Hashtable<String, JTextField> editMap;
    private JButton saveButton;
    private JGridPanel titleFieldDisplay;
    private JLabel title;
    private JTextField field;

    public AbilityEditor(Model abilities) {
        setLayout(new BorderLayout());
        this.abilities = (Abilities) abilities;
        this.abilities.addObserver(this);
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
        editMap.get(changedAbility).setText(Integer.toString(abilities.getData(changedAbility)));
    }

    private class AbilityEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            UpdateAbilities();
        }
    }
}
