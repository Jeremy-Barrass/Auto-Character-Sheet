import Factories.DisplayFactory;
import Factories.EditorFactory;
import Factories.ModelFactory;
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
    private iModelFactory modelFactory;

    public characterSheet(iGui gui,
                          iModelFactory modelFactory) {
		this.gui = gui;
		this.modelFactory = modelFactory;
	}

    public void generateGui() {
        gui.run(this.modelFactory);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet(
                new Gui(
                        new MenuBar(),
                        new DisplayFactory(),
                        new EditorFactory()
                ),
                new ModelFactory(args));
        sheet.generateGui();
    }
}