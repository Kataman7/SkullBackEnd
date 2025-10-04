package main.domain.events.game;

import main.domain.model.Board;
import main.domain.model.Build;
import main.domain.model.Builder;
import main.domain.rules.*;

import java.util.List;

public class BuyBuildEvent extends PlayerEvent{
    private int value;

    public BuyBuildEvent(String playerName, int value, int cost) {
        super(playerName);
        this.value = value;

        super.getRules().addAll(List.of(
                new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new GameBuyBuildPhase(),
                new PlayerHasEnoughtMoney(getPlayerName(), cost)
        ));
    }

    @Override
    public void apply(Board board) {
        var player = board.getPlayers().getByName(getPlayerName());
        Build build = board.getBuildReveal().get(value);
        player.setMoney(player.getMoney() - build.getCoast());
        player.getBuilds().add(build);
        board.setPlayedPlayersCount(board.getPlayedPlayersCount() + 1);
    }

    @Override
    public String toString() {
        return getPlayerName() + " buys a build.";
    }

}
