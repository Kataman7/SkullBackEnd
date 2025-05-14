package main.domain.rules;

import main.domain.model.Board;

public class GameFullRule implements GameRule
{
    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().size() <= 16;
    }

    @Override
    public int getCode() {
        return RuleCodes.GAME_FULL.ordinal();
    }
}
