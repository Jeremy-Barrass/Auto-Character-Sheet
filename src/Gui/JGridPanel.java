package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class JGridPanel extends JPanel implements Serializable {
    private GridLayout _grid;

    public JGridPanel(int rows, int cols) {
        _grid = new GridLayout(rows, cols);
        setLayout(_grid);
    }
}
