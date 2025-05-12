package main.domain.events;

import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.ValidPlayerRule;

import java.util.List;

public class LeaveEvent extends PlayerEvent
{
    public LeaveEvent(String playerName)
    {
        super(playerName);

        super.getRules().addAll(List.of(
                new ValidPlayerRule(getPlayerName())
        ));

    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().remove(new Player(super.getPlayerName()));
    }
}
