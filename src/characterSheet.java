import CharacterCosmetics.CosmeticDetails;
import Gui.Gui;
import RulesLogic.Abilities;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iGui;

import java.io.Serializable;

public class characterSheet implements Serializable {

	private iGui gui;
	private String characterName;
	private iAbilities abilityScores;
	private iCosmeticDetails cosmeticDetails;


    public characterSheet() {
        this("", new Gui(), new Abilities(), new CosmeticDetails());
    }

    public characterSheet(String name, iGui gui, iAbilities abilities, iCosmeticDetails details) {
		this.characterName = name;
		this.gui = gui;
		this.abilityScores = abilities;
		this.cosmeticDetails = details;
	}

	public void setCharacterName(String name) {
		this.characterName = name;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void generateGui() {
        gui.run(this.abilityScores, this.cosmeticDetails);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet();
        sheet.generateGui();
    }
}