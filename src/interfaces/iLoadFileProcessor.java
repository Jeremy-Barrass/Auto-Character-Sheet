package interfaces;

import java.io.File;
import java.util.ArrayList;

public interface iLoadFileProcessor {
    void loadFile(File file, ArrayList<Object> stateModelList);
}
