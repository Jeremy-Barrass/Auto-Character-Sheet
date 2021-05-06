package Gui.ActionProcessors;

import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import Models.RulesLogic.Abilities;
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
                        writeToFile(writer, AbilityNames.listAbilityNames(), model);
                        model.setIsSaved(true);
                    } else if (model instanceof CosmeticDetails) {
                        writeToFile(writer, CosmeticDetailsLabels.listCosmeticDetails(), model);
                        model.setIsSaved(true);
                    }
                }
            } catch (IOException exception) {
                System.out.println("Could not save character, sorry.");
                exception.printStackTrace();
            }
        }
    }

    private void writeToFile(BufferedWriter writer, String[] labelList, Model model) throws IOException {
        for (String label : labelList) {
            writer.write(label + ":" + model.getData(label) + "\n");
        }
    }
}
