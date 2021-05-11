package interfaces;

import Exceptions.FileNotSavedException;
import Models.Model;

import java.util.ArrayList;

public interface iNewFileProcessor {
    void CreateNewFile(ArrayList<Model> models) throws FileNotSavedException;
}
