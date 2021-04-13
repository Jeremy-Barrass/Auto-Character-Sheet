package Gui.Menu;

import interfaces.iMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar implements iMenuBar {
    private JMenu fileMenu;
    private JMenuItem newMenuSelector;
    private JMenuItem loadMenuSelector;
    private JMenuItem saveMenuSelector;
    private JMenuItem[] menuItems;
    private String[] names;

    public MenuBar() {
         menuItems = new JMenuItem[] {
                newMenuSelector,
                loadMenuSelector,
                saveMenuSelector
        };
         names = new String[] {
                "New",
                "Load",
                "Save"
        };
    }

    public void menuSetUp(JFrame frame, ActionListener[] listeners) {
        fileMenu = new JMenu("File");
        createMenuItems(menuItems, listeners, names);
        createFileMenu(fileMenu, menuItems);
        add(fileMenu);
        frame.setJMenuBar(this);
    }

    private void createMenuItems(JMenuItem[] items, ActionListener[] listeners, String[] names) {
        for (int x = 0; x < items.length; x++) {
            items[x] = new JMenuItem(names[x]);
            items[x].addActionListener(listeners[x]);
        }
    }

    private void createFileMenu(JMenu menu, JMenuItem[] list) {
        for (Component item : list) {
            menu.add(item);
        }
    }

}
