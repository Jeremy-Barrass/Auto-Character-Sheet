package Gui.ActionProcessors;

import Models.CharacterCosmetics.CosmeticDetails;
import Exceptions.FileNotSavedException;
import Models.Model;
import Models.RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iNewFileProcessor;

import java.util.ArrayList;

public class NewFileProcessor implements iNewFileProcessor {
    public void CreateNewFile(ArrayList<Model> models) throws FileNotSavedException {
        for (Model model : models) {
            if (model instanceof Abilities) {
                resetToDefault(AbilityNames.listAbilityNames(), model, 0);
            } else if (model instanceof CosmeticDetails) {
                resetToDefault(CosmeticDetailsLabels.listCosmeticDetails(), model, "");
            }
        }
    }

    private void resetToDefault(String[] labelList, Model model, Object defaultData) throws FileNotSavedException {
        if (!model.getIsSaved()) {
            throw new FileNotSavedException();
        }
        for (String label : labelList) {
            model.setData(label, defaultData);
            model.notifyObservers(label);
        }
    }
}
