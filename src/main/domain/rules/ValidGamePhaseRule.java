package main.domain.rules;

import main.domain.enums.ErrorCodes;
import main.domain.enums.Phases;

public class ValidGamePhaseRule implements GameRule
{
    private final Phases phases;

    public ValidGamePhaseRule(Phases phases)
    {
        this.phases = phases;
    }

    @Override
    public boolean isApplicable(main.domain.model.Board board)
    {
        return board.getPhase().equals(phases);
    }

    @Override
    public int getCode() {
        return main.domain.enums.ErrorCodes.GAME_EMPTY.ordinal();
    }
}
