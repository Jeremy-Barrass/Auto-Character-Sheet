package Models;

import interfaces.iModel;
import interfaces.iSaveMonitor;

import java.util.Observable;

public abstract class Model<T> extends Observable implements iModel, iSaveMonitor {
    private boolean isSaved;

    public boolean getIsSaved() {
        return isSaved;
    }

    public void setIsSaved(boolean saved) {
        isSaved = saved;
    }

    public abstract void setData(String label, Object data);

    public abstract T getData(String label);
}
