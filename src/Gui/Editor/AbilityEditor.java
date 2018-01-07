package Gui.Editor;

import Gui.JColumn;
import SheetConstants.AbilityNames;
import interfaces.iAbilities;
import interfaces.iDisplay;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class AbilityEditor extends JPanel implements iDisplay, Serializable {
    private iAbilities _abilities;
    private JButton saveButton;
    private JColumn titles;
    private JColumn fields;
    private JLabel title;
    private JTextField field;

    public AbilityEditor(iAbilities abilities) {
        setLayout(new BorderLayout());
        _abilities = abilities;
    }

    public void Display() {
        titles = new JColumn();
        fields = new JColumn();
        saveButton = new JButton("Change Abilities");
        for(String ability : AbilityNames.ListAbilityNames()) {
            title = new JLabel(ability);
            titles.add(title);
            field = new JTextField();
            fields.add(field);
        }
        add(BorderLayout.WEST, titles);
        add(BorderLayout.CENTER, fields);
        add(BorderLayout.SOUTH, saveButton);
    }
}
