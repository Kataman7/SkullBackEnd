package main.domain.rules;

import main.domain.model.Board;

public class InBetRule implements GameRule
{
    @Override
    public boolean isApplicable(Board board) {
        return board.getBetValue() > 0;
    }

    @Override
    public int getCode() {
        return RuleCodes.IN_BET.ordinal();
    }
}
