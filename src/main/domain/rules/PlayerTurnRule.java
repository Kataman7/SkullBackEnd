package main.domain.rules;

import main.domain.model.Board;

public class PlayerTurnRule extends PlayerRule
{
    public PlayerTurnRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getCurrent().getName().equals(getPlayerName());
    }
}
