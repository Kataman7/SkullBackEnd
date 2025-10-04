package main.domain.rules;

import main.domain.model.Board;
import main.domain.enums.Phases;
import main.domain.enums.ErrorCodes;

public class GameBuyBuildPhase implements GameRule {


    @Override
    public boolean isApplicable(Board board) {
        return board.getPhase().equals( Phases.Buy_Builds);
    }

    @Override
    public int getCode() {return ErrorCodes.GAME_EMPTY.ordinal();
    }


}
