package main.domain.rules;

import main.domain.model.Board;
import main.domain.model.Player;

public class DeckEmptyRule extends PlayerRule {

    public DeckEmptyRule()
    {
        super(null);
    }
    public DeckEmptyRule(String playerName)
    {
        super(playerName);
    }
    @Override
    public boolean isApplicable(Board board)
    {
        Player player = getPlayerName() == null
                ? board.getPlayers().getCurrent()
                : board.getPlayers().getByName(getPlayerName());

        return player.getDeckSize() == 0;
    }

    @Override
    public int getCode() {
        return RuleCodes.DECK_EMPTY.ordinal();
    }
}
