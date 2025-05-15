package main.domain.events;

import main.domain.model.Board;
import main.domain.model.Player;

public class ClearDecks extends GameEvent
{
    @Override
    public void apply(Board board)
    {
        int i = board.getPlayers().size();
        Player player = board.getPlayers().getCurrent();
        while (i < board.getPlayers().size())
        {
            player.clearDeck();
            player = board.getPlayers().next();
        }
    }
}
