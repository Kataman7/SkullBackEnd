package main.domain.rules;

import main.domain.model.Board;
import main.domain.model.Phases;

public class GameBuyBuildPhase implements GameRule {


    @Override
    public boolean isApplicable(Board board) {
        return board.getPhase().equals( Phases.Buy_Builds);
    }

    @Override
    public int getCode() {return RuleCodes.GAME_EMPTY.ordinal();
    }


}
