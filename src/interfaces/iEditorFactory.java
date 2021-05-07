package interfaces;

import Gui.Editor.Editor;
import Models.Model;

public interface iEditorFactory {
    Editor createEditor(Model model);
}
