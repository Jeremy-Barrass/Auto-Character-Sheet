import interfaces.iGui;

public class CharacterSheet {

	private iGui Gui;
	private String characterName;


    public CharacterSheet() {
        this("", new Gui());
    }

    public CharacterSheet(String name, iGui gui) {
		this.characterName = name;
		this.Gui = gui;
	}

	public void setCharacterName(String name) {
		this.characterName = name;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void generateGui() {
        Gui.Run();
    }

    public static void main(String[] args) {
        CharacterSheet sheet = new CharacterSheet();
        sheet.generateGui();
    }
}