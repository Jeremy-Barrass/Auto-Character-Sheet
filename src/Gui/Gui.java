package Gui;

import Gui.Display.AbilitiesDisplay;
import Gui.Display.CosmeticsDisplay;
import Gui.Editor.AbilityEditor;
import Gui.Editor.CosmeticsEditor;
import Models.Model;
import interfaces.iDisplay;
import interfaces.iGui;
import interfaces.iMenuBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.WEST;

public class Gui implements iGui {
    private iMenuBar menu;
    private iDisplay[] components;
    private JFrame f;
    private JTabbedPane tabs;
    private JPanel characterSheet;
    private JPanel sheetEditor;
    private AbilitiesDisplay abilitiesDisplay;
    private CosmeticsDisplay cosmeticsDisplay;
    private AbilityEditor abilityEditor;
    private CosmeticsEditor cosmeticsEditor;

    private ArrayList<Model> stateModels;

    public Gui(iMenuBar menu) {
        this.menu = menu;
        stateModels = new ArrayList<>();

    }

    public void run(Model abilities, Model details) {
        generateAbilities(abilities);
        generateDetails(details);
        stateModels.add(abilities);
        stateModels.add(details);
        components = new iDisplay[] {
                abilitiesDisplay,
                abilityEditor,
                cosmeticsDisplay,
                cosmeticsEditor
        };
        frameSetUp();
    }

    private void generateAbilities(Model abilities) {
        abilitiesDisplay = new AbilitiesDisplay(abilities);
        abilityEditor = new AbilityEditor(abilities);
    }

    private void generateDetails(Model details) {
        cosmeticsDisplay = new CosmeticsDisplay(details);
        cosmeticsEditor = new CosmeticsEditor(details);
    }

    private void frameSetUp() {
        f = new JFrame("Pathfinder Character Sheet");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabSetUp();
        menu.menuSetUp(f, stateModels);
        for (iDisplay component : components) { component.display(); }
        f.getContentPane().add(tabs);
        f.setSize(1200, 800);
        f.setVisible(true);
    }

    private void tabSetUp() {
        tabs = new JTabbedPane();
        characterSheetSetUp();
        sheetEditorSetUp();
        tabs.addTab("Character Sheet", characterSheet);
        tabs.addTab("Edit", sheetEditor);
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
}
