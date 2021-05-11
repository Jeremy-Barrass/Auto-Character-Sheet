package interfaces;

import Models.Model;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public interface iMenuBar {
    void menuSetUp(JFrame frame, ArrayList<Model> stateModels);
}
