package domain.rules;

import domain.model.Board;

public class DeckNotEmptyRule extends PlayerRule {

    public DeckNotEmptyRule(String playerName) {
        super(playerName);
    }

    @Override
    public boolean isApplicable(Board board) {
        return board.getPlayers().getByName(super.getPlayerName()).getDeckSize() == 0;
    }
}
