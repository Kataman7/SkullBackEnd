package main.domain.events.game;

import main.domain.enums.Phases;
import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.rules.*;

import javax.json.Json;
import java.util.List;

public class BuyBuildEvent extends PlayerEvent{
    private final int buildIndex;
    private final int cost;

    public BuyBuildEvent(String playerName, int buildIndex, int cost) {
        super(playerName);
        this.buildIndex = buildIndex;
        this.cost = cost;

        super.getRules().addAll(List.of(
                new ValidGamePhaseRule(Phases.BUY_BUILDS),
                new ValidDeckBuildIndexRule(buildIndex),
                new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new PlayerHaveEnoughtMoneyRule(getPlayerName(), cost)
        ));
    }

    @Override
    public void apply(Board board) {
        var player = board.getPlayers().getByName(getPlayerName());
        Build build = board.getBuildReveal().get(buildIndex);
        player.setMoney(player.getMoney() - build.getReward());
        player.getBuilds().add(build);
        board.setPlayedPlayersCount(board.getPlayedPlayersCount() + 1);
    }

    @Override
    public String toJson() {
        return Json.createObjectBuilder()
                .add("event", "buyBuild")
                .add("player", getPlayerName())
                .add("value", buildIndex)
                .add("cost", cost)
                .build()
                .toString();
    }
}
