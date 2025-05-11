package domain.rules;

import domain.model.Board;

public class PlayerTurnRule extends PlayerRule
{
    protected PlayerTurnRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getCurrent().getName().equals(getPlayerName());
    }
}
