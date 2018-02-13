package Gui.ActionProcessors;

import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iSaveFileProcessor;

import java.io.*;

public class SaveFileProcessor implements iSaveFileProcessor, Serializable {
    private iAbilities abilities;
    private iCosmeticDetails cosmeticDetails;

    public void setSaveModels(iAbilities abilities, iCosmeticDetails details) {
        this.abilities = abilities;
        this.cosmeticDetails = details;
    }

    public void saveFile(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
                writer.write(detail + " : " + cosmeticDetails.getDetail(detail) + "\n");
            }
            for (String ability : AbilityNames.listAbilityNames()) {
                writer.write(ability + " : " + abilities.getAbilityScore(ability) + "\n");
            }
            writer.close();
        } catch (IOException exception) {
            System.out.println("Could not save character, sorry.");
            exception.printStackTrace();
        }
    }
}
