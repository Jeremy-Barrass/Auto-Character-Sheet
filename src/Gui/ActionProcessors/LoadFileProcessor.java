package Gui.ActionProcessors;

import interfaces.iLoadFileProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoadFileProcessor implements iLoadFileProcessor {
    public void loadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
        } catch (Exception exception) {

        }
    }
}
