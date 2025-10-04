package main.domain.rules;

import main.domain.model.Board;
import main.domain.enums.ErrorCodes;

public class PlayerTurnRule extends PlayerRule
{
    public PlayerTurnRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getCurrent().getName().equals(getPlayerName());
    }

    @Override
    public int getCode() {
        return ErrorCodes.PLAYER_TURN.ordinal();
    }
}
