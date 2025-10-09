package main.domain.rules;

import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.model.Player;

public class BuildRessourcesIsEmptyRule extends PlayerRule
{
    private final int buildIndex;

    public BuildRessourcesIsEmptyRule(String playerName, int buildIndex) {
        super(playerName);
        this.buildIndex = buildIndex;
    }

    @Override
    public boolean isApplicable(Board board) {
        Player player = board.getPlayers().getByName(super.getPlayerName());
        Build build = player.getBuilds().get(buildIndex);
        return build.getRessources().isEmpty();
    }

    @Override
    public int getCode() {
        return 0;
    }
}
