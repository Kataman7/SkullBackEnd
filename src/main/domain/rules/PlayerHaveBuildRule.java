package main.domain.rules;

import main.domain.model.Board;
import main.domain.model.Player;

public class PlayerHaveBuildRule extends PlayerRule{
    private final int buildIndex;

    public PlayerHaveBuildRule(String playerName, int buildIndex) {
        super(playerName);
        this.buildIndex = buildIndex;
    }

    @Override
    public boolean isApplicable(Board board) {
        Player player = board.getPlayers().getByName(super.getPlayerName());
        return buildIndex > 0 && buildIndex < player.getBuilds().size();
    }

    @Override
    public int getCode() {
        return 0;
    }
}
