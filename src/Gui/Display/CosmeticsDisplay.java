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
    private CosmeticDetails Details;
    private Hashtable<JLabel, JLabel> Map;
    private JLabel Label;
    private JLabel Detail;

    public CosmeticsDisplay(iCosmeticDetails details) {
        Details = (CosmeticDetails) details;
        Map = new Hashtable<>();
    }

    public void Display() {
        Label = new JLabel();
        Detail = new JLabel();
        for (String label : CosmeticDetailsLabels.ListCosmeticDetails()) {
            Label.setText(label);
            add(Label);
            Detail.setText(Details.GetDetail(label));
            add(Detail);
            Map.put(Label, Detail);
        }
    }

    public void update(Observable o, Object arg) {
        CosmeticDetails details = (CosmeticDetails) o;
        String changedDetail = (String) arg;
        Map.get(changedDetail).setText(Details.GetDetail(changedDetail));
    }
}
