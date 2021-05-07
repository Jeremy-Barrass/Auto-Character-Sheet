package Factories;

import Gui.Editor.AbilityEditor;
import Gui.Editor.CosmeticsEditor;
import Gui.Editor.Editor;
import Models.CharacterCosmetics.CosmeticDetails;
import Models.Model;
import Models.RulesLogic.Abilities;
import interfaces.iEditorFactory;

public class EditorFactory implements iEditorFactory {
    @Override
    public Editor createEditor(Model model) {
        if (model instanceof Abilities) {
            return new AbilityEditor(model);
        } else if (model instanceof CosmeticDetails) {
            return new CosmeticsEditor(model);
        } else {
            throw new NoClassDefFoundError();
        }
    }
}
