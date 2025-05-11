package domain.events;

import domain.model.Board;
import domain.model.Player;
import domain.rules.GameRule;

public class LeaveEvent extends PlayerEvent
{
    public LeaveEvent(String playerName)
    {
        super(playerName);
    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().remove(new Player(super.getPlayerName()));
    }
}
