package main.domain.events.game;

import main.domain.enums.Phases;
import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.model.Player;
import main.domain.rules.*;

import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;

public class CompleteBuildEvent extends PlayerEvent
{
    private final int buildIndex;

    public CompleteBuildEvent(String playerName, int buildIndex) {
        super(playerName);
        this.buildIndex = buildIndex;

        super.getRules().addAll(List.of(
                new ValidPlayerRule(playerName),
                new ValidGamePhaseRule(Phases.BUILD),
                new ValidPlayerBuildIndexRule(playerName, buildIndex),
                new BuildRessourcesIsEmptyRule(playerName, buildIndex)
        ));
    }

    @Override
    public void apply(Board board) {
        Player player = board.getPlayers().getByName(super.getPlayerName());
        Build build = player.getBuilds().get(buildIndex);

        player.setMoney(player.getMoney() + build.clearReward());
        player.getBuilders().forEach(builder -> {
            if (builder.getAssignedBuild() != null && builder.getAssignedBuild().equals(build)) {
                builder.setAssignedBuild(null);
            }
        });

    }

    @Override
    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("content", "event")
                .add("event", "completeBuild")
                .add("player", getPlayerName())
                .add("buildIndex", buildIndex)
                .build();
    }
}
