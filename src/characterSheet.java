import CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.SaveFileProcessor;
import Gui.Gui;
import Gui.Menu.MenuBar;
import RulesLogic.Abilities;
import interfaces.*;

import java.io.Serializable;

public class characterSheet implements Serializable, iCharacterSheet {

    private iGui gui;
	private iAbilities abilityScores;
	private iCosmeticDetails cosmeticDetails;
	private iSaveFileProcessor saveProc;

    public characterSheet(String[] config,
                          iSaveFileProcessor saver,
                          iGui gui,
                          iAbilities abilities,
                          iCosmeticDetails details) {
        saveProc = saver;
		this.gui = gui;
		gui.setSaveFileProcessor(saver);
		this.abilityScores = abilities;
		this.cosmeticDetails = details;
		cosmeticDetails.setConfigDetails(config);

	}

    public void generateGui() {
        gui.run(this.abilityScores, this.cosmeticDetails);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet(args,
                new SaveFileProcessor(),
                new Gui(new MenuBar()),
                new Abilities(),
                new CosmeticDetails());
        sheet.generateGui();
    }
}