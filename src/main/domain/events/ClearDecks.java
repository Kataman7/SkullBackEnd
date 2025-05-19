package main.domain.events;

import main.domain.model.Board;
import main.domain.model.Player;

public class ClearDecks extends GameEvent
{
    @Override
    public void apply(Board board) {
        int size = board.getPlayers().size();
        for (int i = 0; i < size; i++) {
            Player player = board.getPlayers().getCurrent();
            player.clearDeck();
            board.getPlayers().next();
        }
    }
}
