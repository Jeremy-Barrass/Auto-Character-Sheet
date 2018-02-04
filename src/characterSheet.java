import CharacterCosmetics.CosmeticDetails;
import Gui.Gui;
import RulesLogic.Abilities;
import SheetConstants.CosmeticDetailsLabels;
import interfaces.iAbilities;
import interfaces.iCosmeticDetails;
import interfaces.iGui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class characterSheet implements Serializable {

	private String[] config;
	private Hashtable<String, String> checkList;
    private iGui gui;
	private String characterName;
	private String player;
	private iAbilities abilityScores;
	private iCosmeticDetails cosmeticDetails;


    public characterSheet() {
        this(new String[0], new Gui(), new Abilities(), new CosmeticDetails());
    }

    public characterSheet(String[] config, iGui gui, iAbilities abilities, iCosmeticDetails details) {
        this.config = config;
        this.checkList = new Hashtable<>();
		this.gui = gui;
		this.abilityScores = abilities;
		this.cosmeticDetails = details;
		setSheetFluff(this.config);
	}

	public void setCharacterName(String name) {
		this.characterName = name;
	}
	public void setPlayer(String name) { this.player = name; }

	public String getCharacterName() {
		return characterName;
	}

    public String getPlayer() {
        return player;
    }

    private void setSheetFluff(String[] config) {
        for (String label : CosmeticDetailsLabels.listCosmeticDetails()) {
            checkList.put(label.toLowerCase(), "");
        }
//        ArrayList<String> ex
        for (int x = 0; x < config.length; x++) {
            if (checkList.keySet().contains(config[x].toLowerCase())) {
                checkList.put(config[x], config[x+1]);
                config[x] = "";
                config[x+1] = "";
            }
        }
        String[] characterCosmetics = (String[]) checkList.keySet().toArray();
//        if
    }

    public void generateGui() {
        if (!characterName.isEmpty()) { cosmeticDetails.setDetail("Character Name", characterName); }
        if (!player.isEmpty()) { cosmeticDetails.setDetail("Player", player); }
        gui.run(this.abilityScores, this.cosmeticDetails);
    }

    public static void main(String[] args) {
        characterSheet sheet = new characterSheet();
        if (args.length >= 1) {
            sheet.setCharacterName(args[0]);
        }
        sheet.generateGui();
    }
}