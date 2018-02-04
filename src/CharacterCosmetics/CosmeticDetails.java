package CharacterCosmetics;

import SheetConstants.CosmeticDetailsLabels;
import interfaces.iCosmeticDetails;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Observable;

public class CosmeticDetails extends Observable implements iCosmeticDetails, Serializable {
    private static Hashtable<String, String> Details;

    public CosmeticDetails() {
        Details = new Hashtable<String, String>();
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            Details.put(label, "");
        }
    }

    public String getDetail(String detail) {
        return Details.get(detail);
    }

    public void setDetail(String label, String detail) {
        if (!Details.keySet().contains(label)) return;

        Details.put(label, detail);
        this.setChanged();
    }
}
