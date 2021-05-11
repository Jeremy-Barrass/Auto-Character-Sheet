package Gui.Display;

import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import SheetConstants.CosmeticDetailsLabels;

import javax.swing.*;
import java.util.HashMap;
import java.util.Observable;

public class CosmeticsDisplay extends Display {
    private CosmeticDetails details;
    private JLabel detailLabel;
    private JLabel detail;

    public CosmeticsDisplay(Model details) {
        this.details = (CosmeticDetails) details;
        this.details.addObserver(this);
        labelDataMap = new HashMap<>();
    }

    public void display() {
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            detailLabel = new JLabel();
            detailLabel.setText(String.format("| %s:", label));
            add(detailLabel);
            detail = new JLabel();
            detail.setText(String.format("%s |", details.getData(label)));
            add(detail);
            labelDataMap.put(label, detail);
        }
    }

    public void update(Observable o, Object arg) {
        CosmeticDetails observableDetails = (CosmeticDetails) o;
        String changedDetail = (String) arg;
        labelDataMap.get(changedDetail).setText(String.format("%s |", observableDetails.getData(changedDetail)));
    }
}
