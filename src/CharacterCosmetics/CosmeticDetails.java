package CharacterCosmetics;

import Models.Model;
import SheetConstants.CosmeticDetailsLabels;

import java.util.ArrayList;
import java.util.Hashtable;

public class CosmeticDetails extends Model<String> {
    private static Hashtable<String, String> Details;
    private static ArrayList<String> checkList;
    private ArrayList<String> labelKeys;

    public CosmeticDetails() {
        Details = new Hashtable<String, String>();
        checkList = new ArrayList<>();
        labelKeys = new ArrayList<>();
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            Details.put(label, "");
            labelKeys.add(label);
            checkList.add(label.toLowerCase());
        }
    }

    public void setData(String label, Object data) {
        setDetail(label, (String) data);
    }

    public String getData(String label) {
        return getDetail(label);
    }

    private String getDetail(String detail) {
        return Details.get(detail);
    }

    private void setDetail(String label, String detail) {
        if (!Details.keySet().contains(label)) return;

        Details.put(label, detail);
        this.setChanged();
    }

    public void setConfigDetails(String[] details) {
        ArrayList<String> dConfig = new ArrayList<>();
        setNamedDetails(details);
        setDetailConfig(details, dConfig);
        setUnamedDetails(dConfig);
    }

    private void setDetailConfig(String[] details, ArrayList<String> dConfig) {
        for (String detail : details) {
            if (!detail.isEmpty()) {
                dConfig.add(detail);
            }
        }
    }

    private void setNamedDetails(String[] details) {
        for (int x = 0; x < details.length; x++) {
            if (checkList.contains(details[x].toLowerCase())) {
                Details.put(details[x], details[x+1]);
                details[x] = "";
                details[x+1] = "";
            }
        }
    }

    private void setUnamedDetails(ArrayList<String> dConfig) {
        for (String key : labelKeys) {
            if (Details.get(key).isEmpty()) {
                int y = labelKeys.indexOf(key);
                if (y >= dConfig.size()) return;
                Details.put(key, dConfig.get(y));
            }
        }
    }
}
