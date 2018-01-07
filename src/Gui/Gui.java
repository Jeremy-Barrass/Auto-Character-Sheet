package Gui;

import Gui.Display.AbilitiesDisplay;
import interfaces.iAbilities;
import interfaces.iGui;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Gui implements iGui, Serializable {
    private JFrame f;
    private JTabbedPane tabs;
    private JPanel characterSheet;
    private JPanel sheetEditor;
    private AbilitiesDisplay abilitiesDisplay;

    private void displayAbilities(iAbilities abilities) {
        abilitiesDisplay = new AbilitiesDisplay(abilities);
        abilitiesDisplay.Display();
    }

    private void characterSheetSetUp() {
        characterSheet = new JPanel();
        characterSheet.add(BorderLayout.WEST, abilitiesDisplay);
    }

    private void tabSetUp() {
        tabs = new JTabbedPane();
        characterSheetSetUp();
        sheetEditor = new JPanel();
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