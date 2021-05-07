import Models.CharacterCosmetics.CosmeticDetails;
import Gui.ActionProcessors.LoadFileProcessor;
import Gui.ActionProcessors.NewFileProcessor;
import Gui.ActionProcessors.SaveFileProcessor;
import Gui.Gui;
import Gui.Menu.MenuBar;
import Models.Model;
import Models.RulesLogic.Abilities;
import interfaces.*;

public class characterSheet implements iCharacterSheet {

    private iGui gui;
	private Model abilityScores;
	private Model cosmeticDetails;

    public characterSheet(String[] config,
                          iGui gui,
                          Model abilities,
                          Model details) {
		this.gui = gui;
		this.abilityScores = abilities;
		this.cosmeticDetails = details;
		((CosmeticDetails) cosmeticDetails).setConfigDetails(config);

	}

    public void generateGui() {
        gui.run(this.abilityScores, this.cosmeticDetails);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet(args,
                new Gui(
                        new MenuBar()
                ),
                new Abilities(),
                new CosmeticDetails());
        sheet.generateGui();
    }
}