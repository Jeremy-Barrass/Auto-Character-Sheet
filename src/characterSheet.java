import CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.LoadFileProcessor;
import Gui.ActionProcessors.NewFileProcessor;
import Gui.ActionProcessors.SaveFileProcessor;
import Gui.Gui;
import Gui.Menu.MenuBar;
import Models.Model;
import RulesLogic.Abilities;
import interfaces.*;

public class characterSheet implements iCharacterSheet {

    private iGui gui;
	private Model abilityScores;
	private iCosmeticDetails cosmeticDetails;

    public characterSheet(String[] config,
                          iGui gui,
                          Model abilities,
                          iCosmeticDetails details) {
		this.gui = gui;
		this.abilityScores = abilities;
		this.cosmeticDetails = details;
		cosmeticDetails.setConfigDetails(config);

	}

    public void generateGui() {
        gui.run(this.abilityScores, this.cosmeticDetails);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet(args,
                new Gui(
                        new MenuBar(),
                        new SaveFileProcessor(),
                        new LoadFileProcessor(),
                        new NewFileProcessor()
                ),
                new Abilities(),
                new CosmeticDetails());
        sheet.generateGui();
    }
}