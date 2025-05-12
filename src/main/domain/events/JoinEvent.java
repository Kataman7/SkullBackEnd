package main.domain.events;

import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.GameFullRule;
import main.domain.rules.NotRule;
import main.domain.rules.ValidPlayerRule;

import java.util.List;

public class JoinEvent extends PlayerEvent
{
    public JoinEvent(String playerName)
    {
        super(playerName);
        super.getRules().addAll(List.of(
                new NotRule(new ValidPlayerRule(getPlayerName())),
                new GameFullRule()
        ));
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
