import Gui.Gui;
import RulesLogic.Abilities;
import interfaces.iAbilities;
import interfaces.iGui;

import java.io.Serializable;

public class characterSheet implements Serializable {

	private iGui gui;
	private String characterName;
	private iAbilities abilityScores;


    public characterSheet() {
        this("", new Gui(), new Abilities());
    }

    public characterSheet(String name, iGui gui, iAbilities abilities) {
		this.characterName = name;
		this.gui = gui;
		this.abilityScores = abilities;
	}

	public void setCharacterName(String name) {
		this.characterName = name;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void generateGui() {
        gui.run(this.abilityScores);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet();
        sheet.generateGui();
    }
}