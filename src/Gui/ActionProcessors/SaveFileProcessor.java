package Gui.ActionProcessors;

import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iSaveFileProcessor;
import interfaces.iSaveMonitor;

import java.io.*;
import java.util.ArrayList;

public class SaveFileProcessor<T> implements iSaveFileProcessor {
    public void saveFile(File file, ArrayList<Object> modelList) {
        if (!file.getName().isEmpty() && file.getName() != null) {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Object model : modelList) {
                    if (model instanceof iAbilities) {
                        for (String ability : AbilityNames.listAbilityNames()) {
                            writer.write(ability + ":" + ((iAbilities) model).getAbilityScore(ability) + "\n");
                        }
                        ((iSaveMonitor) model).setIsSaved(true);
                    } else if (model instanceof iCosmeticDetails) {
                        for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
                            writer.write(detail + ":" + ((iCosmeticDetails) model).getDetail(detail) + "\n");
                        }
                        ((iSaveMonitor) model).setIsSaved(true);
                    }
                }
            } catch (IOException exception) {
                System.out.println("Could not save character, sorry.");
                exception.printStackTrace();
            }
        }
    }
}
