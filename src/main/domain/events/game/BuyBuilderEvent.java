package main.domain.events.game;

import main.domain.enums.Phases;
import main.domain.model.Board;
import main.domain.model.Builder;
import main.domain.rules.*;

import javax.json.Json;
import java.util.List;

public class BuyBuilderEvent extends PlayerEvent {
    private final int builderIndex;
    private final int cost;

    public BuyBuilderEvent(String playerName, int builderIndex,int cost) {
        super(playerName);
        this.builderIndex = builderIndex;
        this.cost = cost;

        super.getRules().addAll(List.of(
                new ValidGamePhaseRule(Phases.BUY_BUILDERS),
                new ValidDeckBuilderIndexRule(builderIndex),
                new ValidPlayerRule(getPlayerName()),
                new PlayerTurnRule(getPlayerName()),
                new PlayerHaveEnoughtMoneyRule(getPlayerName(), cost)
        ));
    }

    @Override
    public void apply(Board board) {
        var player = board.getPlayers().getByName(getPlayerName());
        Builder build = board.getBuidlerReveal().get(builderIndex);
        player.setMoney(player.getMoney() - build.getCost());
        player.getBuilders().add(build);
        board.setPlayedPlayersCount(board.getPlayedPlayersCount() + 1);
    }

    @Override
    public String toJson() {
        return Json.createObjectBuilder()
                .add("event", "buyBuilder")
                .add("player", getPlayerName())
                .add("value", builderIndex)
                .add("cost", cost)
                .build()
                .toString();
    }
}
