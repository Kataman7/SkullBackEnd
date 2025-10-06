package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.model.GameMap;
import main.domain.model.Player;
import main.domain.rules.*;

import java.util.List;

public class PlaceBuildEvent extends PlayerEvent {
    private final int buildIndex;
    private final int x;
    private final int y;

    public PlaceBuildEvent(String playerName, int buildIndex, int x, int y, int sizeX, int sizeY) {
        super(playerName);
        this.buildIndex = buildIndex;
        this.x = x;
        this.y = y;

        super.getRules().addAll(List.of(
                new ValidPlayerRule(playerName),
                new ValidBuildIndexRule(playerName, buildIndex),
                new ValidMapPositionRule(x, y, sizeX, sizeY)
        ));
    }

    @Override
    public void apply(Board board) {
        Player player = board.getPlayers().getByName(getPlayerName());
        GameMap gameMap = board.getGameMap();
        Build build = player.getBuilds().get(buildIndex);

        for (int i = 0; i < build.getSizeX(); i++) {
            for (int j = 0; j < build.getSizeY(); j++) {
                int xi = x + i;
                int yj = y + j;
                boolean isOrigin = (i == 0 && j == 0);
                gameMap.setCell(xi, yj, new GameMap.BuildCell(build, isOrigin));
            }
        }
    }

    @Override
    public String toJson() {
        return "";
    }
}
