package main.domain.rules;

import main.domain.model.Board;

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
        return RuleCodes.VALID_PLAYER.ordinal();
    }
}
