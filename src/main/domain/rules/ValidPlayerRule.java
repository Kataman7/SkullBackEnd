package main.domain.rules;

import main.domain.model.Board;
import main.domain.enums.ErrorCodes;

public class ValidPlayerRule extends PlayerRule
{
    public ValidPlayerRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getByName(super.getPlayerName()) != null;
    }

    @Override
    public int getCode() {
        return ErrorCodes.VALID_PLAYER.ordinal();
    }
}
