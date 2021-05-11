package interfaces;

import Models.Model;

import java.io.File;
import java.util.ArrayList;

public interface iSaveFileProcessor {
    void saveFile(File file, ArrayList<Model> modelList);
}
