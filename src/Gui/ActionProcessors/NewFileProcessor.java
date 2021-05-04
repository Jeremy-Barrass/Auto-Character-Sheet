package Gui.ActionProcessors;

import CharacterCosmetics.CosmeticDetails;
import Exceptions.FileNotSavedException;
import Models.Model;
import RulesLogic.Abilities;
import SheetConstants.AbilityNames;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iCosmeticDetails;
import interfaces.iNewFileProcessor;

import java.util.ArrayList;

public class NewFileProcessor implements iNewFileProcessor {
    public void CreateNewFile(ArrayList<Object> models) throws FileNotSavedException {
        for (Object model : models) {
            if (model instanceof Model) {
                Abilities abilities = (Abilities) model;
                if (!abilities.getIsSaved()) {
                    throw new FileNotSavedException();
                }
                for (String name : AbilityNames.listAbilityNames()) {
                    abilities.setData(name, 0);
                    abilities.notifyObservers(name);
                }
            } else if (model instanceof iCosmeticDetails) {
                CosmeticDetails details = (CosmeticDetails) model;
                if (!details.getIsSaved()) {
                    throw new FileNotSavedException();
                }
                for (String detail : CosmeticDetailsLabels.listCosmeticDetails()) {
                    details.setDetail(detail, "");
                    details.notifyObservers(detail);
                }
            }
        }
    }
}
