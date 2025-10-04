package main.domain.rules;

import main.domain.model.Board;
import main.domain.enums.ErrorCodes;

public class GameEmptyRule implements GameRule
{
    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().size() < 2;
    }

    @Override
    public int getCode() {
        return ErrorCodes.GAME_EMPTY.ordinal();
    }


}
