package interfaces;

import java.io.File;

public interface iSaveFileProcessor {
   void setSaveModels(iAbilities abilities, iCosmeticDetails details);
    void saveFile(File file);
}
