package main.domain.rules;

import main.domain.model.Board;

public class GameEmptyRule implements GameRule
{
    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().size() < 2;
    }
}
