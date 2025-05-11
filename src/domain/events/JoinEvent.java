package domain.events;

import domain.model.Board;
import domain.model.Player;

public class JoinEvent extends PlayerEvent
{
    protected JoinEvent(String playerName)
    {
        super(playerName);
    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().add(new Player(getPlayerName()));
    }

    @Override
    public String toString() {
        return super.getPlayerName() + " join the room.";
    }
}
