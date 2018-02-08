package Gui;

import Gui.Display.AbilitiesDisplay;
import Gui.Display.CosmeticsDisplay;
import Gui.Editor.AbilityEditor;
import Gui.Editor.CosmeticsEditor;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iDisplay;
import interfaces.iGui;
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import static java.awt.BorderLayout.*;

public class Gui implements iGui, Serializable {
    private ArrayList<iDisplay> components;
    private JFrame f;
    private JTabbedPane tabs;
    private JPanel characterSheet;
    private JPanel sheetEditor;
    private AbilitiesDisplay abilitiesDisplay;
    private CosmeticsDisplay cosmeticsDisplay;
    private AbilityEditor abilityEditor;
    private CosmeticsEditor cosmeticsEditor;

    public Gui() {
        components = new ArrayList<>();
    }

    private void generateAbilities(iAbilities abilities) {
        abilitiesDisplay = new AbilitiesDisplay(abilities);
        components.add(abilitiesDisplay);
        abilityEditor = new AbilityEditor(abilities);
        components.add(abilityEditor);
    }

    private void generateDetails(iCosmeticDetails details) {
        cosmeticsDisplay = new CosmeticsDisplay(details);
        components.add(cosmeticsDisplay);
        cosmeticsEditor = new CosmeticsEditor(details);
        components.add(cosmeticsEditor);
    }

    private void characterSheetSetUp() {
        characterSheet = new JPanel();
        characterSheet.setLayout(new BorderLayout());
        characterSheet.add(NORTH, cosmeticsDisplay);
        characterSheet.add(WEST, abilitiesDisplay);
    }

    private void sheetEditorSetUp() {
        sheetEditor = new JPanel();
        sheetEditor.setLayout(new BorderLayout());
        JGridPanel westPanel = new JGridPanel(5, 1);
        westPanel.add(abilityEditor);
        sheetEditor.add(NORTH, cosmeticsEditor);
        sheetEditor.add(WEST, westPanel);
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
        for (iDisplay component : components) { component.display(); }
        f.getContentPane().add(tabs);
        f.setSize(1200, 800);
        f.setVisible(true);
    }

    public void run(iAbilities abilities, iCosmeticDetails details) {
        generateAbilities(abilities);
        generateDetails(details);
        frameSetUp();
    }
}