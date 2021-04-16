package Gui.ActionProcessors;

import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iLoadFileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadFileProcessor implements iLoadFileProcessor {
    public void loadFile(File file, ArrayList<Object> stateModelList) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(":");
                String key = keyValuePair[0];
                String value = keyValuePair.length > 1 ? keyValuePair[1] : "";
                for (Object model : stateModelList) {
                    if (model instanceof iAbilities && contains(AbilityNames.listAbilityNames(), key)) {
                        ((iAbilities) model).setAbilityScore(key, Integer.parseInt(value));
                    } else if (model instanceof iCosmeticDetails
                            && contains(CosmeticDetailsLabels.listCosmeticDetails(), key)) {
                        ((iCosmeticDetails) model).setDetail(key, value);
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Could not load character, sorry.");
            exception.printStackTrace();
        }
    }

    private boolean contains(String[] arr, String value) {
        return Arrays.stream(arr).anyMatch(value::equals);
    }
}
