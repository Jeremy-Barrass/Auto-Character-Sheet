package Gui.Menu;

import Exceptions.FileNotSavedException;
import Gui.ActionProcessors.LoadFileProcessor;
import Gui.ActionProcessors.NewFileProcessor;
import Gui.ActionProcessors.SaveFileProcessor;
import Gui.Gui;
import Models.Model;
import interfaces.iLoadFileProcessor;
import interfaces.iMenuBar;
import interfaces.iNewFileProcessor;
import interfaces.iSaveFileProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MenuBar extends JMenuBar implements iMenuBar {
    private JFrame f;
    private JMenu fileMenu;
    private JMenuItem newMenuSelector;
    private JMenuItem loadMenuSelector;
    private JMenuItem saveMenuSelector;

    private NewFileListener newListener;
    private LoadFileListener loadListener;
    private SaveFileListener saveListener;

    private iSaveFileProcessor saveProc;
    private iLoadFileProcessor loadProc;
    private iNewFileProcessor newProc;

    private String[] names;
    private JMenuItem[] menuItems;
    private ActionListener[] listeners;

    private ArrayList<Model> stateModels;
    private File fileToLoad;

    public MenuBar() {
        names = new String[] {
                "New",
                "Load",
                "Save"
        };
        menuItems = new JMenuItem[] {
                newMenuSelector,
                loadMenuSelector,
                saveMenuSelector
        };
        newListener = new NewFileListener();
        loadListener = new LoadFileListener();
        saveListener = new SaveFileListener();
        listeners = new ActionListener[] {
                newListener,
                loadListener,
                saveListener
        };
        newProc = new NewFileProcessor();
        loadProc =  new LoadFileProcessor();
        saveProc = new SaveFileProcessor();
    }

    public void menuSetUp(JFrame frame, ArrayList<Model> stateModels) {
        fileMenu = new JMenu("File");
        this.stateModels = stateModels;
        createMenuItems();
        createFileMenu();
        add(fileMenu);
        frame.setJMenuBar(this);
        f = frame;
    }

    private void createMenuItems() {
        for (int x = 0; x < menuItems.length; x++) {
            menuItems[x] = new JMenuItem(names[x]);
            menuItems[x].addActionListener(listeners[x]);
        }
    }

    private void createFileMenu() {
        for (Component item : menuItems) {
            fileMenu.add(item);
        }
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
