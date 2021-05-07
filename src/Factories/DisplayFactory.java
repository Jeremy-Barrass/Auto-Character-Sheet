package Factories;

import Gui.Display.AbilitiesDisplay;
import Gui.Display.CosmeticsDisplay;
import Gui.Display.Display;
import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import Models.RulesLogic.Abilities;
import interfaces.iDisplayFactory;

public class DisplayFactory implements iDisplayFactory {
    public Display createDisplay(Model model) {
        if (model instanceof Abilities){
            return new AbilitiesDisplay(model);
        } else if (model instanceof CosmeticDetails) {
            return new CosmeticsDisplay(model);
        } else {
            throw new NoClassDefFoundError();
        }
    }
}
