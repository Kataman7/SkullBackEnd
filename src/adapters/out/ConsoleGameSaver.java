package adapters.out;

import application.port.out.GameStateSaver;
import domain.model.Board;
import domain.model.Player;

public class ConsoleGameSaver implements GameStateSaver {

    @Override
    public void save(Board board) {
        System.out.println("=== État du jeu ===");

        System.out.println(board);

        System.out.println("===================");
    }
}