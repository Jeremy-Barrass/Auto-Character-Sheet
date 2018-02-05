package CharacterCosmetics;

import SheetConstants.CosmeticDetailsLabels;
import interfaces.iCosmeticDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Observable;

public class CosmeticDetails extends Observable implements iCosmeticDetails, Serializable {
    private static Hashtable<String, String> Details;
    private static ArrayList<String> checkList;

    public CosmeticDetails() {
        Details = new Hashtable<String, String>();
        checkList = new ArrayList<>();
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            Details.put(label, "");
            checkList.add(label.toLowerCase());
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

    public void setConfigDetails(String[] details) {
        for (int x = 0; x < details.length-1; x++) {
            if (checkList.contains(details[x].toLowerCase())) {
                Details.put(details[x], details[x+1]);
                details[x] = null;
                details[x+1] = null;
            }
        }
        for (int y = 0; y < details.length; y++) {
            if (details[y] != null) {
                String key = (String) Details.keySet().toArray()[y];
                if (Details.get(key).isEmpty()) {
                    Details.put(key, details[y]);
                }
            }
        }
        for (String key : Details.keySet()) {
            setDetail(key, Details.get(key));
        }

    }
}
