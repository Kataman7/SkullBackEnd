package main.domain.rules;

import main.domain.model.Board;

public class DeckEmptyRule extends PlayerRule {

    public DeckEmptyRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getByName(super.getPlayerName()).getDeckSize() == 0;
    }

    @Override
    public String toString() {
        return "game";
    }
}
