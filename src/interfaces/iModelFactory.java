package interfaces;

import Models.Model;

public interface iModelFactory {
    Model createModel(String type);
}
