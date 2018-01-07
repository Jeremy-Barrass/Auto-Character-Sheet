import Gui.Gui;
import RulesLogic.Abilities;
import interfaces.iAbilities;
import interfaces.iGui;

import java.io.Serializable;

public class CharacterSheet implements Serializable {

	private iGui Gui;
	private String CharacterName;
	private iAbilities AbilityScores;


    public CharacterSheet() {
        this("", new Gui(), new Abilities());
    }

    public CharacterSheet(String name, iGui gui, iAbilities abilities) {
		this.CharacterName = name;
		this.Gui = gui;
		this.AbilityScores = abilities;
	}

	public void setCharacterName(String name) {
		this.CharacterName = name;
	}

	public String getCharacterName() {
		return CharacterName;
	}

	public void generateGui() {
        Gui.Run(this.AbilityScores);
    }

    public static void main(String[] args) {
        CharacterSheet sheet = new CharacterSheet();
        sheet.generateGui();
    }
}