package main.domain.events;

import main.domain.model.Board;
import main.domain.rules.*;

import java.util.List;

public class BetEvent extends PlayerEvent
{
    private final int betValue;

    public BetEvent(String playerName, int betValue) {
        super(playerName);
        this.betValue = betValue;

        super.getRules().addAll(List.of(
                new NotRule(new GameEmptyRule()),
                new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new DeckEmptyRule(getPlayerName()),
                new ValidBetRule(betValue),
                new NotRule(new ValidBettorRule(playerName)),
                new NotRule(new PlayerTurnRule(getPlayerName()))
        ));
    }

    @Override
    public void apply(Board board) {
        board.setBetValue(betValue);
        board.setBettor(getPlayerName());
    }
}
