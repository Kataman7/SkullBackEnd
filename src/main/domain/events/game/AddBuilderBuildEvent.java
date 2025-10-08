package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.model.Builder;
import main.domain.model.Player;
import main.domain.rules.*;

import java.util.List;

public class AddBuilderBuildEvent extends PlayerEvent{

    private final int buildIndex;
    private final int builderIndex;

    public AddBuilderBuildEvent(String playerName, int buildIndex, int builderIndex) {
        super(playerName);
        this.buildIndex = buildIndex;
        this.builderIndex = builderIndex;
        super.getRules().addAll(List.of(new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new GameBuildPhaseRule(),
                new PlayerHaveBuildRule(getPlayerName(), buildIndex),
                new PlayerHaveBuilderRule(getPlayerName(), builderIndex)));

    }

    @Override
    public void apply(Board board) {
        Player player = board.getPlayers().getByName(getPlayerName());
        Build build = board.getBuilds().get(buildIndex);
        Builder builder = player.getBuilders().get(builderIndex);

        build.getRessources().remove(builder.getRessources());
        if (builder.isInfected()) builder.setInfected(true);
        builder.setAssignedBuild(build);
    }

    @Override
    public String toJson() {
        return "";
    }
}
