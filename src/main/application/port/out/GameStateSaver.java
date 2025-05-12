package main.application.port.out;

import main.domain.model.Board;

public interface GameStateSaver {
    void save(Board game);
}