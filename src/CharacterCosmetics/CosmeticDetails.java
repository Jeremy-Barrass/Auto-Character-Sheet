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
        for (String label : CosmeticDetailsLabels.ListCosmeticDetails()) {
            Details.put(label, "");
        }
    }

    public String GetDetail(String detail) {
        return Details.get(detail);
    }

    public void SetDetail(String label, String detail) {
        if (!Details.keySet().contains(label)) return;

        Details.put(label, detail);
        this.setChanged();
    }
}
