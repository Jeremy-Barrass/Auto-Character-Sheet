package Gui.Display;

import CharacterCosmetics.CosmeticDetails;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iCosmeticDetails;
import interfaces.iDisplay;

import javax.swing.*;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class CosmeticsDisplay extends JPanel implements iDisplay, Serializable, Observer {
    private CosmeticDetails details;
    private Hashtable<String, JLabel> map;
    private JLabel detailLabel;
    private JLabel detail;

    public CosmeticsDisplay(iCosmeticDetails details) {
        this.details = (CosmeticDetails) details;
        this.details.addObserver(this);
        map = new Hashtable<>();
    }

    public void display() {
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            detailLabel = new JLabel();
            detailLabel.setText(label);
            add(detailLabel);
            detail = new JLabel();
            detail.setText(details.getDetail(label));
            add(detail);
            map.put(label, detail);
        }
    }

    public void update(Observable o, Object arg) {
        CosmeticDetails observableDetails = (CosmeticDetails) o;
        String changedDetail = (String) arg;
        map.get(changedDetail).setText(observableDetails.getDetail(changedDetail));
    }
}
