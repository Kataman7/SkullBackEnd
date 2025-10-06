package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.model.Builder;
import main.domain.rules.*;

import java.util.List;

public class AddBuilderBuild extends PlayerEvent{

private Build build;
private Builder builder;
    public AddBuilderBuild(String playerName, Build build, Builder builder) {
        super(playerName);
        this.build = build;
        this.builder = builder;
        super.getRules().addAll(List.of(new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new GameBuildPhase(),
                new PlayerHaveBuild(getPlayerName(), build),
                new PlayerHaveBuilder(getPlayerName(), builder)));

    }

    @Override
    public void apply(Board board) {
        var player = board.getPlayers().getByName(getPlayerName());
        player.getBuildByName(build.getName()).addBuilder(builder);

    }

    @Override
    public String toJson() {
        return "";
    }
}
