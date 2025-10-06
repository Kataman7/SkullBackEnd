package main.domain.rules;

public class GameBuildPhase implements GameRule {
    @Override
    public boolean isApplicable(main.domain.model.Board board) {
        return board.getPhase().equals(main.domain.enums.Phases.Build);
    }

    @Override
    public int getCode() {
        return main.domain.enums.ErrorCodes.GAME_EMPTY.ordinal();
    }
}
