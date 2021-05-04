package Gui.ActionProcessors;

import CharacterCosmetics.CosmeticDetails;
import Exceptions.FileNotSavedException;
import Models.Model;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iCosmeticDetails;
import interfaces.iLoadFileProcessor;

import RulesLogic.Abilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class LoadFileProcessor implements iLoadFileProcessor {
    public void loadFile(File file, ArrayList<Object> stateModelList) throws FileNotSavedException {
        if (!file.getName().isEmpty() && file.getName() != null) {
            try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    String[] keyValuePair = line.split(":");
                    String key = keyValuePair[0];
                    String value = keyValuePair.length > 1 ? keyValuePair[1] : "";
                    for (Object model : stateModelList) {
                        if (model instanceof Model && contains(AbilityNames.listAbilityNames(), key)) {
                            Abilities abilities = (Abilities) model;
                            if (!abilities.getIsSaved()) {
                                throw new FileNotSavedException();
                            }
                            abilities.setData(key, Integer.parseInt(value));
                            abilities.notifyObservers(key);
                        } else if (model instanceof iCosmeticDetails
                                && contains(CosmeticDetailsLabels.listCosmeticDetails(), key)) {
                            CosmeticDetails details = (CosmeticDetails) model;
                            if (!details.getIsSaved()) {
                                throw new FileNotSavedException();
                            }
                            details.setDetail(key, value);
                            details.notifyObservers(key);
                        }
                    }
                }
            } catch (Exception exception) {
                if (exception instanceof FileNotSavedException) {
                    throw ((FileNotSavedException) exception);
                } else {
                    System.out.println("Could not load character, sorry.");
                    exception.printStackTrace();
                }
            }

        }
    }

    private boolean contains(String[] arr, String value) {
        return Arrays.stream(arr).anyMatch(value::equals);
    }
}
