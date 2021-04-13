package Gui;

import Gui.Display.AbilitiesDisplay;
import Gui.Display.CosmeticsDisplay;
import Gui.Editor.AbilityEditor;
import Gui.Editor.CosmeticsEditor;
import interfaces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;

public class Gui implements iGui {
    private iMenuBar menu;
    private iSaveFileProcessor saveProc;
    private iDisplay[] components;
    private NewFileListener newListener;
    private LoadFileListener loadListener;
    private SaveFileListener saveListener;
    private JFrame f;
    private JTabbedPane tabs;
    private JPanel characterSheet;
    private JPanel sheetEditor;
    private AbilitiesDisplay abilitiesDisplay;
    private CosmeticsDisplay cosmeticsDisplay;
    private AbilityEditor abilityEditor;
    private CosmeticsEditor cosmeticsEditor;

    private ActionListener[] listeners;

    public Gui(iMenuBar menu) {
        this.menu = menu;
        newListener = new NewFileListener();
        loadListener = new LoadFileListener();
        saveListener = new SaveFileListener();
        listeners = new ActionListener[] {
                newListener,
                loadListener,
                saveListener
        };
    }

    public void setSaveFileProcessor(iSaveFileProcessor saver) {
        saveProc = saver;
    }

    private void generateAbilities(iAbilities abilities) {
        abilitiesDisplay = new AbilitiesDisplay(abilities);
        abilityEditor = new AbilityEditor(abilities);
    }

    private void generateDetails(iCosmeticDetails details) {
        cosmeticsDisplay = new CosmeticsDisplay(details);
        cosmeticsEditor = new CosmeticsEditor(details);
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
        menu.menuSetUp(f, listeners);
        for (iDisplay component : components) { component.display(); }
        f.getContentPane().add(tabs);
        f.setSize(1200, 800);
        f.setVisible(true);
    }

    public void run(iAbilities abilities, iCosmeticDetails details) {
        generateAbilities(abilities);
        generateDetails(details);
        saveProc.setSaveModels(abilities, details);
        components = new iDisplay[] {
                abilitiesDisplay,
                abilityEditor,
                cosmeticsDisplay,
                cosmeticsEditor
        };
        frameSetUp();
    }

    private class NewFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class LoadFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    private class SaveFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser dialogue = new JFileChooser();
            dialogue.showSaveDialog(f);
            saveProc.saveFile(dialogue.getSelectedFile());
        }
    }
}
