package interfaces;

import Exceptions.FileNotSavedException;
import Models.Model;

import java.io.File;
import java.util.ArrayList;

public interface iLoadFileProcessor {
    void loadFile(File file, ArrayList<Model> stateModelList) throws FileNotSavedException;
}
