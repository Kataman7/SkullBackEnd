package main.domain.rules;

import main.domain.events.game.GameEvent;
import main.domain.model.Board;
import main.domain.model.Phases;

public class GameBuyBuilderPhase implements GameRule {


    @Override
    public boolean isApplicable(Board board) {
        return board.getPhase().equals( Phases.Buy_Builders);
    }

    @Override
    public int getCode() {
        return RuleCodes.GAME_EMPTY.ordinal();
    }


}
