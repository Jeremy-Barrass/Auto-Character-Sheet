package Gui.Display;

import interfaces.iDisplay;

import javax.swing.*;
import java.util.HashMap;
import java.util.Observer;

public abstract class Display extends JPanel implements iDisplay, Observer {
    HashMap<String, JLabel> labelDataMap;

    public abstract void display();
}
