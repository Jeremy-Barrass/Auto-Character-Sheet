package Gui.Editor;

import CharacterCosmetics.CosmeticDetails;
import Gui.JGridPanel;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iCosmeticDetails;
import interfaces.iDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Hashtable;

public class CosmeticsEditor extends JPanel implements iDisplay, Serializable {
    private CosmeticDetails details;
    private Hashtable<String, JTextArea> map;
    private JGridPanel textPanes;
    private JLabel label;
    private JTextArea field;
    private JButton button;
    private CosmeticsEditorListener listener;

    public CosmeticsEditor(iCosmeticDetails details) {
        this.details = (CosmeticDetails) details;
        listener = new CosmeticsEditorListener();
        map = new Hashtable<>();
        setLayout(new BorderLayout());
    }

    public void display() {
        textPanes = new JGridPanel(2, 6);
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            this.label = new JLabel(label);
            textPanes.add(this.label);
            field = new JTextArea();
            textPanes.add(field);
            map.put(label, field);
        }
        button = new JButton("Change Character Details");
        button.addActionListener(listener);
        add(BorderLayout.CENTER, textPanes);
        add(BorderLayout.SOUTH, button);
    }

    private void updateDetails() {
        for (String detail : map.keySet()) {
            String detailText = map.get(detail).getText();
            if (!detailText.isEmpty() && !detailText.matches(details.getDetail(detail))) {
                details.setDetail(detail, detailText);
                details.notifyObservers(detail);
            }
        }
    }

    private class CosmeticsEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            updateDetails();
        }
    }
}
