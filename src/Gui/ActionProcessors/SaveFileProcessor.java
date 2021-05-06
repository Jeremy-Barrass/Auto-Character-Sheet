package Gui.ActionProcessors;

import CharacterCosmetics.CosmeticDetails;
import Models.Model;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iSaveFileProcessor;

import java.io.*;
import java.util.ArrayList;

public class SaveFileProcessor<T> implements iSaveFileProcessor {
    public void saveFile(File file, ArrayList<Model> modelList) {
        if (!file.getName().isEmpty() && file.getName() != null) {
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (Model model : modelList) {
                    if (model instanceof Abilities) {
                        for (String ability : AbilityNames.listAbilityNames()) {
                            writer.write(ability + ":" + model.getData(ability) + "\n");
                        }
                        model.setIsSaved(true);
                    } else if (model instanceof CosmeticDetails) {
                        for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
                            writer.write(detail + ":" + model.getData(detail) + "\n");
                        }
                        model.setIsSaved(true);
                    }
                }
            } catch (IOException exception) {
                System.out.println("Could not save character, sorry.");
                exception.printStackTrace();
            }
        }
    }
}
