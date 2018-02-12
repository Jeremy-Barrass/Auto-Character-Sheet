import CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.SaveFileProcessor;
import Gui.Gui;
import Gui.Menu.MenuBar;
import RulesLogic.Abilities;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iGui;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Hashtable;

public class characterSheet implements Serializable {

    private iGui gui;
	private iAbilities abilityScores;
	private iCosmeticDetails cosmeticDetails;

    public characterSheet(String[] config, iGui gui, iAbilities abilities, iCosmeticDetails details) {
		this.gui = gui;
		this.abilityScores = abilities;
		this.cosmeticDetails = details;
		cosmeticDetails.setConfigDetails(config);
	}

    public void generateGui() {
        gui.run(this.abilityScores, this.cosmeticDetails);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet(args, new Gui(new MenuBar(), new SaveFileProcessor()), new Abilities(), new CosmeticDetails());
        sheet.generateGui();
    }
}