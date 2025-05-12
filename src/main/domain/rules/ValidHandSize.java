package main.domain.rules;

import main.domain.model.Board;

public class ValidHandSize extends PlayerRule
{
    public ValidHandSize(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getByName(getPlayerName()).getHandSize() > 0;
    }
}
