package Gui.Editor;

import CharacterCosmetics.CosmeticDetails;
import Gui.JGridPanel;
import Models.Model;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class CosmeticsEditor extends JPanel implements iDisplay, Observer {
    private CosmeticDetails details;
    private Hashtable<String, JTextArea> map;
    private JGridPanel textPanes;
    private JLabel label;
    private JTextArea field;
    private JButton button;
    private CosmeticsEditorListener listener;

    public CosmeticsEditor(Model details) {
        this.details = (CosmeticDetails) details;
        this.details.addObserver(this);
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
            if (!detailText.isEmpty() && !detailText.matches(details.getData(detail))) {
                details.setData(detail, detailText);
                details.setIsSaved(false);
                details.notifyObservers(detail);
            }
        }
    }

    public void update(Observable observable, Object o) {
        CosmeticDetails observableDetails = (CosmeticDetails) observable;
        String changedDetail = (String) o;
        map.get(changedDetail).setText(observableDetails.getData(changedDetail));
    }

    private class CosmeticsEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            updateDetails();
        }
    }
}
