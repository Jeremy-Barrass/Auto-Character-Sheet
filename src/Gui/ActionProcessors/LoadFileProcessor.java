package Gui.ActionProcessors;

import interfaces.iAbilities;
import interfaces.iLoadFileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class LoadFileProcessor implements iLoadFileProcessor {
    public void loadFile(File file, ArrayList<Object> stateModelList) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (Object model : stateModelList) {
                if (model instanceof iAbilities)
            }
        } catch (Exception exception) {

        }
    }
}
