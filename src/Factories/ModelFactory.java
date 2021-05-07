package Factories;

import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import Models.RulesLogic.Abilities;
import interfaces.iModelFactory;

public class ModelFactory implements iModelFactory {
    public Model createModel(String type) {
        switch (type) {
            case "abilities":
                return new Abilities();
            case "cosmetics":
                return new CosmeticDetails();
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
