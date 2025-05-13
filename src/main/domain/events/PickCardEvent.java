package main.domain.events;

import main.domain.cards.Card;
import main.domain.model.Board;
import main.domain.model.Player;
import main.domain.rules.*;

import java.util.List;

public class PickCardEvent extends PlayerEvent {
    private final String targetName;

    public PickCardEvent(String playerName, String targetName) {
        super(playerName);
        this.targetName = targetName;

        super.getRules().addAll(List.of(
                new PlayerTurnRule(super.getPlayerName()),
                new NotRule(new GameEmptyRule()),
                new ValidPlayerRule(super.getPlayerName()),
                new ValidPlayerRule(targetName),
                new DeckEmptyRule(targetName)
        ));
    }

    @Override
    public void apply(Board board) {

        Player targetPlayer = board.getPlayers().getByName(targetName);
        Card card = targetPlayer.getDeck().pop();

        targetPlayer.getHand().add(card);
    }
}
