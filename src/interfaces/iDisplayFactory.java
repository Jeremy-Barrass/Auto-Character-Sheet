package interfaces;

import Gui.Display.Display;
import Models.Model;

public interface iDisplayFactory {
    Display createDisplay(Model model);
}
