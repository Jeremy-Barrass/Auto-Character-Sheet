package interfaces;

import Exceptions.FileNotSavedException;

import java.util.ArrayList;

public interface iNewFileProcessor {
    void CreateNewFile(ArrayList<Object> models) throws FileNotSavedException;
}
