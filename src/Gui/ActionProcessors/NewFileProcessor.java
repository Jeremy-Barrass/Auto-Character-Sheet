package Gui.ActionProcessors;

import CharacterCosmetics.CosmeticDetails;
import Exceptions.FileNotSavedException;
import Models.Model;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iNewFileProcessor;

import java.util.ArrayList;

public class NewFileProcessor implements iNewFileProcessor {
    public void CreateNewFile(ArrayList<Model> models) throws FileNotSavedException {
        for (Model model : models) {
            if (model instanceof Abilities) {
                if (!model.getIsSaved()) {
                    throw new FileNotSavedException();
                }
                for (String name : AbilityNames.listAbilityNames()) {
                    model.setData(name, 0);
                    model.notifyObservers(name);
                }
            } else if (model instanceof CosmeticDetails) {
                if (!model.getIsSaved()) {
                    throw new FileNotSavedException();
                }
                for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
                    model.setData(detail, "");
                    model.notifyObservers(detail);
                }
            }
        }
    }
}
