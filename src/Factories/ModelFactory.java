package Factories;

import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import Models.RulesLogic.Abilities;
import interfaces.iModelFactory;

public class ModelFactory implements iModelFactory {
    private String[] cosmeticConfig;

    public ModelFactory(String[] cosmeticConfig) {
        this.cosmeticConfig = cosmeticConfig;
    }

    public Model createModel(String type) {
        switch (type) {
            case "abilities":
                return new Abilities();
            case "cosmetics":
                CosmeticDetails cosmeticDetails = new CosmeticDetails();
                cosmeticDetails.setConfigDetails(cosmeticConfig);
                return cosmeticDetails;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
