package main.domain.rules;

import main.domain.model.Board;
import main.domain.model.Player;

public class HandEmptyRule extends PlayerRule
{
    public HandEmptyRule()
    {
        super(null);
    }
    public HandEmptyRule(String playerName)
    {
        super(playerName);
    }
    @Override
    public boolean isApplicable(Board board)
    {
        Player player = getPlayerName() == null
                ? board.getPlayers().getCurrent()
                : board.getPlayers().getByName(getPlayerName());
        return player.getHandSize() == 0;
    }
}
