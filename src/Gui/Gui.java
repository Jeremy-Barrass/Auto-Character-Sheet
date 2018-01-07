package Gui;

import interfaces.iAbilities;
import interfaces.iGui;
import javax.swing.*;
import java.awt.*;

public class Gui implements iGui {
    private JFrame f;
    private JTabbedPane tabs;
    private JPanel characterSheet;
    private JPanel sheetEditor;
    private JPanel abilitiesDisplay;
    private JColumn abilityTitles;
    private JColumn abilityScores;
    private JLabel title;
    private JLabel score;

    private void displayAbilities(iAbilities abilities) {
        abilitiesDisplay = new JPanel();
        abilityTitles = new JColumn();
        abilityScores = new JColumn();
        for (String statName : abilities.ListAbilityNames()) {
            title = new JLabel(statName);
            abilityTitles.add(title);
            score = new JLabel(Integer.toString(abilities.GetAbilityScore(statName)));
            abilityScores.add(score);
        }
        abilitiesDisplay.add(abilityTitles);
        abilitiesDisplay.add(abilityScores);
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