package Gui;

import javax.swing.*;
import java.io.Serializable;

public class JColumn extends JPanel implements Serializable {

    public JColumn() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
