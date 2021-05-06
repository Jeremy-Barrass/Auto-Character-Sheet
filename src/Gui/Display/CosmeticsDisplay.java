package Gui.Display;

import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iDisplay;

import javax.swing.*;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class CosmeticsDisplay extends JPanel implements iDisplay, Observer {
    private CosmeticDetails details;
    private Hashtable<String, JLabel> map;
    private JLabel detailLabel;
    private JLabel detail;

    public CosmeticsDisplay(Model details) {
        this.details = (CosmeticDetails) details;
        this.details.addObserver(this);
        map = new Hashtable<>();
    }

    public void display() {
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            detailLabel = new JLabel();
            detailLabel.setText(String.format("| %s:", label));
            add(detailLabel);
            detail = new JLabel();
            detail.setText(String.format("%s |", details.getData(label)));
            add(detail);
            map.put(label, detail);
        }
    }

    public void update(Observable o, Object arg) {
        CosmeticDetails observableDetails = (CosmeticDetails) o;
        String changedDetail = (String) arg;
        map.get(changedDetail).setText(observableDetails.getData(changedDetail));
    }
}
