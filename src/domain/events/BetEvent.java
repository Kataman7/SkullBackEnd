package domain.events;

import domain.model.Board;

public class BetEvent extends PlayerEvent
{
    private int betValue;

    public BetEvent(String playerName, int betValue) {
        super(playerName);
        this.betValue = betValue;
    }

    @Override
    public void apply(Board board) {
        board.setBetValue(betValue);
    }
}
