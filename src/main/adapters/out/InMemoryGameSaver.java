package main.adapters.out;

import main.application.port.out.GameStateSaver;
import main.domain.model.Board;

public class InMemoryGameSaver implements GameStateSaver {

    private Board lastSavedGame;

    @Override
    public void save(Board game) {
        this.lastSavedGame = game;
    }

    public Board getLastSavedGame() {
        return lastSavedGame;
    }
}