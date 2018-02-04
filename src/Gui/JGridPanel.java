package Gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class JGridPanel extends JPanel implements Serializable {
    private GridLayout grid;

    public JGridPanel(int rows, int cols) {
        grid = new GridLayout(rows, cols);
        grid.setHgap(2);
        grid.setVgap(2);
        setLayout(grid);
    }
}
