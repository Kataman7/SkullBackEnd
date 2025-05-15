package main.domain.rules;

import main.domain.model.Board;

public class ValidBettorRule extends PlayerRule
{
    public ValidBettorRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getBettor().getName().equals(getPlayerName());
    }

    @Override
    public int getCode() {
        return RuleCodes.VALID_BETTOR.ordinal();
    }
}
