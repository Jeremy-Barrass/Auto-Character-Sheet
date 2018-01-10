package Gui.Editor;

import Gui.JColumn;
import Listeners.AbilityEditorListener;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import interfaces.iAbilities;
import interfaces.iDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class AbilityEditor extends JPanel implements iDisplay, Serializable {
    private iAbilities _abilities;
    private ActionListener _listener;
    private JButton saveButton;
    private JColumn titles;
    private JColumn fields;
    private JLabel title;
    private JTextField field;

    public AbilityEditor(iAbilities abilities) {
        setLayout(new BorderLayout());
        _abilities = abilities;
        _listener = new AbilityEditorListener();
    }

    public AbilityEditor() {this(new Abilities())}

    public void Display() {
        titles = new JColumn();
        fields = new JColumn();
        saveButton = new JButton("Change Abilities");
        for(String ability : AbilityNames.ListAbilityNames()) {
            title = new JLabel(ability);
            titles.add(title);
            field = new JTextField(4);
            fields.add(field);
        }
        add(BorderLayout.CENTER, titles);
        add(BorderLayout.CENTER, fields);
        add(BorderLayout.SOUTH, saveButton);
    }

    private void UpdateAbilities() {
        _abilities.SetAbilityScore();
    }

    class AbilityEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            UpdateAbilities();
        }
    }
}
