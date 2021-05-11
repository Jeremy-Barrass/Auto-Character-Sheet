package Gui.Editor;

import interfaces.iDisplay;

import javax.swing.*;
import java.util.HashMap;
import java.util.Observer;

public abstract class Editor<T> extends JPanel implements iDisplay, Observer {
    protected HashMap<String, T> labelDataMap;

    public abstract void display();
    public abstract void updateModel();
}
