package main.domain.events;

import main.domain.cards.Card;
import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.*;

import java.util.ArrayList;
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
               new NotRule(new HandEmptyRule(getPlayerName()))
        ));
    }

    @Override
    public void apply(Board board)
    {
        Player player = board.getPlayers().getByName(getPlayerName());
        List<Card> hand = player.getHand();
        board.getPlayers().getCurrent().getDeck().push(hand.remove(index));
    }
}
