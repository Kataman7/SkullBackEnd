package application.port.out;

import domain.model.Board;

public interface GameStateSaver {
    void save(Board game);
}