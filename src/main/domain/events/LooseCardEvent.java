package main.domain.events;

import main.domain.cards.Card;
import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.DeckEmptyRule;
import main.domain.rules.NotRule;

import java.util.Deque;
import java.util.List;
import java.util.Random;

public class LooseCardEvent extends GameEvent
{
    public LooseCardEvent() {
        getRules().addAll(List.of(
                new NotRule(new DeckEmptyRule())
        ));
    }

    @Override
    public void apply(Board board) {
        Player player = board.getPlayers().getCurrent();
        Deque<Card> deck = player.getDeck();
        List<Card> hand = player.getHand();

        hand.addAll(deck);
        deck.clear();
        hand.remove(new Random().nextInt(hand.size()));
    }
}
