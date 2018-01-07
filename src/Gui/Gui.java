package Gui;

import Gui.Display.AbilitiesDisplay;
import Gui.Editor.AbilityEditor;
import interfaces.iAbilities;
import interfaces.iGui;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static java.awt.BorderLayout.*;

public class Gui implements iGui, Serializable {
    private JFrame f;
    private JTabbedPane tabs;
    private JPanel characterSheet;
    private JPanel sheetEditor;
    private AbilitiesDisplay abilitiesDisplay;
    private AbilityEditor abilityEditor;

    private void displayAbilities(iAbilities abilities) {
        abilitiesDisplay = new AbilitiesDisplay(abilities);
        abilityEditor = new AbilityEditor(abilities);
        abilitiesDisplay.Display();
        abilityEditor.Display();
    }

    private void characterSheetSetUp() {
        characterSheet = new JPanel();
        characterSheet.setLayout(new BorderLayout());
        characterSheet.add(WEST, abilitiesDisplay);
    }

    private void sheetEditorSetUp() {
        sheetEditor = new JPanel();
        sheetEditor.setLayout(new BorderLayout());
        sheetEditor.add(WEST, abilityEditor);
    }

    private void tabSetUp() {
        tabs = new JTabbedPane();
        characterSheetSetUp();
        sheetEditorSetUp();
        tabs.addTab("Character Sheet", characterSheet);
        tabs.addTab("Edit", sheetEditor);
    }

    private void frameSetUp() {
        f = new JFrame("Pathfinder Character Sheet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabSetUp();
        f.getContentPane().add(tabs);
        f.setSize(900, 700);
        f.setVisible(true);
    }

    public void Run(iAbilities abilities) {
        displayAbilities(abilities);
        frameSetUp();
    }
}