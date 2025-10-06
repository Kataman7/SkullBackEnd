package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.rules.*;

import javax.json.Json;
import java.util.List;

public class BuyBuildEvent extends PlayerEvent{
    private final int value;
    private final int cost;

    public BuyBuildEvent(String playerName, int value, int cost) {
        super(playerName);
        this.value = value;
        this.cost = cost;

        super.getRules().addAll(List.of(
                new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new GameBuyBuildPhase(),
                new PlayerHasEnoughtMoneyRule(getPlayerName(), cost)
        ));
    }

    @Override
    public void apply(Board board) {
        var player = board.getPlayers().getByName(getPlayerName());
        Build build = board.getBuildReveal().get(value);
        player.setMoney(player.getMoney() - build.getReward());
        player.getBuilds().add(build);
        board.setPlayedPlayersCount(board.getPlayedPlayersCount() + 1);
    }

    @Override
    public String toJson() {
        return Json.createObjectBuilder()
                .add("event", "buyBuild")
                .add("player", getPlayerName())
                .add("value", value)
                .add("cost", cost)
                .build()
                .toString();
    }

}
