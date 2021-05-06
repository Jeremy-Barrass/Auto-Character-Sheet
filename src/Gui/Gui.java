package Gui;

import Exceptions.FileNotSavedException;
import Gui.Display.AbilitiesDisplay;
import Gui.Display.CosmeticsDisplay;
import Gui.Editor.AbilityEditor;
import Gui.Editor.CosmeticsEditor;
import Models.Model;
import interfaces.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import static java.awt.BorderLayout.*;

public class Gui implements iGui {
    private iMenuBar menu;
    private iSaveFileProcessor saveProc;
    private iLoadFileProcessor loadProc;
    private iNewFileProcessor newProc;
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
    private ArrayList<Model> stateModels;

    private File fileToLoad;

    public Gui(iMenuBar menu, iSaveFileProcessor saveFileProcessor, iLoadFileProcessor loadFileProcessor, iNewFileProcessor newFileProcessor) {
        this.menu = menu;
        stateModels = new ArrayList<>();

        this.saveProc = saveFileProcessor;
        this.loadProc = loadFileProcessor;
        this.newProc = newFileProcessor;
        saveListener = new SaveFileListener();
        loadListener = new LoadFileListener();
        newListener = new NewFileListener();
        listeners = new ActionListener[] {
                saveListener,
                loadListener,
                newListener
        };
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
        menu.menuSetUp(f, listeners);
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

    private class SaveFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            displaySaveFileMenu();
        }
    }

    private void displaySaveFileMenu() {
        JFileChooser dialogue = new JFileChooser();
        dialogue.showSaveDialog(f);
        saveProc.saveFile(dialogue.getSelectedFile(), stateModels);
    }

    private class LoadFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser dialogue = new JFileChooser();
            dialogue.showOpenDialog(f);
            loadFile(dialogue.getSelectedFile());
        }
    }

    private void loadFile(File file) {
        try{
            loadProc.loadFile(file, stateModels);
        } catch (FileNotSavedException e) {
            fileToLoad = file;
            showFileNotSavedDialogue(stateModels, true);
        }
    }

    private void showFileNotSavedDialogue(ArrayList<Model> stateModels, boolean isLoading) {
        int option = JOptionPane.showConfirmDialog(f,
                "This Character Sheet has not been saved!\n" +
                "Do you want to save this Character?",
                "Character not saved!",
                JOptionPane.YES_NO_OPTION);
        if (option < 1) {
            displaySaveFileMenu();
        } else {
            for (Model model : stateModels) {
                model.setIsSaved(true);
            }
            if (isLoading) {
                loadFile(fileToLoad);
            } else {
                displayNewFile();
            }
        }
    }

    private class NewFileListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            displayNewFile();
        }
    }

    private void displayNewFile() {
        try {
            newProc.CreateNewFile(stateModels);
        } catch (FileNotSavedException e) {
            showFileNotSavedDialogue(stateModels, false);
        }
    }
}
