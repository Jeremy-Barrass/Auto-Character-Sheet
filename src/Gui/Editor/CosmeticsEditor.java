package Gui.Editor;

import Models.CharacterCosmetics.CosmeticDetails;
import Gui.JGridPanel;
import Models.Model;
import SheetConstants.CosmeticDetailsLabels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;

public class CosmeticsEditor extends Editor<JTextArea> {
    private CosmeticDetails details;
    private JGridPanel textPanes;
    private JLabel label;
    private JTextArea field;
    private JButton button;
    private CosmeticsEditorListener listener;

    public CosmeticsEditor(Model details) {
        this.details = (CosmeticDetails) details;
        this.details.addObserver(this);
        listener = new CosmeticsEditorListener();
        labelDataMap = new HashMap<>();
        setLayout(new BorderLayout());
    }

    public void display() {
        textPanes = new JGridPanel(2, 6);
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            this.label = new JLabel(label);
            textPanes.add(this.label);
            field = new JTextArea();
            textPanes.add(field);
            labelDataMap.put(label, field);
        }
        button = new JButton("Change Character Details");
        button.addActionListener(listener);
        add(BorderLayout.CENTER, textPanes);
        add(BorderLayout.SOUTH, button);
    }

    public void updateModel() {
        updateDetails();
    }

    private void updateDetails() {
        for (String detail : labelDataMap.keySet()) {
            String detailText = labelDataMap.get(detail).getText();
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
        labelDataMap.get(changedDetail).setText(observableDetails.getData(changedDetail));
    }

    private class CosmeticsEditorListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            updateDetails();
        }
    }
}
