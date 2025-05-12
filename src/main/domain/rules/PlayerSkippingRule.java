package main.domain.rules;

import main.domain.model.Board;

public class PlayerSkippingRule extends PlayerRule{
    public PlayerSkippingRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getCurrent().getName().equals(getPlayerName());
    }
}
