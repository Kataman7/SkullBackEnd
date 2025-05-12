package main.domain.events;

import main.domain.model.Board;
import main.domain.rules.*;

import java.util.List;

public class DrawCardEvent extends PlayerEvent
{
    private final int index;

    public DrawCardEvent(String playerName, int index)
    {
        super(playerName);
        this.index = index;

        getRules().addAll(List.of(
               new NotRule(new GameEmptyRule()),
               new ValidPlayerRule(getPlayerName()),
               new PlayerTurnRule(getPlayerName()),
               new NotRule(new InBetRule()),
               new ValidHandSize(getPlayerName())
        ));
    }

    @Override
    public void apply(Board board)
    {
        board.getPlayers().getCurrent().drawCard(index);
    }
}
